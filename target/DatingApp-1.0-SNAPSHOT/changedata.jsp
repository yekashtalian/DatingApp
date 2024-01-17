<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your account</title>
    </head>
    <body>
        <form action="UpdateDataServlet" method="POST">
            Name:
            <input type="text" name="name" value="${userData.getName()}"/>
            <br/>
            Surname:
            <input type="text" name="surname" value="${userData.getSurname()}"/>
            <br/>
            Open data:
            <textarea name="odata" rows="5">
                ${userData.getOpenDescription()}
            </textarea><br/>
            Closed data:
            <textarea name="cdata" rows="5">
                ${userData.getClosedDescription()}
            </textarea>
            <br/>
            <input type="submit" value="change data">
        </form>
            <br/>
            Invites:
            <c:forEach var="invite" items="${invites}">
                <form action="AcceptDataServlet" method="POST">
                    <input type="hidden" name="id" value="${invite.getId()}">
                    <input type="submit" value="Accept invite from ${invite.getFromUser().getName()}"/>
                </form>
            </c:forEach>
            <a href="mainpage.jsp">back to main</a>
        </body>
</html>
