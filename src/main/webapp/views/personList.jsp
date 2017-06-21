<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Person List</title>
</head>
<body>
<table>
    <tr>
        <th>First name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td><a href="<c:url value="/person/${person.id}"/>">Edit</a> </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/person/new"/>">Add person</a>
</body>
</html>