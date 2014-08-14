<%-- 
    Document   : login
    Created on : 12 Aug, 2014, 4:48:19 PM
    Author     : Aamir Mansuri
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=session.getAttribute("title")!=null?session.getAttribute("title"):"Login"%> </title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap theme -->
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="theme.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <!-- login.jsp -->
        <form:form action="login.htm" method="post"  modelAttribute="loginAttribute">
            <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <th>Username</th>
                    <td><form:input type="text"  class="login-inp" path="name" /></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><form:input type="password" value="************"  onfocus="this.value=''" class="login-inp" path="password"/></td>
                </tr>
<!--                <tr>
                    <th></th>
                    <td valign="top"><input type="checkbox" class="checkbox-size" id="login-check" /><label for="login-check">Remember me</label></td>
                </tr>-->
                <tr>
                    <th></th>
                    <td><input type="submit" class="submit-login"  /></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
