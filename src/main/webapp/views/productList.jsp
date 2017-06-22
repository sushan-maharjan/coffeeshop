<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product List</title>
</head>
<body>
    <table>
        <tr>
            <th>Product name</th>
            <th>Price</th>
            <th>Product Type</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.productType}</td>
                <td><a href="<c:url value="/productDetail/${product.id}"/>">Edit</a> </td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value="/addProduct"/>">Add Product</a>
</body>
</html>