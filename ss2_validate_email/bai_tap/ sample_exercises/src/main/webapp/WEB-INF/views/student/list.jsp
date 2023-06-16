<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2023
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<a href="/create">Thêm Mới Học Viên</a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Gender</th>
        <th scope="col">Birth</th>
        <th scope="col">Class</th>
        <th scope="col">Department</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="student">
        <tr>
            <td><c:out value="${student.id}"></c:out></td>
            <td><c:out value="${student.name}"></c:out></td>
            <td>
                <c:out value="${student.birth}"></c:out>
            </td>
            <td>
            <c:choose>
                <c:when test="${student.gender==true}">
                    Nam
                </c:when>
                <c:otherwise>
                    Nữ
                </c:otherwise>
            </c:choose>
            </td>
            <td><c:out value="${student.nameClass}"></c:out></td>
            <td><c:out value="${student.department}"></c:out></td>
            <td>
            <button type="submit">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
