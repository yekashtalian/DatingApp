<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:if test="${empty user}">
        <form action="LoginServlet" method="POST">
            <input type="text" name="log" placeholder="login">
            <input type="password" name="pas" placeholder="password">
            <input type="submit" value="login">
        </form>
        </c:if>
        
        <c:if test="${!empty user}">
        <form action="LogoutServlet" method="POST">
            <input type="submit" value="logout">
        </form>    
        
        <form action="ChangeUserDataServlet" method="POST">
            <input type="submit" value="open profile">
        </form> 
        
        <form action="SearchServlet" method="POST">
            <input type="text" name="search" placeholder="text">
            <input type="submit" value="search">
        </form> 
        
        Users:
        <c:forEach var="user" items="${allUsers}">
            <form action="OpenUserPageServlet" method="POST">
                <input type="hidden" name="id" value="${user.getId()}">
                <input type="submit" value="Open ${user.getName()}'s page"/>
            </form>
        </c:forEach>
        
        </c:if>
        
        
        
    </body>
</html>