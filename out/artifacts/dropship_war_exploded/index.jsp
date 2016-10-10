<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 9/16/2016
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="objects.*, java.util.*, java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <%@include file="/WEB-INF/includes/htmlhead.jsp" %>
    <title>Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
          crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>
  </head>
  <body>
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="list-group pull-left">
            <a id="addDistributorsLink" href="#" class="list-group-item" target="dashboard-iframe">
              Add Distributors
            </a>
            
            <a id="addInitialItem" href="#" class="list-group-item" target="dashboard-iframe">
              Add Initial Item
            </a>
          </div><!-- list-group end -->
        </div>
      </div>

    <div id="dashboard-iframe">
      <!-- dynamic loading -->
      <!--%@ include file="WEB-INF/addDistributor.jsp"%-->
    </div>
  </body>
</html>
