<%-- 
    Document   : add_creditdebit
    Created on : Sep 24, 2014, 12:24:59 PM
    Author     : ssweta
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp" />
        <script type="text/javascript">
            function submitDetailsForm() {
                return true;
            }
        </script>
        <style>
            .error {
                color: #ff0000;
            }
            .errorblock {
                color: #000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body role="document">

        <c:if test="${creditDebit.id == null}">
            <c:set var="formaction" value="add_creditdebit.html" />
            <spring:message code="label.creditdebit" text="Default Text" var="pagetitletext" />
            <spring:message code="label.add.creditdebit" text="Default Text" var="catboxtitle" />
            <spring:message code="label.creditdebit.save" text="Default Text" var="savebutton" />
        </c:if>
        <c:if test="${creditDebit.id != null}">
            <c:set var="formaction" value="edit_creditdebit.html?id=${creditDebit.id}" />
            <spring:message code="label.creditdebit" text="Default Text" var="pagetitletext" />
            <spring:message code="label.edit.creditdebit" text="Default Text" var="catboxtitle" />
            <spring:message code="label.creditdebit.update" text="Default Text" var="savebutton" />
        </c:if>
        <jsp:include page="headermenu.jsp" />
        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text">${pagetitletext}</div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <%@include  file="finance_mgt_menu.jsp" %>
                        </div>
                        <!-- END MUNU -->    
                    </div>  
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">${catboxtitle}</div>
                        <form:form action="${formaction}" method="post" modelAttribute="creditDebit">
                            <form:hidden path="id"/>
                            <div class="row tb-margin">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-8">
                                    <c:if test="${not empty error}">  
                                        <div class="row text-pad-top"><div class="errorblock">${error}</div></div>
                                        </c:if>
                                        <c:if test="${not empty success}">  
                                        <div class="row text-pad-top"><div class="successblock">${success}</div></div>
                                        </c:if>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.creditdebit.referencenumber" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input type="text" class="form-control" path="referenceNumber" placeholder="Reference Number" />
                                            <form:errors path="referenceNumber" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.creditdebit.creditdebit" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">
                                            <form:select class="form-control" path="creditOrDebit">
                                                <form:option value=""><spring:message code="label.creditdebit.creditdebit.placeholder" text="Default Text"/></form:option>
                                                <form:option value="credit"><spring:message code="label.creditdebit.credit" text="Default Text"/></form:option>
                                                <form:option value="debit"><spring:message code="label.creditdebit.debit" text="Default Text"/></form:option>

                                            </form:select>
                                            <form:errors path="creditOrDebit" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.creditdebit.amount" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="text" class="form-control" path="amount" placeholder="Amount" />
                                            <form:errors path="amount" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.creditdebit.date" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                           <form:input type="date" class="form-control" path="date" placeholder="Date" />
                                            <form:errors path="date" cssClass="error" />
                                        </div>
                                    </div>
                                  
                                    <div class="col-sm-2"></div>
                                </div>
                                <div class="div-center">
                                    <input type="submit" class="btn btn-orange" onclick="return submitDetailsForm();" value="${savebutton}" />
                                    <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.purorder.cancel" text="Default Text"/></button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <div class=""></div>
                <div class=""></div>
            </div>
        </div>
        <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Jquery UI Javascript -->
        <script src="js/jquery-ui.js"></script>
        <script type="text/javascript">
                                            $('input[type=date]').datepicker({dateFormat: 'dd/mm/yy'});
        </script>
    </body>
</html>
