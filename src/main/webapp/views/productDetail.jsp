<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<form action="/product/${product.id}" method="post">
    <table>

        <tr>
            <td>Name</td>
            <td><input type="text" name="productName" value="${product.productName}"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${product.price}"/></td>
        </tr>
        <tr>
            <td>Product Type</td>
            <td><input type="text" name="productType" value="${product.productType}"/></td
        </tr>
    </table>
    <input type="submit" value="Update">
</form>
<form action="/product/${product.id}" method="delete">
    <button type="submit">Delete</button>
</form>
</body>
</html>
