package hanh.crudDemo.jdbc;

import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class FoodDbUtil {

    private DataSource dataSource;

    public FoodDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Food> getFoods() throws Exception {
        List<Food> foods = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            String url = "jdbc:mysql://localhost:3306/restaurant";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);
            // myConn = dataSource.getConnection();

            // create sql statement
            String sql = "SELECT * FROM Food ORDER BY name";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {
                // retrieve data from result set row
                int id = myRs.getInt("id");
                int categoryId = myRs.getInt("CategoryId");
                String name = myRs.getString("Name");
                String image = myRs.getString("Image");
                String description = myRs.getString("Description");
                int quantity = myRs.getInt("Quantity");
                BigDecimal price = myRs.getBigDecimal("Price");

                // create new food object
                Food tempFood = new Food(id, categoryId, name, image, description, quantity, price);

                // add it to the list of foods
                foods.add(tempFood);
            }

            return foods;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void addFood(Food theFood) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            String url = "jdbc:mysql://localhost:3306/restaurant";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);
            // myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "INSERT INTO Food (CategoryId, Name, Image, Description, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the food
            myStmt.setInt(1, theFood.getCategoryId());
            myStmt.setString(2, theFood.getName());
            myStmt.setString(3, theFood.getImage());
            myStmt.setString(4, theFood.getDescription());
            myStmt.setInt(5, theFood.getQuantity());
            myStmt.setBigDecimal(6, theFood.getPrice());

            // execute sql insert
            myStmt.execute();
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public Food getFood(String theFoodId) throws Exception {
        Food theFood = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int foodId;

        try {
            // convert food id to int
            foodId = Integer.parseInt(theFoodId);

            // get connection to database
            String url = "jdbc:mysql://localhost:3306/restaurant";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);
            // myConn = dataSource.getConnection();

            // create sql to get selected food
            String sql = "SELECT * FROM Food WHERE id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, foodId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                int categoryId = myRs.getInt("CategoryId");
                String name = myRs.getString("Name");
                String image = myRs.getString("Image");
                String description = myRs.getString("Description");
                int quantity = myRs.getInt("Quantity");
                BigDecimal price = myRs.getBigDecimal("Price");

                // use the foodId during construction
                theFood = new Food(foodId, categoryId, name, image, description, quantity, price);
            } else {
                throw new Exception("Could not find food id: " + foodId);
            }

            return theFood;
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void updateFood(Food theFood) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            String url = "jdbc:mysql://localhost:3306/restaurant";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);
            // myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "UPDATE Food SET CategoryId=?, Name=?, Image=?, Description=?, Quantity=?, Price=? WHERE id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, theFood.getCategoryId());
            myStmt.setString(2, theFood.getName());
            myStmt.setString(3, theFood.getImage());
            myStmt.setString(4, theFood.getDescription());
            myStmt.setInt(5, theFood.getQuantity());
            myStmt.setBigDecimal(6, theFood.getPrice());
            myStmt.setInt(7, theFood.getId());

            // execute SQL statement
            myStmt.execute();
        } finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public void deleteFood(String theFoodId) throws Exception {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert food id to int
            int foodId = Integer.parseInt(theFoodId);

            // get connection to database
            String url = "jdbc:mysql://localhost:3306/restaurant";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");

            myConn = DriverManager.getConnection(url, username, password);
            // myConn = dataSource.getConnection();

            // create sql to delete food
            String sql = "DELETE FROM Food WHERE id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, foodId);

            // execute sql statement
            myStmt.execute();
        } finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close(); // doesn't really close it ... just puts back in connection pool
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}

