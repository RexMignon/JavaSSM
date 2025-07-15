<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2025/7/2
  Time: 00:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost/test/t5" method="post">
    <%--  表明是第几个User对象的name和id--%>
    <input type="text" name="userVOList[0].name"><br/>
    <input type="text" name="userVOList[1].name"><br/>
    <input type="text" name="userVOList[0].id"><br/>
    <input type="text" name="userVOList[1].id"><br/>
        <input type="text" name="name"><br/>
        <input type="text" name="age"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
