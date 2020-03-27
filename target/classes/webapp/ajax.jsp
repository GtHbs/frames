<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        request.setAttribute("path",request.getContextPath());
    %>
    <script src="${path }/staticSource/jquery.js"></script>
</head>
<body>
    <%= new Date() %>
    <a href="${path}/ajax/gatAll">get All</a>
    <div id="dv"></div>
    <form action="${path }/ajax/requestBody" method="post">
        <input type="text" value="alone">
        <input type="text" value="dsx">
        <input type="submit" value="submit">
    </form>
    <a href="${path}/ajax/jsonData" id="ajax">request body</a>
    <a href="${path}/ajax/responseEntity">response entity</a>
    <script>
        $(function () {
            $("a:first").click(function () {
                $.ajax({
                    url:"${path}/ajax/getAll",
                    type:"get",
                    success:function (result) {
                        console.log(result);
                        $.each(result,function () {
                            var info = this.name +":"+this.gender;
                            $('#dv').append(info+"<br/>");
                        });
                    }
                });
                return false;
            });
            $("#ajax").on("click",function () {
                var emp = {name:"alone",gender:'1',email:"alone@qq.com"};
                $.ajax({
                    url:"${path}/ajax/jsonData",
                    type:"post",
                    data:JSON.stringify(emp),
                    contentType:"application/json",
                    success:function (result) {
                        console.log(result);
                    }
                });
                return false;
            });
        });
    </script>
</body>
</html>
