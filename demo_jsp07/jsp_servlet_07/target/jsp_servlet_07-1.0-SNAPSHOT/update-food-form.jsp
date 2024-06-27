<!DOCTYPE html>
<html>

<head>
    <title>Update Food</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>Food Tracker</h2>
    </div>
</div>

<div id="container">
    <h3>Update Food</h3>

    <form action="FoodControllerServlet" method="POST" enctype="multipart/form-data">

        <input type="hidden" name="command" value="UPDATE" />
        <input type="hidden" name="foodId" value="${THE_FOOD.id}" />

        <table>
            <tbody>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" value="${THE_FOOD.name}" /></td>
            </tr>

            <tr>
                <td><label>Category ID:</label></td>
                <td><input type="text" name="categoryId" value="${THE_FOOD.categoryId}" /></td>
            </tr>

            <tr>
                <td><label>Current Image:</label></td>
                <td><img src="${THE_FOOD.image}" alt="Current Image" class="current-image" /></td>
            </tr>

            <tr>
                <td><label>New Image:</label></td>
                <td><input type="file" name="image" /></td>
            </tr>

            <tr>
                <td><label>Description:</label></td>
                <td><input type="text" name="description" value="${THE_FOOD.description}" /></td>
            </tr>

            <tr>
                <td><label>Quantity:</label></td>
                <td><input type="text" name="quantity" value="${THE_FOOD.quantity}" /></td>
            </tr>

            <tr>
                <td><label>Price:</label></td>
                <td><input type="text" name="price" value="${THE_FOOD.price}" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="FoodControllerServlet">Back to List</a>
    </p>
</div>
</body>

</html>
