<%-- 
    Document   : AddUser
    Created on : May 27, 2024, 11:48:22 AM
    Author     : GKJPW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <center>
        <form action="ConnectServlet" method ="POST">
            
            <table>
                
                <tr>
                <td> ID:  </td>
                <td> <input type="text" name="ID" value=""> </td>            
                </tr>
                
                <tr>                  
                <td> Name: </td>
                <td> <input type="text" name="Name" value=""> </td>
                </tr>
                
                 <tr>                  
                <td> Email: </td>
                <td> <input type="text" name="Email" value=""> </td>
                </tr>
                
                <tr>
                <td> <input type="submit" value="Add User"> </td>
                <td> <input style="float:right" type="reset" value="Clear"> </td>
                </tr>
                
            </table>
            
        </form>
         <form action="DisplayDataServlet" method="POST">
             <input type="submit" value="View Users">
         </form>
    </center>
    </body>
</html>
