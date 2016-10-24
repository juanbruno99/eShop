<!-- since @v05: This line imports the Spring tags, also template header added -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">

    <div class="container">
        <!-- This classes will be linked through bootstrap automatically -->
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Detail Information of the product</p>
     </div>

        <div class="container">
            <div class="row">
                <!-- Image division -->
                <div class="col-md-5">
                    <img src="#" alt="imageFilehere" style='width: 100%; height: 300px'/>
                </div>
                <!-- Information division for the product -->
                <div class="col-md-5">
                    <h3>Product Name</h3>
                    <p>Product description here</p>
                    <p>Manufacturer</p>
                    <p>Category</p>
                    <p>Condition</p>
                </div>
            </div>

        </div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
