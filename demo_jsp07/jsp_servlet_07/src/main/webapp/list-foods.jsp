<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Foods</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
    <header id="header">
        <h1>Food Tracker</h1>
    </header>
</div>

<div id="container">
    <div id="content">
        <!-- Add Food button -->
        <input type="button" value="Add Food" onclick="window.location.href='add-food-form.jsp'; return false;" class="add-food-button" />

        <table>
            <tr>
                <th>Name</th>
                <th>Category ID</th>
                <th>Image</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <c:forEach var="tempFood" items="${FOOD_LIST}">
                <!-- Set up a link for each food -->
                <c:url var="tempLink" value="FoodControllerServlet">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="foodId" value="${tempFood.id}"/>
                </c:url>
                <!-- Set up a link to delete a food -->
                <c:url var="deleteLink" value="FoodControllerServlet">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="foodId" value="${tempFood.id}"/>
                </c:url>
                <tr>
                    <td>${tempFood.name}</td>
                    <td>${tempFood.categoryId}</td>
                    <td>${tempFood.image}</td>
                    <td>${tempFood.description}</td>
                    <td>${tempFood.quantity}</td>
                    <td>${tempFood.price}</td>
                    <td>
                        <a href="${tempLink}" class="update-link">Update</a> |
                        <a href="${deleteLink}" class="delete-link" onclick="if (!(confirm('Are you sure you want to delete this food?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
