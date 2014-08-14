<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp"></jsp:include>
        </head>

        <body role="document">

        <jsp:include page="headermenu.jsp"></jsp:include>

        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text">Add Purchase Order</div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>

                                <li class='has-sub'><a href='#'><span>ITEMS</span></a>
                                    <ul style='display: block;'>
                                        <li><a href='item.html'><span>Items</span></a></li>
                                        <li><a href='item_category.html'><span>Item Category</span></a></li>
                                        <li class='last'><a href='item_unit.html'><span>Item Units</span></a></li>
                                    </ul>
                                </li>
                                <li class='active'><a href='purchase_order.html'><span>Purchase Order</span></a></li>
                                <li class='last'><a href='purchase_requisition.html'><span>Purchase Requisition</span></a></li>
                            </ul>
                        </div>
                        <!-- END MUNU -->    

                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title top-radius">Purchase Order List</div>

                        <div class="row tb-margin">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-8 visible-lg visible-md visible-sm">

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Number:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Supplier:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <select class="form-control">
                                            <option>Select</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Price:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text">Created at:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>	
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-4 col-xs-12 control-label search-text"> Created by:</label>
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text"/>
                                    </div>
                                </div>

                            </div>

                            <div class="col-sm-8 visible-xs">

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Number:"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <select class="form-control">
                                            <option>Supplier:</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Price:"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Created at:"/>	
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-8 col-xs-12">
                                        <input id="filter" class="form-control" type="text" placeholder="Created by:" />
                                    </div>
                                </div>

                            </div>


                            <div class="col-sm-2"></div>
                        </div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                            <div class="div-center">
                                <button type="button" class="btn btn-orange">Save</button>
                                <button type="button" class="btn btn-orange">Cancel</button>
                            </div>
                        </div>
                        <div class="row text-pad-top visible-xs ">
                            <div class="div-center-xs">
                                <button type="button" class="btn btn-orange">Save</button>
                                <button type="button" class="btn btn-orange">Cancel</button>
                            </div>
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
