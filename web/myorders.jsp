<%-- 
    Document   : myorders
    Created on : 2017-6-18, 13:47:24
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="allo" scope="application" class="jsp.beans.WOrders" />
<jsp:useBean id="ps" scope="application" class="jsp.beans.WProduct" />
<jsp:useBean id="user" scope="application" class="jsp.beans.WCheck" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  String name = user.getUid();
            String ads = request.getParameter("a1"); 
            String nu = request.getParameter("n1");
            ps.getAdd(ads);
            ps.getPnum(nu);
            ps.AddOrder();
            %>
        <h1>Hello , <%= name %>!<br/>
        Your Orders:</h1>
        <% int uno = user.getUno();
           allo.setUno(uno);
           String allorders = allo.getAll();
           %>
           <p>Pno   Pname  PerPrice  Number  Address</p>
        <p> <%= allorders %> </p>
    </body>
</html>
