<%-- 
    Document   : login
    Created on : 2017-6-9, 19:40:25
    Author     : Administrator
--%>
<%@ page errorPage = "login.jsp" %>

<%-- beans used in this JSP --%>
<jsp:useBean id = "register" scope = "application" 
   class = "WRegister" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WBuy Loading</title>
    </head>
    <body>
        <% 
           String nuid = request.getParameter("uid") ;
           String npw = request.getParameter("pw");
           
            %>
    </body>
</html>
