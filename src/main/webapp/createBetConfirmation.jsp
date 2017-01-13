<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<center>
    <form>
        <h1>You made a bid!</h1>
        <table border="2">
            <tr>
                <td>UserID</td>
                <td>EventID</td>
                <td>BetSum</td>
                <td>BetCondition</td>
            </tr>
            <tr>
                <td> ${data.userId}</td>
                <td> ${data.eventId}</td>
                <td> ${data.betSum}</td>
                <td> ${data.betCondition}</td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>