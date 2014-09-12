<%-- 
    Document   : add_employee_category
    Created on : Aug 24, 2014, 7:28:43 PM
    Author     : sweta
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>        
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
                    <div class="page-title-text"><spring:message code="attendance.register" text="Label value is missing !!!"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">

                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class='has-sub active'><a href='employee.html'><span><spring:message code="menu.employeemanagement" text="Label value is missing !!!"/></span></a>
                                <li class=''><a href='access_control.html'><span><spring:message code="menu.empmanagement.acl" text="Label value is missing !!!"/></span></a></li>
                                <li class=''><a href='payslips_list.html'><span><spring:message code="menu.payslips" text="Label value is missing !!!"/></span></a></li>
                                <li class='last'><a href='#'><span><spring:message code="menu.employeeleavemanagement" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='leave_types.html'><span><spring:message code="menu.addleavetype" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='hr_attendence.html'><span><spring:message code="menu.attendanceregister" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_attendence_report.html'><span><spring:message code="menu.attendancereport" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='hr_resetleaves.html'><span><spring:message code="menu.resetleave" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>
                                <li class=''><a href='#'><span><spring:message code="menu.settings" text="Label value is missing !!!"/></span></a>
                                    <ul style='display: block;'>
                                        <li><a href='employee_category.html'><span><spring:message code="menu.employeecategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class="active"><a href='employee_department.html'><span><spring:message code="menu.employeedepartment" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='payroll_category.html'><span><spring:message code="menu.payrollcategory" text="Label value is missing !!!"/></span></a></li>
                                        <li class='last'><a href='bank.html'><span><spring:message code="menu.bank" text="Label value is missing !!!"/></span></a></li>
                                    </ul>
                                </li>


                            </ul>
                        </div>
                        <!-- END MUNU -->    
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="attendance.register" text="Label value is missing !!!"/></div>
                        <spring:message text="Default Text" code="payrollcategory.search.placeholder" var="search"/>
                        <div class="tab-content">
                            <div class="tab-pane active" id="demo">
                                <div class="row tb-margin">
                                    <div class="col-sm-4">
                                        <a href="add_attendance.html" class="btn btn-info add-row addrow-btn-left"><spring:message code="add.attendance" text="Label value is missing !!!"/></a>
                                    </div>
                                    <div class="col-sm-4">
                                        <form method="post" action="get_attendance_register.html">
                                            <table width="100%">
                                                <tr>
                                                    <td width="30%">From Date: <input type="text" name="fromDate" id="fromDate" /></td> 
                                                    <td width="5%">&nbsp;</td> 
                                                    <td width="30%">To Date: <input type="text" name="toDate" id="toDate" /></td>
                                                    <td width="30%">Employee: <select  name="employee">
                                                            <c:forEach var="employee" items="${employeeList}">
                                                                <option value="${employee.id}">${employee.employeeNumber}</option>
                                                            </c:forEach>


                                                        </select></td>
                                                    <td width="25%"><input type="submit" value="Date Search" class="btn btn-info add-row addrow-btn-left" /></td>
                                                </tr>
                                            </table>
                                        </form>
                                    </div>
                                    <div class="col-sm-8">

                                    </div>
                                </div>
                                <table id="dttable" class="table table-bordered table-striped" data-filter="#filter" data-page-size="5">
                                    <thead class="orange-bg border-t">
                                        <tr>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.employee" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.date" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.intime" text="Label value is missing !!!"/>
                                            </th>
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.outtime" text="Label value is missing !!!"/>
                                            </th>  
                                            <th data-toggle="true">
                                                <spring:message code="label.attendance.isleave" text="Label value is missing !!!"/>
                                            </th> 
                                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="attendance" items="${attendanceList}">
                                            <tr>
                                                <td>${employee.firstName}(${employee.employeeNumber})</td>
                                                <td>${attendance.attendanceDate}</td>
                                                <td>${attendance.inTime}</td>
                                                <td>${attendance.outTime}</td>
                                                <td>${attendance.isLeave}</td>
<!--                                                <td>
                                                    <a href="edit_payroll_category.html?id=${attendance.id}" class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-edit"></span>Edit</a>

                                                </td>-->
                                            </tr>                                        
                                        </c:forEach>
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
       <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script src="js/dataTables.responsive.min.js"></script>
        <script src="js/ajax-bootstrap3.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#fromDate").datepicker({
                    dateFormat: 'yy/mm/dd'
                });
                $("#toDate").datepicker(
                        {dateFormat: 'yy/mm/dd'});
                var table = $('#dttable').DataTable();
                $('.row-delete').click(function(eve) {
                    var row = this;
                    eve.preventDefault();
                    $.ajax({
                        url: $(row).attr('href')
                        , success: function(response) {
                            if (response === true) {
                                table.row($(row).closest('tr')).remove().draw(false);
                            }
                        }
                    });
                    return false;
                });
            });
        </script>
    </body>
</html>