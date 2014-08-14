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
                    <div class="page-title-text">Alarms Event</div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class=''><a href='alarms.html'><span>Alams</span></a></li>
                                <li class='active'><a href='alarms_events.html'><span>Alams Event</span></a></li>
                            </ul>
                        </div>
                        <!-- END MUNU -->    

                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius">Alarm Events list</div>

                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
                                        <a href="#add" class="btn btn-info add-row addrow-btn-left">Add New Row</a>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="form-group visible-sm visible-md visible-lg">
                                            <label class="col-sm-4 col-xs-12 control-label search-text">Search:</label>
                                            <div class="col-sm-8 col-xs-12">
                                                <input id="filter" class="form-control" type="text"/>
                                            </div>
                                        </div>

                                        <div class="form-group visible-xs">
                                            <div class="col-xs-12">
                                                <input id="filter" placeholder="Search" class="form-control" type="text"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <table class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                                Alarm Event 
                                            </th>
                                            <th data-hide="phone">
                                                Alarm Name 
                                            </th>
                                            <th data-hide="phone">
                                                Time
                                            </th>
                                            <th data-hide="phone">
                                                Next Execution
                                            </th>

                                            <th data-hide="phone">
                                                Expiry date
                                            </th>
                                            <th data-hide="phone">
                                                Action
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Isidra</td>
                                            <td><a href="#">Boudreaux</a></td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="78025368997">22 Jun 1972</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Shona</td>
                                            <td>Woldt</td>
                                            <td><a href="#">12:00 P.M</a></td>
                                            <td>Null</td>
                                            <td data-value="370961043292">3 Oct 1981</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Granville</td>
                                            <td>Leonardo</td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="-22133780420">19 Apr 1969</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Easer</td>
                                            <td>Dragoo</td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="250833505574">13 Dec 1977</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Maple</td>
                                            <td>Halladay</td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="694116650726">30 Dec 1991</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Maxine</td>
                                            <td><a href="#">Woldt</a></td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="561440464855">17 Oct 1987</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Lorraine</td>
                                            <td>Mcgaughy</td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="437400551390">11 Nov 1983</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td>Lizzee</td>
                                            <td><a href="#">Goodlow</a></td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="-257733999319">1 Nov 1961</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td>Judi</td>
                                            <td>Badgett</td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="362134712000">23 Jun 1981</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td>Lauri</td>
                                            <td>Hyland</td>
                                            <td>12:00 P.M</td>
                                            <td>Null</td>
                                            <td data-value="500874333932">15 Nov 1985</td>
                                            <td>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button>
                                                <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button>
                                            </td>

                                        </tr>
                                    </tbody>
                                    <tfoot class="hide-if-no-paging">
                                        <tr>
                                            <td colspan="6">
                                                <div class="pagination pagination-centered"></div>
                                            </td>
                                        </tr>
                                    </tfoot>
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
            $(function () {
                $('table').footable().on('click', '.row-delete', function(e) {
                    e.preventDefault();
                    //get the footable object
                    var footable = $('table').data('footable');

                    //get the row we are wanting to delete
                    var row = $(this).parents('tr:first');

                    //delete the row
                    footable.removeRow(row);
                });

                $('.add-row').click(function(e) {
                    e.preventDefault();

                    //get the footable object
                    var footable = $('table').data('footable');

                    //build up the row we are wanting to add
                    var newRow = '<tr><td>Isidra</td><td><a href="#">Boudreaux</a></td><td>12:00 P.M</td><td>Null</td><td data-value="78025368997">22 Jun 1972</td><td><button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</button> <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-trash"></span> Delete</button></td></tr>';

                    //add it
                    footable.appendRow(newRow);
                });
            });
        </script>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/docs.min.js"></script>
    </body>
</html>
