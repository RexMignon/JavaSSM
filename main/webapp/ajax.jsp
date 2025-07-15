<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2025/7/2
  Time: 00:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="http://localhost/file/jquery"></script>
</head>
<body>
  <script>
    var userVOList = new Array()
    userVOList.push({
      name:"张三",
      id:"1"
    })
    userVOList.push({
      name:"lisi",
      id:"2"
    })
    var name = "hello"
    var id = 3
    $.ajax({
      type:"POST",
      url:"http://localhost/test/t6",
        data: JSON.stringify(
            {
                userVOList:userVOList,
                name:name,
                age:id
            }
        ),
        contentType:"application/json;charset=utf-8"
    })
  </script>
</body>
</html>
