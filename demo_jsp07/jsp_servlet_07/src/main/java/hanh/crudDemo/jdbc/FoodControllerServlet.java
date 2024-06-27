package hanh.crudDemo.jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Servlet implementation class FoodControllerServlet
 */
@WebServlet("/FoodControllerServlet")
public class FoodControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FoodDbUtil foodDbUtil;

    @Resource(name = "jdbc/restaurant")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our food db util ... and pass in the conn pool / datasource
        try {
            foodDbUtil = new FoodDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            // if the command is missing, then default to listing foods
            if (theCommand == null) {
                theCommand = "LIST";
            }

            // route to the appropriate method
            switch (theCommand) {
                case "ADD":
                    addFood(request, response);
                    break;
                case "LOAD":
                    loadFood(request, response);
                    break;
                case "UPDATE":
                    updateFood(request, response);
                    break;
                case "DELETE":
                    deleteFood(request, response);
                    break;
                default:
                    listFoods(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Redirect POST requests to doGet
    }
    private void deleteFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read food id from form data
        String theFoodId = request.getParameter("foodId");

        // delete food from database
        foodDbUtil.deleteFood(theFoodId);

        // send them back to "list foods" page
        listFoods(request, response);
    }

    private void updateFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read food info from form data
        int id = Integer.parseInt(request.getParameter("foodId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        // create a new food object
        Food theFood = new Food(id, categoryId, name, image, description, quantity, price);

        // perform update on database
        foodDbUtil.updateFood(theFood);

        // send them back to the "list foods" page
        listFoods(request, response);
    }

    private void loadFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read food id from form data
        String theFoodId = request.getParameter("foodId");

        // get food from database (db util)
        Food theFood = foodDbUtil.getFood(theFoodId);

        // place food in the request attribute
        request.setAttribute("THE_FOOD", theFood);

        // send to jsp page: update-food-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-food-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read food info from form data
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        // create a new food object
        Food theFood = new Food(categoryId, name, image, description, quantity, price);

        // add the food to the database
        foodDbUtil.addFood(theFood);

        // send back to main page (the food list)
        listFoods(request, response);
    }

    private void listFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get foods from db util
        List<Food> foods = foodDbUtil.getFoods();

        // add foods to the request
        request.setAttribute("FOOD_LIST", foods);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-foods.jsp");
        dispatcher.forward(request, response);
    }
}

