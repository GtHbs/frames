<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("path",request.getContextPath()+"/crud");
    %>
    <%--
        使用springmvc表单标签
    --%>
    <form:form action="${path}/employee" modelAttribute="employee" method="post">

            <%--path:当作原生的name属性
                 自动回显隐含模型中某个对象对应的该属性的值--%>

        Name:<form:input path="name" /><%--<form:errors path="name"/>--%>${errors.name }<br>
        Email:<form:input path="email"/><%--<form:errors path="email"/>--%>${errors.email}<br>
        Gender:
              Male:<form:radiobutton path="gender" value="1"/>
              Female:<form:radiobutton path="gender" value="0"/><br>
        Birth:<form:input path="birth"/><%--<form:errors path="birth"/>--%>${errors.birth}<br>
        Department:
                    <%--每次遍历出来的是一个department对象,itemLabel作为提示信息,itemValue作为提交信息--%>
                <form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
                <br><input type="submit" value="submit">
    </form:form>
    <%--<form href="" method="post">
        Name:<input type="text" name="name"><br>
        Email:<input type="text" name="email"><br>
        Gender:
             Male:<input type="radio" name="gender" value="1">
             Female:<input type="radio" name="gender" value="0"><br>
        Department:
            <select name="department.id">
                <c:forEach items="${departments }" var="dept">
                    <option value="${dept.id }">${dept.departmentName }</option>
                </c:forEach>
            </select>
        <input type="submit" value="submit">
    </form>--%>
</body>
</html>
