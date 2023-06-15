<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Chuyển đổi từ USD sang VNĐ
</h1>
<br/>
<form action="/transfer" method="post">
    <label for="usd">
        <input type="number" name="usd" id="usd">
    </label>
    <button type="submit">Chuyển Đổi</button>
</form>
<p>${result}</p>
</body>
</html>