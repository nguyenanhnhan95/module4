<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
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
<h2>Settings</h2>
<form:form action="/edit" modelAttribute="email" method="post">
    <table>
        <tr>
            <td><label for="language">Language</label></td>
            <td>
                <form:select path="language" id="language" items="${languages}"></form:select>
            </td>
        </tr>
        <tr>
            <td><label for="size">Page Size</label>
            </td>
            <td>
                show
                <form:select path="size" id="size" items="${sizes}"/>email per page
            </td>
        </tr>
        <tr>
            <td><label for="spam">Page Size</label></td>
            <td>
                <form:checkbox path="spamFilter" id="spam"/>Enable spams filter
            </td>
        </tr>
        <tr>
            <td><label for="signature">Signature</label></td>
            <td>
                <form:textarea path="signature" id="signature" value="${sinature}"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Edit</button>
                <button type="button">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>