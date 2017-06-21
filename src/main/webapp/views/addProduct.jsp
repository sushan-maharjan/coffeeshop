<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add a Product</title>
</head>
<body>
<form action="/products" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="productName" /> </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price" /> </td>
        </tr>
        <tr>
            <td>Product Type:</td>
            <td><input type="text" name="productType" /> </td>
        </tr>
    </table>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>