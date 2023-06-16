<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator" method="post">
    <input type="number" name="numberOne">
    <input type="number" name="numberTwo"><br>
    <input type="hidden" name="calculate" id="calculate">
    <button type="submit" onclick="addCalculator('-')">Addition(+)</button>
    <button type="submit" onclick="subCalculator('+')">Subtraction(-)</button>
    <button type="submit" onclick="mulCalculator('*')">Multiplication(X)</button>
    <button type="submit" onclick="diCalculator('/')">Division(/)</button>
</form>
<c:if test="${result!=null}">
    <p>${result}</p>
</c:if>
<script>
    function addCalculator(a) {
        document.getElementById("calculate").value = a;
    }

    function subCalculator(a) {
        document.getElementById("calculate").value = a;
    }

    function mulCalculator(a) {
        document.getElementById("calculate").value = a;
    }

    function diCalculator(a) {
        document.getElementById("calculate").value = a;
    }
</script>
</body>
</html>
