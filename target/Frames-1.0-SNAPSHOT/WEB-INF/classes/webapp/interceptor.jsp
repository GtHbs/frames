<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        application.setAttribute("path",application.getContextPath());
    %>
    <a href="${path}/interceptor/test01">test01</a>
</body>
</html>
