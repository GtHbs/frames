<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/hello">helloWorld</a> <br/>
    <a href="/request/handle">Handler Mapping</a><br/>
    <a href="/request/params">test params</a><br>
    <a href="/request/headers">test header</a><br>
    <a href="/ant1">ant1</a><br>
    <a href="/user/alone">Test path variable</a><br/>
    <a href="/param?name=alone">Test param</a><br>
    <a href="/getHeader">header</a><br>
    <form action="/books" method="post">
        书名:<input type="text" name="bookName"><br>
        作者:<input type="text" name="author"><br>
        价格:<input type="text" name="price"><br>
        库存:<input type="text" name="stock"><br>
        销量:<input type="text" name="sales"><br>
        <hr>
        省份:<input type="text" name="address.province"><br>
        市:<input type="text" name="address.city"><br>
        街道:<input type="text" name="address.street"><br>
        邮编:<input type="text" name="address.post"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
