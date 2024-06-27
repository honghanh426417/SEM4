<!DOCTYPE html>
<html>

<head>
    <title>Add Food</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>CodeLean Restaurant</h2>
    </div>
</div>

<div id="container">
    <h3>Add Food</h3>

    <form action="FoodControllerServlet" method="POST">

        <input type="hidden" name="command" value="ADD" />

        <table>
            <tbody>
            <tr>
                <td><label>Category ID:</label></td>
                <td><input type="text" name="categoryId" /></td>
            </tr>

            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" /></td>
            </tr>

            <tr>
                <td><label>Image URL:</label></td>
                <td><input type="text" name="image" /></td>
            </tr>

            <tr>
                <td><label>Description:</label></td>
                <td><input type="text" name="description" /></td>
            </tr>

            <tr>
                <td><label>Quantity:</label></td>
                <td><input type="text" name="quantity" /></td>
            </tr>

            <tr>
                <td><label>Price:</label></td>
                <td><input type="text" name="price" /></td>
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
