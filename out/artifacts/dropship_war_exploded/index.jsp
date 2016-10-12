<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 9/16/2016
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="WEB-INF/includes/jspheader.jsp" %>
<html>
  <head>
    <%@include file="/WEB-INF/includes/htmlhead.jsp" %>
    <title>Dashboard</title>
  </head>
  <body>
      <div class="container">
          <div class="nav nav-pills" style="display: inline-block;">
            <li><a id="addDistributorsLink" href="${context}/add-distributor" class="list-group-item">Add Distributors</a></li>
            <li><a id="addInitialItemLink" href="#" class="list-group-item">Add Item</a></li>
            <li><a id="addEbayItemLink" href="#" class="list-group-item">Add Item to Ebay</a></li>
            <li><a id="addAmazonItemLink" href="#" class="list-group-item disabled">Add Item to Amazon</a></li>
            <li><a id="addEtsyItemLink" href="#" class="list-group-item disabled">Add Item to Etsy</a></li>
          </div><!-- list-group end -->
        </div>
      </div>

    <div id="dashboard-iframe">
      <!-- dynamic loading -->
      <!--%@ include file="WEB-INF/addDistributor.jsp"%-->
    </div>
  </body>
</html>
