<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<jsp:include page="index.html"></jsp:include>
<form method="post" action="login">
    Login <input type="text" name="login"/>
    Password <input type="text" name="password"/>
    <input type="submit" value="Send"/>
    <font color="red">${loginMessage}</font>
</form>
</body>
</html>


