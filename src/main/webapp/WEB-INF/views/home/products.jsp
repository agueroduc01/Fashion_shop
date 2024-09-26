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
    <title>Riode - Show products</title>
    <base href="${pageContext.servletContext.contextPath}/">

	<link rel="icon" type="image/png"
	href="https://d-themes.com/html/riode/images/icons/favicon.png">
    <link href="<c:url value='/resources/home/dist/css/reset.css' />"
	rel="stylesheet">
	<link href="<c:url value='/resources/home/dist/css/products.css' />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
     
    <!-- Header -->
     <%@include file="/WEB-INF/views/header.jsp"%>

    <!-- Main -->
    <main class="main">
        <section class="banner">
            <h1>RIODE SHOP</h1>
            <p><a href="home/index.htm"><i class="fa-solid fa-house"></i></a> / Riode Shop</p>
        </section>

        <div class="container">
            <section class="page-content">
                <div class="row">
                    <aside class="aside col-3">
                        <div class="aside-header">
                            <a href="">FILTER <i class="fa-solid fa-filter"></i></a>
                        </div>

                        <div class="list">
                            <h2>All Categories</h2>
        
                            <ul>
                          <!-- <li><a href="">T-Shirt</a></li>
                                <li><a href="">Shirt</a></li>
                                <li><a href="">Pants</a></li>
                                <li><a href="">Shoes</a></li>
                                <li><a href="">Bags</a></li>
                                <li><a href="">Watches</a></li> -->      
                                
                                <c:forEach var="c" items="${listCat}" begin="0" end="7" step="1" >
                                	<li><a href="home/products/${c.idCategory}.htm">${c.nameCategory }</a></li>
                                </c:forEach>
                            </ul>
                        </div>
        
                        <div class="list">
                            <h2>Size</h2>
        
                            <ul>
                                <li>
                                    <input type="checkbox" name="size" id="sizeXL">
                                    <label for="sizeXL">Extra Large</label>
        
                                </li>
        
                                <li>
                                    <input type="checkbox" name="size" id="sizeL">
                                    <label for="sizeL">Large</label>
                                </li>
        
                                <li>
                                    <input type="checkbox" name="size" id="sizeM">
                                    <label for="sizeM">Medium</label>
                                </li>
        
                                <li>
                                    <input type="checkbox" name="size" id="sizeS">
                                    <label for="sizeS">Small</label>
                                </li>
                            </ul>
                        </div>
        
                        <div class="list">
                            <h2>Color</h2>
        
                            <ul>
                                <li>
                                    <input type="checkbox" name="color" id="black">
                                    <label for="black">Black</label>
                                </li>
        
                                <li>
                                    <input type="checkbox" name="color" id="blue">
                                    <label for="blue">Blue</label>
                                </li>
        
                                <li>
                                    <input type="checkbox" name="color" id="green">
                                    <label for="green">Green</label>
                                </li>
        
                                <li>
                                    <input type="checkbox" name="color" id="white">
                                    <label for="white">White</label>
                                </li>
                            </ul>
                        </div>
                    </aside>
        
                    <section class="main-content col-9">
                        <div class="main-header">

                        </div>

                        <div class="list-products">
                            <div class="row">
                                <!-- A product  -->
                                <c:if test="${catON == 'false' }">
                                	 <c:forEach var="p" items="${prods}" begin="0" end="${prodsSize}" step="1">
		                                <div class="col-4 product">
											<div class="product-image">
												<img style="width: 100%; height: 100%;"
													src="${p.image }"
													alt="">
				
												<div class="new">NEW</div>
				
												<a href="home/detail/${p.idProduct}.htm" class="btn-view">VIEW DETAILS</a> <a
													href="" class="btn-add"> <i
													class="fa-solid fa-bag-shopping"></i>
												</a>
											</div>
		 
											<div class="product-content">
												<a href="" class="product-category hover-p-color">${p.getProductCategory().nameCategory }</a>
				
												<h2>
													<a href="home/detail/${p.idProduct}.htm" class="product-name hover-p-color">${p.name }</a>
												</h2>
				
												<p class="product-price">$${p.price }</p>
				
												<div class="review">
													<ul class="list-stars">
														<li class="active"><i class="fa-solid fa-star"></i></li>
														<li class="active"><i class="fa-solid fa-star"></i></li>
														<li class="active"><i class="fa-solid fa-star"></i></li>
														<li><i class="fa-solid fa-star"></i></li>
														<li><i class="fa-solid fa-star"></i></li>
													</ul>
				
													( 6 Reviews )
												</div>
											</div>
										</div>
	                                </c:forEach>
                                </c:if>
                                
                               
                                <c:if test="${catON == 'true' }">
                                	 <c:forEach var="p" items="${prods}" begin="0" end="${prodsSize}" step="1">
		                         
											<c:if test="${p.getProductCategory().idCategory == catID}">
												<div class="col-4 product">
											<div class="product-image">
												<img style="width: 100%; height: 100%;"
													src="${p.image }"
													alt="">
				
												<div class="new">NEW</div>
				
												<a href="home/detail/${p.idProduct}.htm" class="btn-view">VIEW DETAILS</a> <a
													href="" class="btn-add"> <i
													class="fa-solid fa-bag-shopping"></i>
												</a>
											</div>
				
											<div class="product-content">
												<a href="" class="product-category hover-p-color">${p.getProductCategory().nameCategory }</a>
				
												<h2>
													<a href="home/detail/${p.idProduct}.htm" class="product-name hover-p-color">${p.name }</a>
												</h2>
				
												<p class="product-price">$${p.price }</p>
				
												<div class="review">
													<ul class="list-stars">
														<li class="active"><i class="fa-solid fa-star"></i></li>
														<li class="active"><i class="fa-solid fa-star"></i></li>
														<li class="active"><i class="fa-solid fa-star"></i></li>
														<li><i class="fa-solid fa-star"></i></li>
														<li><i class="fa-solid fa-star"></i></li>
													</ul>
				
													( 6 Reviews )
												</div>
											</div>
										</div>
											</c:if>
										
	                                </c:forEach>
                                </c:if>
                            </div>
                        </div>
                        
                        <div class="tool-box">
                            <p class="showing-products">
                                Showing 12 of 56 Products
                            </p>

                            <div class="pagination">
                                <div class="page-item "><a class="disable" href=""><i class="fa-solid fa-arrow-left"></i> Prev</a></div>
                                <div class="page-item"><a  class="active" href="">1</a></div>
                                <div class="page-item"><a href="">2</a></div>
                                <div class="page-item">...</div>
                                <div class="page-item"><a href="">6</a></div>
                                <div class="page-item"><a href="">Next <i class="fa-solid fa-arrow-right"></i></a></div>

                            </div>
                        </div>
                    </section>
                </div>
            </section>
        </div>
    </main>


    <!-- Footer  -->
     <%@include file="/WEB-INF/views/footer.jsp"%>
     
</body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
    <script src="<c:url value='/resources/home/dist/js/owl.carousel.js' />"></script>
    <script src="<c:url value='/resources/home/dist/js/home.js' />"></script>
</html>
