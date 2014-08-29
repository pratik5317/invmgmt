<%-- 
    Document   : add_employee_category
    Created on : Aug 26, 2014, 11:43:53 PM
    Author     : sweta
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <div class="page-title-text"><spring:message code="label.add.employee" text="Default Text"/></div>
                </div>
            </div>	
            <div class="row">
                <div class="col-md-3">
                    <div class="catagory-main-box top-radius">
                        <!--<div class="cat-table-title"></div>-->
                        <!-- MUNU -->    
                        <div id='cssmenu'>
                            <ul>
                                <li class='has-sub active'><a href='employees.html'><span><spring:message code="menu.employeemanagement" text="Label value is missing !!!"/></span></a>
                                <li class=''><a href='payslips.html'><span><spring:message code="menu.payslips" text="Label value is missing !!!"/></span></a></li>
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

                                    </ul>
                                </li>

                            </ul>
                        </div>
                        <!-- END MUNU -->    
                    </div>
                </div>
                <spring:message code="label.employee.number.placeholder" var="employeenumberplaceholder" text="Default Text" />
                <spring:message code="label.employee.joiningdate.placeholder" var="joiningdateplaceholder" text="Default Text" />
                <spring:message code="label.employee.firstname.placeholder" var="firstnameplaceholder" text="Default Text" />     
                <spring:message code="label.employee.lastname.placeholder" var="lastnameplaceholder" text="Default Text" />     
                <spring:message code="label.employee.middlename.placeholder" var="middlenameplaceholder" text="Default Text" /> 
                <spring:message code="label.employee.gender.placeholder" var="genderplaceholder" text="Default Text" /> 
                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.employee" text="Default Text"/></div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                            <form:form action="add_employee.html" method="POST" modelAttribute="employee">                                
                                <div class="row tb-margin">
                                    <div class="col-sm-2"></div>
                                    <div class="col-sm-8">
                                        <c:if test="${not empty error}">  
                                            <div class="row text-pad-top visible-lg visible-md visible-sm"><div class="errorblock">${error}</div></div>
                                            </c:if>
                                            <c:if test="${not empty success}">  
                                            <div class="row text-pad-top visible-lg visible-md visible-sm"><div class="successblock">${success}</div></div>
                                            </c:if>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.number" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="employeeNumber" placeholder="${employeenumberplaceholder}" />
                                                <form:errors path="employeeNumber" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.category" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="employeeCategoryId">
                                                    <form:option value=""><spring:message code="label.employee.category.placeholder" text="Default Text"/></form:option>
                                                    <form:options items="${employeeCategoryList}" itemLabel="category" itemValue="id"/>
                                                </form:select>
                                                <form:errors path="employeeCategoryId" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.employee.joiningdate" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="date" class="form-control" path="joiningDate" placeholder="${joiningdateplaceholder}" />
                                                <form:errors path="joiningDate" cssClass="error" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.firstname" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="firstName" placeholder="${firstnameplaceholder}" />
                                                <form:errors path="firstName" cssClass="error" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.lastname" text="Default Text"/></label>
                                        <div class="col-sm-8 col-xs-12">                                            
                                            <form:input type="text" class="form-control" path="lastName" placeholder="${lastnameplaceholder}" />
                                            <form:errors path="lastName" cssClass="error" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.middlename" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">                                            
                                    <form:input type="text" class="form-control" path="middleName" placeholder="${middlenameplaceholder}" />
                                    <form:errors path="middleName" cssClass="error" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.gender" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">
                                    <div class="form-control">
                                        <form:radiobutton path="gender" value="1" checked="checked"/><spring:message code="label.employee.male" text="Default Text"/>
                                        <form:radiobutton path="gender" value="0" /><spring:message code="label.employee.female" text="Default Text"/>
                                    </div>
                                    <form:errors path="gender" cssClass="error" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.jobtitle" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">                                            
                                    <form:input type="text" class="form-control" path="jobTitle" placeholder="${jobtitleplaceholder}" />
                                    <form:errors path="jobTitle" cssClass="error" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.Department" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">
                                    <form:select class="form-control" path="employeeCategoryId">
                                        <form:option value=""><spring:message code="label.employee.department.placeholder" text="Default Text"/></form:option>
                                        <form:options items="${employeeDepartmentList}" itemLabel="department" itemValue="id"/>
                                    </form:select>
                                    <form:errors path="employeeDepartmentId" cssClass="error" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.reportingmanager" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">
                                    <form:select class="form-control" path="reportingManagerId">
                                        <form:option value=""><spring:message code="label.employee.department.placeholder" text="Default Text"/></form:option>
                                        <form:options items="${employeeList}" itemLabel="employeeNumber" itemValue="id"/>
                                    </form:select>
                                    <form:errors path="reportingManagerId" cssClass="error" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.qualification" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">                                            
                                    <form:input type="text" class="form-control" path="qualification" placeholder="${qualificationplaceholder}" />
                                    <form:errors path="qualification" cssClass="error" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.experiencedetail" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">                                            
                                    <form:textarea path="experienceDetail" rows="5" cols="30"  placeholder="${experiencedetailplaceholder}" />
                                    <form:errors path="experienceDetail" cssClass="error" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.expyears" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">                                            
                                    <form:input type="text" class="form-control" path="experienceYear" placeholder="${expyearsplaceholder}" />
                                    <form:errors path="experienceYear" cssClass="error" />
                                </div>
                            </div>
                                <div class="form-group">
                                <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.employee.expmonths" text="Default Text"/></label>
                                <div class="col-sm-8 col-xs-12">                                            
                                    <form:input type="text" class="form-control" path="experienceMonth" placeholder="${expmonthsplaceholder}" />
                                    <form:errors path="experienceMonth" cssClass="error" />
                                </div>
                            </div>
                                 <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text visible-lg visible-md visible-sm"><spring:message code="label.employee.birthdate" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="date" class="form-control" path="dateOfBirth" placeholder="${birthdatedateplaceholder}" />
                                                <form:errors path="dateOfBirth" cssClass="error" />
                                            </div>
                                        </div>
                            <div class="col-sm-2"></div>
                        </div>
                        <div class="div-center">
                            <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();"><spring:message code="label.save" text="Default Text"/></button>
                            <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.cancel" text="Default Text"/></button>
                        </div>
                    </form:form>
                </div>
            </div>
            <!--                        <div class="row text-pad-top visible-xs">
                                       
                                    </div>-->
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