<%-- 
    Document   : login
    Created on : 12 Aug, 2014, 4:48:19 PM
    Author     : Aamir Mansuri
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <style>
            button {
                margin: 0;
                padding: 0;
                border: 0;
                font-weight: normal;
                font-style: normal;
                font-size: 100%;
                line-height: 1;
                font-family: inherit;
            }
            .clearfix:before,
            .clearfix:after {
                display: table;
                content: "";
            }
            .clearfix:after { clear: both }
            html { background-color: white }
            body {
                margin: 0;
                padding: 0;
                color: black;
                font-family: "Helvetica Neue",Helvetica,Arial,Verdana,sans-serif;
                font-size: 13px;
                text-align: center;
            }
            input[type=text]:not(.basic),
            input[type=tel]:not(.basic),
            input[type=email]:not(.basic),
            input[type=password]:not(.basic),
            select:not(.basic),
            textarea:not(.basic) {
                border-radius: 3px;
                -moz-border-radius: 3px;
                -webkit-border-radius: 3px;
                border: 1px solid #ccc;
                display: inline-block;
                font-size: 17px;
                padding: 12px 16px;
                width: 210px;
            }

            input[type=text].error:not(.basic),
            input[type=tel].error:not(.basic),
            input[type=email].error:not(.basic),
            input[type=password].error:not(.basic),
            select.error:not(.basic),
            textarea.error:not(.basic) { border-color: #f90 !important }
            input[type=text].error:focus:not(.basic),
            input[type=tel].error:focus:not(.basic),
            input[type=email].error:focus:not(.basic),
            input[type=password].error:focus:not(.basic),
            select.error:focus:not(.basic),
            textarea.error:focus:not(.basic) {
                box-shadow: inset 0 1px 3px rgba(0,0,0,0.1),0 0 8px rgba(255,153,0,0.4);
                -moz-box-shadow: inset 0 1px 3px rgba(0,0,0,0.1),0 0 8px rgba(255,153,0,0.4);
                -webkit-box-shadow: inset 0 1px 3px rgba(0,0,0,0.1),0 0 8px rgba(255,153,0,0.4);
                border-color: #f90;
            }

            #login {
                border-top: 8px solid #F66F21;
                margin: 0 auto;
                padding: 30px 0 0;
                width: 100%;
            }

            #login form {
                border-radius: 10px;
                -moz-border-radius: 10px;
                -webkit-border-radius: 10px;
                box-sizing: border-box;
                -moz-box-sizing: border-box;
                -wekbit-box-sizing: border-box;
                border: 8px solid #F5F3F0;
                display: inline-block;
                margin: 27px auto 0;
                padding: 60px 50px 45px;
                position: relative;
                z-index: 0;

                background-image: -webkit-linear-gradient(top, #fe7427, #d65907);
                background-image: -moz-linear-gradient(top, #fe7427, #d65907);
                background-image: -o-linear-gradient(top, #fe7427, #d65907);
                background-image: linear-gradient(to bottom, #fe7427, #d65907);
            }
            #login form .form_errors {
                color: #f90;
                display: block;
                font-size: 15px;
                font-weight: 500;
                margin: 0 0 40px;
            }
            #login form .field_container {
                margin: 0 auto 12px;
                text-align: left;
                width: auto;
            }
            #login form .field_container:last-child { margin-bottom: 0 }
            #login form button {
                border-radius: 7px;
                -moz-border-radius: 7px;
                -webkit-border-radius: 7px;
                background-color: transparent;
                cursor: pointer;
                margin-left: 12px;
                height: 56px;
                padding: 5px;
                width: auto;
            }
            #login form button:hover { background-color: transparent; }
            #login form button:active { padding: 5px }
            #login form button:active .button_text {
                box-shadow: 0 0 8px #ccc;
                -moz-box-shadow: 0 0 8px #ccc;
                -webkit-box-shadow: 0 0 8px #ccc;
                background-color: #f6f6f6;
                background-repeat: repeat-x;
                background-image: linear-gradient(top, #f6f6f6, #f6f6f6);
                background-image: -khtml-gradient(linear, left top, left bottom, from(#f6f6f6), to(#f6f6f6));
                background-image: -moz-linear-gradient(top, #f6f6f6, #f6f6f6);
                background-image: -ms-linear-gradient(top, #f6f6f6, #f6f6f6);
                background-image: -o-linear-gradient(top, #f6f6f6, #f6f6f6);
                background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #f6f6f6), color-stop(100%, #f6f6f6));
                background-image: -webkit-linear-gradient(top, #f6f6f6, #f6f6f6);
                height: 46px;
                width: auto;
            }
            #login form button #google_openid_icon {
                background-image: url(https://d2umsx3twley6r.cloudfront.net/assets/website/sprites-57e14dd7782dcbfa62637adc0ad5dba7.png);
                background-position: -211px -414px;
                display: inline-block;
                height: 15px;
                margin-right: 3px;
                position: relative;
                top: -2px;
                vertical-align: middle;
                width: 16px;
            }
            #login form button .button_text {
                border-radius: 4px;
                -moz-border-radius: 4px;
                -webkit-border-radius: 4px;
                box-shadow: 0 0 4px rgba(0,0,0,0.2);
                -moz-box-shadow: 0 0 4px rgba(0,0,0,0.2);
                -webkit-box-shadow: 0 0 4px rgba(0,0,0,0.2);
                background-color: #f0f0f0;
                background-repeat: repeat-x;
                background-image: linear-gradient(top, #fafafa, #f0f0f0);
                background-image: -khtml-gradient(linear, left top, left bottom, from(#fafafa), to(#f0f0f0));
                background-image: -moz-linear-gradient(top, #fafafa, #f0f0f0);
                background-image: -ms-linear-gradient(top, #fafafa, #f0f0f0);
                background-image: -o-linear-gradient(top, #fafafa, #f0f0f0);
                background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa), color-stop(100%, #f0f0f0));
                background-image: -webkit-linear-gradient(top, #fafafa, #f0f0f0);
                color: #000;
                display: inline-block;
                font-size: 16px;
                font-weight: 500;
                height: 46px;
                line-height: 46px;
                padding: 0 25px;
                text-shadow: 1px 1px 0 #fff;
                width: auto;
            }
            #login form input[type=text],
            #login form input[type=email],
            #login form input[type=password] {
                border-color: #F5F3F0;
                border-style: solid;
                border-width: 4px;
                display: inline-block;
                position: relative;
            }
            #login form input[type=text]:focus,
            #login form input[type=email]:focus,
            #login form input[type=password]:focus {
                border-color: #59de2c;
                border-width: 2px;
                padding: 14px 18px;
            }
            #login form input[type=text].error,
            #login form input[type=email].error,
            #login form input[type=password].error {
                border-width: 2px;
                padding: 14px 18px;
            }
            #login form input[type=text][disabled],
            #login form input[type=email][disabled],
            #login form input[type=password][disabled] {
                background-color: #F5F3F0;
                color: #999488;
            }
            #login form .login_link {
                color: #807b6e;
                font-size: 13px;
                font-weight: 500;
            }
            #login form .login_link:hover { color: #f90 }
            #login form#login_form input[type=text],
            #login form#login_form input[type=email],
            #login form#login_form input[type=password] { width: 290px }
            #login form#login_form #google_sign_in_button { display: none }
            #login form#login_form #sign_in_options {
                color: #999488;
                font-size: 13px;
                padding: 30px 0 0;
            }


        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=session.getAttribute("title") != null ? session.getAttribute("title") : "Login"%> </title>

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
        <div id="login">
            <h1 id="login_title">LOGIN</h1>
            <form action="<c:url value="j_spring_security_check" />" id="login_form" method="post">
                <div class="field_container">
                    <input type="text" placeholder="User Name"  name="j_username" class="login-inp" />
                </div>
                <div class="field_container">
                    <input type="Password" placeholder="Password" name="j_password" class="login-inp" />
                    <button id="sign_in_button">
                        <span class="button_text"><input type="submit" class="btn" value="Login"> </span>
                    </button>
                </div>
            </form>            
        </div>
    </body>
</html>
