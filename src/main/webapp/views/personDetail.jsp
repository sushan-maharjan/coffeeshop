<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Details</title>
</head>
<body>
<form action="/person/${person.id}" method="post">
    <table>

        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" value="${person.firstName}"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" value="${person.lastName}"/></td>
        </tr>
        <tr>
            <td>Email </td>
            <td><input type="email" name="email" value="${person.email}"/></td>
        </tr>
    </table>
    <input type="submit" value="Update">
</form>
</body>
</html>
