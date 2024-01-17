<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${userOpened.getName()} Page</title>
    </head>
    <body>
        Name: ${userOpened.getName()}
        <br/>
        Surname: ${userOpened.getSurname()}
        <br/>
        Open data: ${userOpened.getOpenDescription()}
        <c:if test="${isFriend}">
            <br/>
            Closed data: ${userOpened.getClosedDescription()}
        </c:if>
            <br/>
        <c:if test="${userOpened.getUser()!=user}">
            <c:if test="${!isFriend && !isInvited}">
                <form action="InviteServlet" method="POST">
                    <input type="hidden" name="id" value="${userOpened.getId()}"/>
                    <input type="submit" value="Invite to friend list"/>
                </form>
            </c:if>
        </c:if>
        <br/>
        <a href="mainpage.jsp">back to main</a>
    </body>
</html>
