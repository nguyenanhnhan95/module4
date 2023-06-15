<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>
</h1>
<form action="/search" method="post">
    <label for="english" >English
        <input id="english" name="english" type="name" >
    </label>Vietnamese
    <input type="text" readonly value="${result}">
    <button type="submit">Dịch</button>
</form>

</body>
</html>