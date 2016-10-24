<!-- since @v05: This line imports the Spring tags, also template header added -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">

    <div class="container">
    <!-- This classes will be linked through bootstrap automatically -->
        <div class="page-header">
            <h1>All Products in display</h1>
            <p class="lead">Check out all the available products at the moment!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Product Thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                </tr>
            </thead>
            <!-- Browse with jstl for each tag here to go through all products -->
            <c:forEach items="${products}" var="aProduct" >
            <tr>
                <td>
                    <img src="#" alt="image"> <!-- For now no sources so no images loaded but adding DOM object-->
                </td>
                <td>${aProduct.productName}</td>
                <td>${aProduct.productCategory}</td>
                <td>${aProduct.productCondition}</td>
                <td>${aProduct.productPrice} USD</td>
            </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/template/footer.jsp"%>