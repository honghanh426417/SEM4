package hanh.crudDemo.jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/FoodControllerServlet")
@MultipartConfig
public class FoodControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private FoodDbUtil foodDbUtil;

    @Resource(name = "jdbc/restaurant")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            foodDbUtil = new FoodDbUtil(dataSource);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }

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
        doGet(request, response);
    }

    private void deleteFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theFoodId = request.getParameter("foodId");
        foodDbUtil.deleteFood(theFoodId);
        listFoods(request, response);
    }

    private void updateFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("foodId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        Food theFood = new Food(id, categoryId, name, image, description, quantity, price);
        foodDbUtil.updateFood(theFood);
        listFoods(request, response);
    }

    private void loadFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theFoodId = request.getParameter("foodId");
        Food theFood = foodDbUtil.getFood(theFoodId);
        request.setAttribute("THE_FOOD", theFood);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-food-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        Part imagePart = request.getPart("image");
        String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        imagePart.write(uploadPath + File.separator + fileName);

        String imagePath = "uploads" + File.separator + fileName;

        Food theFood = new Food(categoryId, name, imagePath, description, quantity, price);
        foodDbUtil.addFood(theFood);
        listFoods(request, response);
    }

    private void listFoods(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Food> foods = foodDbUtil.getFoods();
        request.setAttribute("FOOD_LIST", foods);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-foods.jsp");
        dispatcher.forward(request, response);
    }
}
