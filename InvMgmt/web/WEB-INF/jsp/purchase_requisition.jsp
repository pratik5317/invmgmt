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
                    <div class="page-title-text">Item</div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class='has-sub active'><a href='#'><span><spring:message code="menu.ITEMS" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='item.html'><span><spring:message code="menu.Items" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='item_category.html'><span><spring:message code="menu.ItemCategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='item_unit.html'><span><spring:message code="menu.ItemUnits" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>
                                <li class=''><a href='purchase_order.html'><span><spring:message code="menu.PurchaseOrder" text="Label value is missing !!!"/></span></a></li>
                                <li class='last'><a href='purchase_requisition.html'><span><spring:message code="menu.PurchaseRequisition" text="Label value is missing !!!"/></span></a></li>
                            </ul>
                        </div>
                        <!-- END MUNU -->    

                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="purrequisition.list" text="Label value is missing !!!"/></div>
                        <spring:message code="purrequisition.search.placeholder" var="search"/>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
                                        <a href="add-purchase_requisition.html" class="btn btn-info add-row addrow-btn-left"><spring:message code="purrequisition.add" text="Label value is missing !!!"/></a>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="form-group visible-sm visible-md visible-lg">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="purrequisition.search" text="Label value is missing !!!"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <input id="filter" class="form-control" type="text"/>
                                            </div>
                                        </div>

                                        <div class="form-group visible-xs">
                                            <div class="col-xs-12">
                                                <input id="filter" placeholder="${search}" class="form-control" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                                <spring:message code="label.purrequisition.prno" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.purrequisition.supplier" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.purrequisition.status" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.purrequisition.price" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.purrequisition.createdat" text="Label value is missing !!!"/> 
                                            </th>

                                            <th data-hide="phone">
                                                <spring:message code="label.purrequisition.createby" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-sort-ignore="true" data-hide="phone">
                                                <spring:message code="label.purrequisition.approvedby" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone" data-name="Delete">
                                                <spring:message code="label.purrequisition.action" text="Label value is missing !!!"/> 
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="purrequisition" items="${purrequisitionList}">
                                        <tr>
                                            <td>${purrequisition.prno}</td>
                                            <td>Boudreaux</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td>Isidra</td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>                                        
                                    </c:forEach>
                                        <tr>
                                            <td><a href="#">Shona</a></td>
                                            <td>Woldt</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td>Isidra</td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Granville</a></td>
                                            <td>Leonardo</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td data-value="1"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Easer</a></td>
                                            <td>Dragoo</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td>Isidra</td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Maple</a></td>
                                            <td>Halladay</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td data-value="1"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Maxine</a></td>
                                            <td>Woldt</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td>Isidra</td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Lorraine</a></td>
                                            <td>Mcgaughy</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td>Isidra</td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Lizzee</a></td>
                                            <td>Goodlow</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td data-value="1"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Judi</a></td>
                                            <td>Badgett</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td>Isidra</td>
                                            <td>Active</td>
                                            <td>Boudreaux</td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                        <tr>
                                            <td><a href="#">Lauri</a></td>
                                            <td>Hyland</td>
                                            <td>$100.00</td>
                                            <td>$100.00</td>
                                            <td data-value="1"><span class="status-metro status-suspended" title="Suspended">Suspended</span></td>
                                            <td>Active</td>
                                            <td>Boudr<a class="row-delete" href="#"><span class="glyphicon glyphicon-remove"></span></a></td>
                                            <td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td>
                                        </tr>
                                    </tbody>
                                    <tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="8">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>                            
                        </div>

                    </div>
                </div>

            </div>

            <div class=""></div>
            <div class=""></div>


        </div>
        <!-- /container -->






        <!--Responsive Table-->
        <script type="text/javascript">
        </script>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/docs.min.js"></script>
    </body>
</html>
