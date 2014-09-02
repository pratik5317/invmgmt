<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>
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

        <jsp:include page="headermenu.jsp"></jsp:include>

            <div class="container">
                <div class="row container">
                    <div class="dashboard_main">
                        <div class="desh-icon-bg">
                            <img src="img/i-mgmt.png">
                        </div>
                        <div class="page-title-text">Add Item Category</div>
                    </div>
                </div>	
                <div class="row">
                    <div class="col-md-3">
                        <div class="catagory-main-box top-radius">

                            <!--<div class="cat-table-title"></div>-->
                            <!-- MUNU -->    
                            <div id='cssmenu'>
                                <ul>

                                    <li class='has-sub active'><a href='#'><span>ITEMS</span></a>
                                        <ul style='display: block;'>
                                            <li><a href='item.html'><span>Items</span></a></li>
                                            <li><a href='item_category.html'><span>Item Category</span></a></li>
                                            <li class='last'><a href='item_unit.html'><span>Item Units</span></a></li>
                                        </ul>
                                    </li>
                                    <li class=''><a href='purchase_order.html'><span>Purchase Order</span></a></li>
                                    <li class=''><a href='purchase_requisition.html'><span>Purchase Requisition</span></a></li>
                                    <li class='last'><a href='account.html'><span><spring:message code="menu.account" text="Label value is missing !!!"/></span></a></li>
                                </ul>
                            </div>
                            <!-- END MUNU -->    

                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="catagory-main-box top-radius">
                            <div class="cat-box-title cat-title-font top-radius">Item Category </div>

                            <div class="row tb-margin">
                                <div class="col-sm-2"></div>
                            <form:form action="UpdateItemCategory.html" method="POST" commandName="itemTypeForm"> 
                                <form:errors path="*" cssClass="errorblock" element="div" />
                                <form:hidden path="id" />
                                    <div class="col-sm-8 visible-lg visible-md visible-sm">
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text">Name:</label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:input  type="text" class="form-control" path="name" placeholder="Name"/>
                                                <form:errors path="name" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"> Description:</label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:input  type="text" class="form-control" path="description" placeholder="Description"/>
                                                <form:errors path="description" cssClass="error" />
                                            </div>
                                        </div>
                                    </div>                                        
                                    <div class="div-center">
                                        <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();">Save</button>
                                        <button type="button" class="btn btn-orange" onclick="javascript:history.back();">Cancel</button>
                                    </div>
                                </div>
                            </form:form>
                            <form:form action="UpdateItemCategory.html" method="POST" commandName="itemTypeForm"> 
                                <!-- <form:errors path="*" cssClass="errorblock" element="div" /> -->
                                <form:hidden path="id" />
                                <div class="col-sm-8 visible-xs">
                                    <div class="form-group">
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" path="name" placeholder="Name"/>
                                            <form:errors path="name" cssClass="error" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-8 col-xs-12">
                                            <form:input  type="text" class="form-control" path="description" placeholder="Description"/>
                                        </div>
                                    </div>
                                    <div class="div-center-xs">
                                        <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();">Save</button>
                                        <button type="button" class="btn btn-orange" onclick="javascript:history.back();">Cancel</button>
                                    </div>
                                </div>   
                            </form:form>

                            <div class="col-sm-2"></div>
                        </div>


                    </div>
                </div>

            </div>

            <div class=""></div>
            <div class=""></div>


        </div>
        <!-- /container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
