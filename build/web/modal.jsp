<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : modal
    Created on : 16/08/2019, 04:44:30 PM
    Author     : jorge.lopez
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Styles/css.css" rel="stylesheet" type="text/css"/>
        <link href="Styles/mod.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        
           
                <form action="modal2.jsp" method="POST" >
                <label>Buscar</label>
                <input type ="text" name ="id">
                <input type ="submit"  value="Buscar"><br><br>
                </form>
        
                


    </body>
</html>
