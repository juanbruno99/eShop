<%--
  Created by IntelliJ IDEA.
  User: juanmarcosbruno
  Date: 9/23/16
  Time: 10:53 AM
  since v04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Offered Products</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
            </tr>
        </thead>
        <tr>
            <td><c:out value="${aProduct.productName}"/></td>
            <td><c:out value="${aProduct.productCategory}"/></td>
            <td><c:out value="${aProduct.productCondition}"/></td>
            <td><c:out value="${aProduct.productPrice}"/></td>
        </tr>
    </table>
</body>
</html>
