<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 10/8/2016
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        h2 {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div clas="container">
        <h2>Add Initial Item</h2>
        <form action-="addInitialItem" role="form" method="GET">
            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control" name=name placeholder="Enter Item Name"
                       value="${name}">
            </div>

            <div class="form-group">
                <label>Selling Price:</label>
                <input type="text" class="form-control" name=selling_price placeholder="Enter the selling price"
                       value="${selling_price}">
            </div>

            <div class="form-group">
                <label>Cost:</label>
                <input type="text" class="form-control" name=cost placeholder="Enter cost of the item"
                       value="${cost}">
            </div>

            <!-- distributor dropdown list to get their id is preferred-->

            <!-- add directory to add images -->

            <div class="form-group">
                <label>Amount For Sale:</label>
                <input type="text" class="form-control" name=amount_being_sold placeholder="amount"
                       value="${amount_being_sold}">
            </div>

            <div class="form-group">
                <label>Distributor Amount In Stock:</label>
                <input type="text" class="form-control" name=distributor_amount_in_stock placeholder="amount"
                       value="${distributor_amount_in_stock}">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</body>
</html>
