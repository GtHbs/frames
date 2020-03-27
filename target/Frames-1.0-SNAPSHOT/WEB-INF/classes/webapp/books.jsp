<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        从页面发起rest请求
        1,配置HiddenHttpMethodFilter拦截器
        2,(1)创建一个post的表单
          (2)表单中携带一个_method的参数
          (3)_method值就是请求方式
    --%>
    <a href="/book/1">查询</a>
    <form action="/book" method="post">
        <input type="submit" value="submit">
    </form>
    <form action="/book/1" method="post">
        <input name="_method" value="delete">
        <input type="submit" value="submit">
    </form>
    <form action="/book/1" method="post">
        <input name="_method" value="put">
        <input type="submit" value="submit">
    </form>
</body>
</html>
