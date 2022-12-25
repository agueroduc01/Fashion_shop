<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- <!DOCTYPE html> -->
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
	<link href="<c:url value='/resources/home/dist/css/detail.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/home/dist/css/owl.carousel.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/home/dist/css/owl.theme.default.css' />" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
     
     
     <%@include file="/WEB-INF/views/header.jsp"%>
     

    <main class="main">
        <div class="container">
            <div class="product">
                
                
                
            </div>

            <div class="desc">
                <h2 class="title">${product.name }</h2>

                <div class="row desc-main">
                    <div class="col-6 features">
                        <h5 class="desc-title">Features</h5>
                        <p>Praesent id enim sit amet.Tdio vulputate eleifend in in tortor. ellus massa. siti iMassa ristique sit amet condim vel, facilisis quimequistiqutiqu amet condim Dilisis Facilisis quis sapien. Praesent id enim sit amet.</p>
                        <ul>
                            <li><i class="fa-solid fa-check"></i>Praesent id enim sit amet.Tdio vulputate</li>
                            <li><i class="fa-solid fa-check"></i>Eleifend in in tortor. ellus massa.Dristique sitii</li>
                            <li><i class="fa-solid fa-check"></i>Massa ristique sit amet condim vel</li>
                            <li><i class="fa-solid fa-check"></i>Dilisis Facilisis quis sapien. Praesent id enim sit amet</li>
                        </ul>

                        <h5 class="desc-title">Specifications</h5>
                        <table>
                            <tr>
                                <th>Price</th>
                                <td>${product.price }</td>

                            </tr>
                            <tr>
                                <th>Brand</th>
                                <td>${product.brand }</td>

                            </tr>
                            <tr>
                                <th>Gender</th>
                                <td>${product.gender }</td>

                            </tr>
                            <tr>
                                <th>Release time</th>
                                <td>${product.releaseTime }</td>

                            </tr>
                            <tr>
                                <th>Material</th>
                                <td>${product.material }</td>

                            </tr>
                        </table>
                    </div>

                    <div class="col-6 video-desc">
                        <h5 class="desc-title">Image</h5>

                        <div class="video">
                            <img src="${product.image }" alt="">
                        </div>

                        <div class="row benefits">
                            <div class="col-6 icon-box">
                                <div class="icon-box-icon">
                                    <i class="fa-solid fa-lock"></i>
                                </div>

                                <div class="icon-box-content">
                                    <h4>2 year warranty</h4>
                                    <p>Guarantee with no doubt</p>
                                </div>
                            </div>

                            <div class="col-6 icon-box">
                                <div class="icon-box-icon">
                                    <i class="fa-solid fa-truck-fast"></i>
                                </div>

                                <div class="icon-box-content">
                                    <h4>free shipping</h4>
                                    <p>On orders over $50.00</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <section class="show-products" style="padding-bottom: 50px;">
                <div class="container">
    
                    <h4 class="title">
                        Related Products
                        <a href="home/products.htm" class="more hover-p-color">VIEW MORE <i class="fa-solid fa-arrow-right"></i></a>
                    </h4>
                    <div class="owl-carousel owl-theme">
					<c:forEach var="p" items="${relatedProducts}" begin="0" end="20" step="3">
						<div class="col-4 product">
							<div class="product-image">
								<img
									src="${p.image }"
									alt="">

								<div class="new">NEW</div>

								<a href="home/detail/${p.idProduct}.htm?history=${history.id }" class="btn-view">VIEW DETAILS</a> <a
									href="" class="btn-add"> <i
									class="fa-solid fa-bag-shopping"></i>
								</a>
							</div>

							<div class="product-content">
								<a href="" class="product-category hover-p-color">${p.getProductCategory().nameCategory }</a>

								<h2>
									<a href="home/detail/${p.idProduct}.htm?history=${history.id }" class="product-name hover-p-color">${p.name }</a>
								</h2>

								<p class="product-price">${p.price }</p>

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
     
    
                        
                       
                    </div>
                </div>
            </section>
        </div>
    </main>

     <%@include file="/WEB-INF/views/footer.jsp"%>

</body>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
    <script src="<c:url value='/resources/home/dist/js/owl.carousel.js' />"></script>
    <script src="<c:url value='/resources/home/dist/js/home.js' />"></script>
</html>
