<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="${path }/staticSource/jquery.js"></script>
</head>
<body>
    <%
        request.setAttribute("path",request.getContextPath());
    %>
    <table border="1" cellpadding="5" cellspacing="1" style="text-align: center">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>birth</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.emps }" var="emp">
            <tr>
                <td>${emp.id }</td>
                <td>${emp.name }</td>
                <td>${emp.email }</td>
                <td>${emp.gender == 0 ? 'male' : 'female' }</td>
                <td>${emp.birth }</td>
                <td>${emp.department.departmentName }</td>
                <td><a href="${path }/crud/edit/${emp.id}" >Edit</a></td>
                <td>
                    <form style="text-align: center" id="delete" action="${path}/crud/employee/${emp.id }" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <a href="/crud/add">添加员工</a>
</body>

</html>
