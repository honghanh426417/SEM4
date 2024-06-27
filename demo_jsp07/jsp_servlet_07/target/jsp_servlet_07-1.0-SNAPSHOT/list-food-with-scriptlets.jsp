<%@ page import="java.util.*, hanh.crudDemo.jdbc.Food" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Tracker App</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<%
    // get the foods from the request object (sent by servlet)
    List<Food> theFoods = (List<Food>) request.getAttribute("FOOD_LIST");
%>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Food Tracker</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>Name</th>
                <th>Category ID</th>
                <th>Image</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <% for (Food tempFood : theFoods) { %>
            <tr>
                <td> <%= tempFood.getName() %> </td>
                <td> <%= tempFood.getCategoryId() %> </td>
                <td> <%= tempFood.getImage() %> </td>
                <td> <%= tempFood.getDescription() %> </td>
                <td> <%= tempFood.getQuantity() %> </td>
                <td> <%= tempFood.getPrice() %> </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>
