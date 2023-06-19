<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2023
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/create" method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" name="name" class="form-control" id="name">
    </div>
    <div class="mb-3">
        <input type="radio" name="gender" value="${true}">Nam
        <input type="radio" name="gender" value="${false}">Nữ
    </div>
    <div class="mb-3 ">
        <label for="birth">Birth </label>
        <input type="date" name="birth" class="form-control" id="birth">
    </div>
    <div class="mb-3">
        <label for="class" class="form-label">Class</label>
        <input type="text" name="nameClass" class="form-control" id="class">
    </div>
    <select class="form-select" name="department" aria-label="Default select example">
        <option value="Khoa Điện">Khoa Điện</option>
        <option value="Khoa Hóa">Khoa Hóa</option>
        <option value="Khoa Kỹ Thuật">Khoa Kỹ Thuật</option>
    </select>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
