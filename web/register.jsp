<%-- 
    Document   : register
    Created on : 2017-6-15, 22:45:01
    Author     : Administrator
--%>

<jsp:useBean id = "re" scope = "application" class = "jsp.beans.WRegister"/> 
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <% String name = request.getParameter("uid");
           String password = request.getParameter("pw");
           if(name==null||password==null)
           {
        %>
        <h1>Register</h1>
          <form method = "post" action = "register.jsp">
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
                      
                
                  </td>
               </tr>
            </table>
        </form> 
          <%
              }
                else
          {
            re.getStr(name,password);
            re.result();
          
%>
<h1>Success!<br/>
Welcome to WBuy</h1>
<input type="button" onclick="javascript:window.location.href='index.html';" value="Click to the HomePage" /> 
       
<%

}
              %>
    </body>
</html>
