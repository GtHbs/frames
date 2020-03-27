<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        application.setAttribute("path",application.getContextPath());
    %>
</head>
<body>
    ${msg}
    <form enctype="multipart/form-data" action="${path}/ajax/multiUpload" method="post">
        用户头像:<input type="file" name="photo"><br>
        用户头像:<input type="file" name="photo"><br>
        用户头像:<input type="file" name="photo"><br>
        用户头像:<input type="file" name="photo"><br>
        用户:<input type="text" name="name"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
