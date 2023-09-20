<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
    user name: <input type="text" name="username" />
    age:      <input type="text" name="age" />
    <button type="submit">전송</button>
    
    <br><input type="text" name="testP" value = "p1">
    <br><input type="text" name="testP" value = "p2">
    <br><input type="text" name="testP" value = "p3">
</form>

</body>
</html>