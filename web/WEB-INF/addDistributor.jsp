<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 10/8/2016
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="includes/jspheader.jsp"%>
<html>
<head>
    <%@include file="/WEB-INF/includes/htmlhead.jsp" %>
    <title>Add Distributor</title>
    <style>
        h2 {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Distributor</h2>
            <form action-="addDistributor" role="form" method="GET">
                <div class="form-group">
                    <label>Company Name:</label>
                    <input type="text" class="form-control" name=name placeholder="Enter Name"
                           value="${name}">
                </div>

                <div class="form-group">
                    <label>Email:</label>
                    <input type="text" class="form-control" name=email placeholder="Enter Email"
                           value="${email}">
                </div>

                <div class="form-group">
                    <label>Phone:</label>
                    <input type="text" class="form-control" name=phone placeholder="Enter phone #"
                           value="${phone}">
                </div>

                <div class="form-group">
                    <label>Website:</label>
                    <input type="text" class="form-control" name=website placeholder="Enter website"
                           value="${website}">
                </div>

                <div class="form-group">
                    <label>URL Feed:</label>
                    <input type="text" class="form-control" name=urlfeed placeholder="Enter url feed location"
                           value="${urlfeed}">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
    </div>
</body>
</html>
