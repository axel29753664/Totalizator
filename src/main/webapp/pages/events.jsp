<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
</head>
<body>
<jsp:include page="userPage.jsp"></jsp:include>


<form name="eventTable" action="events" method="post">
    <table border="2">
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Winning condition description</td>
            <td>Coefficient</td>
            <td>Current bet side</td>
        </tr>
        <c:forEach items="${eventList}" var="event">
            <tr>
                <td> ${event.eventName}</td>
                <td> ${event.eventDescription}</td>
                <td> ${event.winDescription}</td>
                <td> ${event.coefficient}</td>
                <td> ${event.betSide}</td>
                <td>
                    <label>
                        <input type="button" value="Make bet"
                               onclick="document.getElementById('betEvent').value = ${event.eventId};
                                       document.eventTable.submit(); "/>
                    </label>

                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="betEvent" value="" name="betEventId"/>
</form>
<input type="button" onclick="history.back();" value="Back"/>
</body>
</html>
