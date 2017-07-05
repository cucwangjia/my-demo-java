<%-- 
    Document   : home
    Created on : 2017-6-15, 22:55:38
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="user" scope="application" class="jsp.beans.WCheck" />
<jsp:useBean id="ps" scope="application" class="jsp.beans.WProduct" />
<jsp:useBean id="allo" scope="application" class="jsp.beans.WOrders" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WBuy</title>
        <style type = "text/css">
      body { 
         font-family: tahoma, helvetica, arial, sans-serif;
      }

      table, tr, td { 
         font-size: .9em;
         border: 3px groove;
         padding: 5px;
         background-color: #dddddd;
      }
   </style>
    </head>
    
    <body>
        
        <%
            String nn = request.getParameter("uid");
            String pp = request.getParameter("pw");
          
            if(nn.equals("")||pp.equals(""))
            { %>
           
            <form method = "post" action = "home.jsp">
             <p>Please input your id and password!</p>
            <table>
                <tr>Log in</tr>
               <tr>
                  <td>your id:</td>

                  <td>
                     <input type = "text" name = "uid" />
                  </td>
               </tr>

               <tr>
                  <td>your password:</td>

                  <td>
                     <input type = "password" name = "pw" />
                  </td>
               </tr>

               <tr>
                  <td colspan = "2">
                     <input type = "submit"  value = "Submit" />
                     <input type="button" onclick="javascript:window.location.href='register.jsp';" value="Register" /> 
                     
                  </td>
               </tr>
            </table>
           
        </form> 

        <%  }
             else 
             {
            user.setUid(nn);
            user.setUpw(pp);
            int flag = user.result(); 
            if(flag!=1)
            {
        %>
              <p>Your id or password is wrong!Please try it again.</p>
            <form method = "post" action = "home.jsp">
            <table>
            
               <tr>
                  <td>your id:</td>

                  <td>
                     <input type = "text" name = "uid" />
                  </td>
               </tr>

               <tr>
                  <td>your password:</td>

                  <td>
                     <input type = "password" name = "pw" />
                  </td>
               </tr>

               <tr>
                  <td colspan = "2">
                     <input type = "submit"  value = "Submit" />
                     <input type="button" onclick="javascript:window.location.href='register.jsp';" value="Register" /> 
                     
                  </td>
               </tr>
            </table>  
        </form>       
            <%
                }
                else
                {   
                  int n = user.getUno();
                      allo.setUno(n); 
                   %>
               <h1>Hello <%= nn %>, <br/>
                Welcome to WBuy!</h1>
               <form method = "post" action = "orders.jsp">
                 <table>
               <tr>
                  <td>name:</td>
                  <td>Cookies</td>
               </tr>
               <tr>
                  <td>price:</td>
                  <td>$3</td>
               </tr>
               <tr>
                   <td colspan = "2">
                   <input type = "submit"   value = "Buy it!" />
                   <%
                       ps.setUno(n);
                       ps.setUid(nn);
                       ps.getPno("Cookies");
                       %>
                   </td>
               </tr>
               </form>
            
            <% } 
          }%>
    </body>
</html>

