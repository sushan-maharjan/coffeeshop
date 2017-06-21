<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order List</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th>Order Id</th>
        <th>Order Date</th>
        <th>Order Line</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.orderDate}</td>
            <td><a class="btn btn-info " href="#">Order Line</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>