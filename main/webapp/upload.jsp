<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2025/7/6
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <form action="test/t11" method="post" enctype="multipart/form-data">
   <label>
     名称
     <input type="text" name="username">
   </label><br/>
   文件<input type="file" name="upload"><br/>
     文件2<input type="file" name="uploadFile"><br/>
   <input type="submit" value="提交">
 </form>
</body>
</html>
