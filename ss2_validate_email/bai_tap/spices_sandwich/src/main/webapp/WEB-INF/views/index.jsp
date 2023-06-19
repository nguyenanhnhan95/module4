<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<form action="/save" method="post">
    <table>
        <tr>
            <td><input type="checkbox"  name="condiment" value="Lettuce">Lettuce</td>
            <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
            <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
            <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
        </tr>
    </table>
    <hr>
    <button type="submit" onclick="check()">Save</button>
</form>
<c:if test="${choice!=null}">
    ${choice}
</c:if>
</body>
</html>