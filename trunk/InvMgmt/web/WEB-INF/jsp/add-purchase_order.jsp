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
                        <div class="page-title-text"><spring:message code="label.add.purchaseorder" text="Default Text"/></div>
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
                <spring:message code="label.account.name.placeholder" var="accountnameplaceholder" />
                <spring:message code="label.account.address.placeholder" var="accountaddressplaceholder" />
                <spring:message code="label.account.address2.placeholder" var="accountaddressplaceholder2" />
                <spring:message code="label.account.postal.placeholder" var="accountpostalplaceholder" />
                <spring:message code="label.account.city.placeholder" var="accountcityplaceholder" />
                <spring:message code="label.account.state.placeholder" var="accountstateplaceholder" />
                <spring:message code="label.account.country.placeholder" var="accountcountryplaceholder" />
                <spring:message code="label.account.firstname.placeholder" var="accountfirstnameplaceholder" />
                <spring:message code="label.account.email.placeholder" var="accountemailplaceholder" />
                <spring:message code="label.account.phone.placeholder" var="accountphoneplaceholder" />
                <spring:message code="label.account.phone2.placeholder" var="accountphoneplaceholder2" />
                <spring:message code="label.account.fax.placeholder" var="accountfaxplaceholder" />
                <spring:message code="label.account.notes.placeholder" var="accountnotesplaceholder" />
                <spring:message code="label.account.maxdebt.placeholder" var="accountmaxdebtplaceholder" />
                <spring:message code="label.account.curdebt.placeholder" var="accountcurdebtplaceholder" />
                <spring:message code="label.account.image.placeholder" var="accountimageplaceholder" />

                <div class="col-md-9">
                    <div class="catagory-main-box top-radius">
                        <div class="cat-box-title cat-title-font top-radius"><spring:message code="label.account" text="Default Text"/></div>
                        <div class="row text-pad-top visible-lg visible-md visible-sm">
                            <form:form action="add-account.html" method="POST" modelAttribute="account" enctype="multipart/form-data">                                
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
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.name" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="name" placeholder="${accountnameplaceholder}" />
                                                <form:errors path="name" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.type" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="type">
                                                    <form:option value=""><spring:message code="label.account.type.placeholder" text="Default Text"/></form:option>
                                                    <form:option value="1">Supplier</form:option>
                                                </form:select>
                                                <form:errors path="type" cssClass="error" />
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.address" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="address" placeholder="${accountaddressplaceholder}" />
                                                <form:errors path="address" cssClass="error" />
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.address2" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">
                                                <form:input type="text" class="form-control" path="address2" placeholder="${accountaddressplaceholder2}" />
                                                <form:errors path="address2" cssClass="error" />
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.postal" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="postal" placeholder="${accountpostalplaceholder}" />
                                                <form:errors path="postal" cssClass="error" />
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.city" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="city" placeholder="${accountcityplaceholder}" />
                                                <form:errors path="city" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.state" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="state" placeholder="${accountstateplaceholder}" />
                                                <form:errors path="state" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.country" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="country" placeholder="${accountcountryplaceholder}" />
                                                <form:errors path="country" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.firstname" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="firstname" placeholder="${accountfirstnameplaceholder}" />
                                                <form:errors path="firstname" cssClass="error" />
                                            </div>
                                        </div>



                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.lastname" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="lastname" placeholder="${accountlastnameplaceholder}" />
                                                <form:errors path="lastname" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.email" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="email" placeholder="${accountemailplaceholder}" />
                                                <form:errors path="email" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.phone" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="phone" placeholder="${accountphoneplaceholder}" />
                                                <form:errors path="phone" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.phone2" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="phone2" placeholder="${accountphoneplaceholder2}" />
                                                <form:errors path="phone2" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.fax" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="fax" placeholder="${accountfaxplaceholder}" />
                                                <form:errors path="fax" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.notes" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="notes" placeholder="${accountnotesplaceholder}" />
                                                <form:errors path="notes" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.maxdebt" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="maxdebt" placeholder="${accountmaxdebtplaceholder}" />
                                                <form:errors path="maxdebt" cssClass="error" />
                                            </div>
                                        </div>                                    

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.curdebt" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="curdebt" placeholder="${accountcurdebtplaceholder}" />
                                                <form:errors path="curdebt" cssClass="error" />
                                            </div>
                                        </div>                                        

                                        <div class="form-group">
                                            <label class="col-sm-4 col-xs-12 control-label search-text"><spring:message code="label.account.image" text="Default Text"/></label>
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <input type="file" name="imageUpload" placeholder="${accountimageplaceholder}" />
                                                <form:errors path="image" cssClass="error" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-2"></div>
                                </div>

                                <div class="div-center">
                                    <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();"><spring:message code="label.account.save" text="Default Text"/></button>
                                    <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.account.cancel" text="Default Text"/></button>
                                </div>
                            </form:form>
                        </div>
                        <div class="row text-pad-top visible-xs">
                            <form:form action="add-account.html" method="POST" modelAttribute="account" enctype="multipart/form-data">
                                <div class="row tb-margin">
                                    <div class="col-sm-2"></div>
                                    <div class="col-sm-8">
                                        
                                        <c:if test="${not empty error}">  
                                            <div class="row text-pad-top visible-xs"><div class="errorblock">${error}</div></div>
                                        </c:if>
                                        <c:if test="${not empty success}">  
                                            <div class="row text-pad-top visible-xs"><div class="successblock">${success}</div></div>
                                        </c:if>
                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="name" placeholder="${accountnameplaceholder}" />
                                                <form:errors path="name" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">
                                                <form:select class="form-control" path="type">
                                                    <form:option value=""><spring:message code="label.account.type.placeholder" text="Default Text"/></form:option>
                                                    <form:option value="1">Supplier</form:option>
                                                </form:select>
                                                <form:errors path="type" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="address" placeholder="${accountaddressplaceholder}" />
                                                <form:errors path="address" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">
                                                <form:input type="text" class="form-control" path="address2" placeholder="${accountaddressplaceholder2}" />
                                                <form:errors path="address2" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="postal" placeholder="${accountpostalplaceholder}" />
                                                <form:errors path="postal" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="city" placeholder="${accountcityplaceholder}" />
                                                <form:errors path="city" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="state" placeholder="${accountstateplaceholder}" />
                                                <form:errors path="state" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="country" placeholder="${accountcountryplaceholder}" />
                                                <form:errors path="country" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="firstname" placeholder="${accountfirstnameplaceholder}" />
                                                <form:errors path="firstname" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="lastname" placeholder="${accountlastnameplaceholder}" />
                                                <form:errors path="lastname" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="email" placeholder="${accountemailplaceholder}" />
                                                <form:errors path="email" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="phone" placeholder="${accountphoneplaceholder}" />
                                                <form:errors path="phone" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="phone2" placeholder="${accountphoneplaceholder2}" />
                                                <form:errors path="phone2" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="fax" placeholder="${accountfaxplaceholder}" />
                                                <form:errors path="fax" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="notes" placeholder="${accountnotesplaceholder}" />
                                                <form:errors path="notes" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="maxdebt" placeholder="${accountmaxdebtplaceholder}" />
                                                <form:errors path="maxdebt" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <form:input type="text" class="form-control" path="curdebt" placeholder="${accountcurdebtplaceholder}" />
                                                <form:errors path="curdebt" cssClass="error" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-sm-8 col-xs-12">                                            
                                                <input type="file" name="imageUpload" placeholder="${accountimageplaceholder}" />
                                                <form:errors path="image" cssClass="error" />
                                            </div>
                                        </div>

                                    </div>

                                    <div class="col-sm-2"></div>
                                </div>
                                <div class="div-center-xs">
                                    <button type="submit" class="btn btn-orange" onclick="return submitDetailsForm();"><spring:message code="label.account.save" text="Default Text"/></button>
                                    <button type="button" class="btn btn-orange" onclick="javascript:history.back();"><spring:message code="label.account.cancel" text="Default Text"/></button>
                                </div>                                
                            </form:form>
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