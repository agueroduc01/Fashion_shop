<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Riode - Manage Account</title>
    <base href="${pageContext.servletContext.contextPath}/">
    <link rel="icon" type="image/png" href="https://d-themes.com/html/riode/images/icons/favicon.png">

    <link href="<c:url value='/resources/home/dist/css/reset.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/home/dist/css/adminEditProd.css' />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
    
    <aside class="aside">
        <a href="admin/adminHome.htm" class="admin">
            <div class="logo">
                <i class="fa-solid fa-a"></i>
            </div>
            Admin
        </a>

        <ul class="functions">
            <li class="function">
                <a href="admin/adminAccount.htm" >
                    <div class="icon">
                        <i class="fa-solid fa-users"></i>
                    </div>
                    Account 
                </a>
            </li>

            <li class="function">
                <a href="admin/adminBill.htm">
                    <div class="icon">
                        <i class="fa-solid fa-receipt"></i>

                    </div>
                    Bill 
                </a>
            </li>

            <li class="function">
                <a href="admin/adminProducts.htm" class="active">
                    <div class="icon">
                        <i class="fa-solid fa-shirt"></i>
                    </div>
                    Products 
                </a>
            </li>

            
        </ul>

        <button class="btn-log-out"><a href="user/logout.htm">Log out</a></button>
    </aside>

     
    <!-- Main -->
    <main class="main">

        <!-- Map  -->
        <div class="main-header">
            <div class="header-left">
                <h2>Manage Products</h2>

                <div class="map">
                    <a href="home.html">Home</a>
                    /
                    <a href="adminHome.html">Admin</a>
                    /
                    <a href="adminProduct.html">Edit Product</a>
                </div>
            </div>

            <div class="header-right">
                 
            </div>
        </div>

		${message }       

        <!-- Main talbe data  -->
        <div class="main-content">
            <form method="post"  >
            	<div class="row">
	                <div class="col-4 image">
	                    <img src="${p.image }" alt="">
	                </div>
	            
	                <div class="col-8">
	                    <div class="row info">
	                        <div class="col-6 field id">
	                            <label for="">ID:</label>
	                            <input type="text" value="${p.idProduct }" readonly name="id"> 
	                        </div>
	    
	                        <div class="col-6 field name">
	                            <label for="">Category:</label>
	                            <div class="product-form">
	                                <select name="cat" id="">
	                                    
	                                    <c:forEach var="c" items="${listCats }" begin="0" end="6">
	                                    	<option value="${c.idCategory }" ${c.idCategory==p.getProductCategory().getIdCategory()?'selected':'' }>${c.nameCategory }</option>
	                                    </c:forEach>
	                                    
	                                </select>
	                            </div>
	                        </div>
	
	
	                        <div class="col-6 field name">
	                            <label for="">Name:</label>
	                            <input type="text" value="${p.name }" name="name" >
	                        </div>
	    
	                        <div class="col-6 field price">
	                            <label for="">Price:</label>
	                            <input type="number" id="" value="${p.price }" name="price" > 
	                        </div>
	     
	
	                        <div class="col-6 field">
	                            <label for="">Image source:</label>
	                            <input name="image" type="text" value="${p.image }" >
	                        </div>
	                        
	                        <div class="col-6 field">
	                        	<label for="">Brand:</label>
	                        	<input type="text" name="brand" id="" placeholder="Type brand here..." value="${p.brand }">
	                        </div>
	                        
	                        <div class="col-6 field">
	                        	<label for="">Gender:</label>
<!-- 	                        	<input type="text" name="gender" id="" placeholder="Type gender here..."> -->
	                        	<div class="product-form">
	                                <select name="gender" id="">
	                                		<c:if test="${not empty p.gender }">
	                                			<c:if test="${p.gender }">
	                                				<option value=-1>None</option>
		                                    		<option selected="selected" value=1>Male</option>
		                                    		<option value=0>Female</option>
		                                    	</c:if>
		                                    	<c:if test="${!p.gender }">
		                                    		<option value=-1>None</option>
		                                    		<option value=1>Male</option>
		                                    		<option selected="selected" value=0>Female</option>
		                                    	</c:if>
	                                		</c:if>
	                                    	<c:if test="${empty p.gender }">
	                                    		<option selected="selected" value=-1>None</option>
	                                    		<option value=1>Male</option>
		                                    	<option value=0>Female</option>
	                                    	</c:if>
	                                </select>
	                            </div>
	                        </div>
	                        
	                        <div class="col-6 field">
	                        	<label for="">Release Time:</label>
	                        	<input type="number" name="releaseTime" id="" placeholder="Type release time here..." value="${p.releaseTime }" }>
	                        </div>
	                        
	                        <div class="col-6 field">
	                        	<label for="">Product Type:</label>
	                        	<input type="text" name="productType" id="" placeholder="Type product type here..." value="${p.productType }">
	                        </div>
	                        
	                        <div class="col-6 field" style="position: relative;">
	                        	<label for="">Product Material:</label>
	                        	<input type="text" name="material" id="" placeholder="Type product Material here..." value="${p.material }">
	                        </div>
	
	                    </div>
	                </div>
	            </div>
	
	            
            	<a href="admin/adminProd/${p.idProduct }.htm" class="btn" style="right: 240px; background-color: #efefef; color: #666;">Cancel</a>
	            <button class="col-6 btn">Save changes</button>
            </form>
            
            

        </div>
    </main>
     

  

</body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
    <script src="<c:url value='/resources/home/dist/js/owl.carousel.js' />"></script>
	<script src="<c:url value='/resources/home/dist/js/home.js' />"></script>
</html>
