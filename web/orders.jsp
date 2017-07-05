<%-- 
    Document   : orders
    Created on : 2017-6-18, 11:17:35
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="ps" scope="application" class="jsp.beans.WProduct" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WBuy</title>
    </head>
    <body> 
        <form method = "post" action = "myorders.jsp">
           
        <h1>Orders submit!</h1>
        <p>You have choose: <%= ps.getPname() %></p>
        
        <p>How many/much do you want?:</p>
         <input type = "text" name = "n1" />
        <p>Please input your address:</p>
         <input type = "text" name = "a1" />
         <input type = "submit"  value = "Submit" />

         </form>
    </body>
</html>
