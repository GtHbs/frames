<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("path",request.getContextPath()+"/crud");
    %>
    <form:form action="${path }/employee/${employee.id}" method="post" modelAttribute="employee">
        <input type="hidden" name="_method" value="put"><br>
        <input type="hidden" name="id" value="${employee.id }">
        Email:<form:input path="email"/>
        gender:Male:<form:radiobutton path="gender" value="1"/>
               Female:<form:radiobutton path="gender" value="0"/>
        Department:
              <form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
            <input type="submit" value="submit">
    </form:form>
</body>
</html>
