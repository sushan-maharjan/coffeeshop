<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add a Person</title>
</head>
<body>
<form action="/person" method="post">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" /> </td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName" /> </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" /> </td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><input type="text" name="phone" /> </td>
        </tr>
    </table>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>