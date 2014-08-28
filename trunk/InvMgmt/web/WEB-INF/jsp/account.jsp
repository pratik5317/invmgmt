<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <%--<%@include file="header.jsp" %>--%>
        <jsp:include page="header.jsp" />
    </head>

    <body role="document">

        <jsp:include page="headermenu.jsp" />

        <div class="container">
            <div class="row container">
                <div class="dashboard_main">
                    <div class="desh-icon-bg">
                        <img src="img/i-mgmt.png">
                    </div>
                    <div class="page-title-text"><spring:message code="account.accountlist" text="Label value is missing !!!"/></div>
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
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="account.accountlist" text="Label value is missing !!!"/></div>

                        <spring:message text="Default Text" code="account.search.placeholder" var="search"/>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
                                        <a href="add-account.html" class="btn btn-info add-row addrow-btn-left"><spring:message code="account.addaccount" text="Label value is missing !!!"/></a>
                                    </div>
                                    <div class="col-sm-8">
                                        <!--<div class="form-group visible-sm visible-md visible-lg">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="account.search" text="Label value is missing !!!"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <input id="filter" class="form-control" type="text" placeholder="${search}" />
                                            </div>
                                        </div>

                                        <div class="form-group visible-xs">
                                            <div class="col-xs-12">
                                                <input id="filter" placeholder="${search}" class="form-control" type="text"/>
                                            </div>
                                        </div> -->                                        
                                    </div>
                                </div>
                                <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                                <spring:message code="label.account.name" text="Label value is missing !!!"/> 
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.account.city" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-hide="phone">
                                                <spring:message code="label.account.curdebt" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-sort-ignore="true" data-hide="phone" data-name="Delete"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="account" items="${accountList}">
                                            <tr>
                                                <input type="hidden" id="deleteInvTypeId" name="deleteInvTypeId" value="<c:out value="${account.id}"/>" />
                                                <td><a href="edit-account.html?id=${account.id}"><c:out value="${account.name}"/></a></td>
                                                <td><c:out value="${account.city}"/></td>
                                                <td><c:out value="${account.curdebt}" /></td>
                                                <td>
                                                    <a class="row-delete" href="delete-account.html?id=${account.id}"><span class="glyphicon glyphicon-remove"></span></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <!--<tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="4">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>-->
                                </table>
                            </div>
                            <div class="tab-pane" id="docs">
                                <h3>Removing A Row</h3>
                                <p>It is recommended to use the built-in <code>removeRow</code> function when deleting rows from a FooTable. The reasons are:</p>
                                <ul>
                                    <li>A detail row, that may or may not be generated when a breakpoint is fired, is also deleted</li>
                                    <li>The correct FooTable events are fired which triggers a redraw. This also forces the sorting, filtering and pagination add-ons to play nicely.</li>
                                </ul>
                                <p>Simply pass the row object into the <code>removeRow</code> function. (The row object can be a jQuery object or not)</p>
                                <pre>
$(&#39;table&#39;).footable().on(&#39;click&#39;, &#39;.row-delete&#39;, function(e) {
    e.preventDefault();
    //get the footable object
    var footable = $(&#39;table&#39;).data(&#39;footable&#39;);

    //get the row we are wanting to delete
    var row = $(this).parents(&#39;tr:first&#39;);

    //delete the row
    footable.removeRow(row);
});</pre>
                                <h3>Adding A Row</h3>
                                <p>For similar reasons as above, it is recommended to use the built-in <code>appendRow</code> function for adding rows to the FooTable:</p>
                                <pre>
$(&#39;.add-row&#39;).click(function(e) {
    e.preventDefault();

    //get the footable object
    var footable = $(&#39;table&#39;).data(&#39;footable&#39;);

    //build up the row we are wanting to add
    var newRow = &#39;&lt;tr&gt;&lt;td&gt;Isidra&lt;/td&gt;&lt;td&gt;&lt;a href=&quot;#&quot;&gt;Boudreaux&lt;/a&gt;&lt;/td&gt;&lt;td&gt;Traffic Court Referee&lt;/td&gt;&lt;td data-value=&quot;78025368997&quot;&gt;22 Jun 1972&lt;/td&gt;&lt;td data-value=&quot;1&quot;&gt;&lt;span class=&quot;status-metro status-active&quot; title=&quot;Active&quot;&gt;Active&lt;/span&gt;&lt;/td&gt;&lt;td&gt;&lt;a class=&quot;row-delete&quot; href=&quot;#&quot;&gt;&lt;span class=&quot;glyphicon glyphicon-remove&quot;&gt;&lt;/span&gt;&lt;/a&gt;&lt;/td&gt;&lt;/tr&gt;&#39;;

    //add it
    footable.appendRow(newRow);
});</pre>
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
            $(document).ready(function() {
                $('.row-delete').click(function(eve) {
                    var row = this;
                    eve.preventDefault();
                    $.ajax({
                        url: $(row).attr('href')
                        , success: function(response) {
                            if (response === true) {
                                $(row).closest('tr').remove();
                            }
                        }
                    });
                    return false;
                });
            });
        </script>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.responsive.min.js"></script>
        <script src="js/ajax-bootstrap3.js"></script>
        <script src="js/docs.min.js"></script>        
    </body>
</html>
