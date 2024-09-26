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
<title>Riode - Bill Report</title>
<base href="${pageContext.servletContext.contextPath}/">
<link rel="icon" type="image/png"
	href="https://d-themes.com/html/riode/images/icons/favicon.png">

<link href="<c:url value='/resources/home/dist/css/reset.css' />"
	rel="stylesheet">
<link href="<c:url value='/resources/home/dist/css/colorSize.css' />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>

<body>

	<aside class="aside">
		<a href="admin/adminHome.htm" class="admin">
			<div class="logo">
				<i class="fa-solid fa-a"></i>
			</div> Admin
		</a>

		<ul class="functions">
			<li class="function"><a href="admin/adminAccount.htm">
					<div class="icon">
						<i class="fa-solid fa-users"></i>
					</div> Account
			</a></li>

			<li class="function"><a href="admin/adminBill.htm">
					<div class="icon">
						<i class="fa-solid fa-receipt"></i>

					</div> Bill
			</a></li>

			<li class="function"><a href="admin/adminProducts.htm"
				class="active">
					<div class="icon">
						<i class="fa-solid fa-shirt"></i>
					</div> Products
			</a></li>


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
					<a href="home/index.htm">Home</a> / <a href="admin/adminHome.htm">Admin</a>
					/ <a href="admin/adminProducts.htm">Products</a>
				</div>
			</div>

			
		</div>



		<!-- Main talbe data  -->
		<div class="main-content">
			<table>
					<tr>
						<th>ID</th>
						<th>Brand</th>
						<th>Gender</th>
						<th>Release time</th>
						<th>Type</th>
						<th>Material</th>
					</tr>

					<div class="scroll">
						
						
    	 
    							<tr>
		                            <td>${p.idProduct }</td>
		                            <td>${p.brand }</td>
		                            <c:if test="${not empty p.gender }">
		                            	<c:if test="${p.gender }"><td>Male</td></c:if>
		                            	<c:if test="${!p.gender }"><td>Female</td></c:if>
		                            </c:if>
		                         	<c:if test="${empty p.gender }"><td>None</td></c:if>
		                            <td>${p.releaseTime }</td>
		                            <td>${p.productType }</td>
		                            <td>${p.material }</td>
		                        </tr> 
    					
					</div>

				</table>
		
		
			<div class="table-container">
				
				
				
				<table>
					<tr>
						<th>Color</th>
						<th>Size</th>
						<th>Quantity</th>
						<th>Edit</th>
                        <th>Delete</th>
					</tr>

					<div class="scroll">
						<c:forEach var="c" items="${listC}" begin="0" end="${size }">
    	 					<tr>
								<td>${c.pk.color }</td>
								<td>${c.pk.size }</td>
								<td>${c.quantity }</td>
								<td>
                                <a href="admin/editCS/${p.idProduct }_${c.pk.color}_${c.pk.size}.htm" class="btn-func" style="background-color: #1abc9c;"><i class="fa-solid fa-pen"></i></a>

                            </td>
                            <td>
                                <a href="admin/deleteCS/${p.idProduct }_${c.pk.color}_${c.pk.size}.htm" class="btn-func" style="background-color: #c0392b;"><i class="fa-solid fa-trash-can"></i></a>
                            </td>
							</tr> 
    					</c:forEach>
    					
					</div>

				</table>
			</div>
			
			<a href="admin/deleteProduct/${p.idProduct }.htm" class="btn" style="left: 320px; right: unset; background-color: #c0392b;">DELETE THIS PRODUCT</a>
            
            <a href="admin/adminProducts.htm" class="btn" style="right: 320px; background-color: #efefef; color: #666;">Back</a>
            <a href="admin/editProd/${p.idProduct}.htm" class="btn" style="right: 180px;">Edit</a>
            <a href="admin/addCS/${p.idProduct }.htm" class="btn">Add</a>
		</div>
	</main>



</body>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	referrerpolicy="no-referrer"></script>
<script src="<c:url value='/resources/home/dist/js/owl.carousel.js' />"></script>
<script src="<c:url value='/resources/home/dist/js/home.js' />"></script>

</html>