<%--
  Created by IntelliJ IDEA.
  User: Elhoseni
  Date: 25/03/2019
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="theme-color" content="#232f3e"/>
    <!-- Chrome, Firefox OS and Opera -->
    <meta name="theme-color" content="#232f3e">
    <!-- Windows Phone -->
    <meta name="msapplication-navbutton-color" content="#232f3e">
    <!-- iOS Safari -->
    <meta name="apple-mobile-web-app-status-bar-style" content="#232f3e">
    <title>Electro-Shopping</title>
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.png"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/themify-icons/themify-icons.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" href="vendor/iziModal/css/iziModal.min.css">
    <link rel="stylesheet" href="vendor/iziToast/iziToast.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>

<body class="animsition"
        <c:choose>
            <c:when test="${sessionScope.user != null}">
                data-login = "true"
            </c:when>
            <c:otherwise>
                data-login = "false"
            </c:otherwise>
        </c:choose>>

<!-- Main Page -->
<main class="tab-content">
    <!-- ------------------------------------------------ -->
    <!--===================== Pages ======================-->
    <!-- ------------------------------------------------ -->

    <!-- Home Page -->
    <section id="homepage" class="active-menu tab-pane p-b-150 active">
        <!-- Header -->
        <header class="home-header">
            <!-- Header Mobile -->
            <div class="wrap-header-mobile custom-header-mobile">
                <!-- Logo moblie -->
                <div class="logo-mobile"><a><img src="images/icons/logo.png" alt="IMG-LOGO"> </a></div>

                <!-- Icon header -->
                <div class=" flex-w flex-r-m m-r-15">
                    <!-- Trigger to open Modal -->

                    <c:choose>
                        <c:when test="${sessionScope.user != null}">
                            <a href="SignoutServlet" class="icon-header-item cl1 hov-cl1 trans-04 p-r-7 sign-in-header ">${sessionScope.user.name}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="#" class="icon-header-item cl1 hov-cl1 trans-04 p-r-7 sign-in-header loginModal">Sign In</a>
                        </c:otherwise>
                    </c:choose>

                    <!--HERE SIZE OF CART-->
                    <div class="icon-header-item cl1 hov-cl1 trans-04 p-r-6"><i class="acount-icon nav-sprite"></i></div>
                    <div class="icon-header-item cl1 hov-cl1 trans-04 p-r-11 p-l-10 cart-icon icon-cart-noti  js-show-cart" id="numberOfProductsInCartID" data-notify="${fn:length(sessionScope.user.carts)}"><i class="shopping-cart-icon nav-sprite"></i></div>
                </div>
            </div>

            <!-- Cart -->
            <div class="wrap-header-cart js-panel-cart">
                <!-- Inlcude header-cart page -->
                <%@ include file="header-cart.jsp" %>
            </div>

            <!-- Search bar -->
            <section class="container subheader-mobile">
                <div class="icon-header-item header-searchbar js-show-modal-search"><span class="searchhere"> I'm shopping for ...</span>
                    <button type="button"><i class="fa fa-search"></i></button>
                </div>

                <!-- Modal Search -->
                <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
                    <div class="container-search-header">
                        <button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search"><img src="images/icons/icon-close2.png" alt="CLOSE"></button>
                        <form class="wrap-search-header flex-w p-l-15">
                            <button class="flex-c-m trans-04"><i class="zmdi zmdi-search"></i></button>
                            <input class="plh3" type="text" name="search" placeholder="Search...">
                        </form>
                    </div>
                </div>
            </section>

            <!-- Text Slider -->
            <div id="textslider">
                <!-- Include advertise coupons text -->
                <%@ include file="advertise-coupons-text.jsp" %>
            </div>
        </header>

        <!-- Main -->
        <main>

            <!-- Slider -->
            <section class="section-slide">
                <div class="wrap-slick1">
                    <!-- Include advertise products slider page -->
                    <%@ include file="advertise-products-slider.jsp" %>
                </div>
            </section>

            <!-- Categories -->
            <section class="bg0 p-t-23 p-b-140 bg-silver category-section">
                <!-- Include categories page -->
                <%@ include file="categories.jsp" %>
            </section>

            <!-- Include products page -->
            <%@ include file="products.jsp" %>

            <!-- Back to top -->
            <div class="btn-back-to-top" id="myBtn"><span class="symbol-btn-back-to-top"> <i class="zmdi zmdi-chevron-up"></i> </span></div>
        </main>

        <!-- Login Modal -->
        <div id="loginpage" class="iziModal">
            <!-- Modal content -->
            <!-- Include login page -->
            <%@ include file="login.jsp" %>
        </div>

        <!-- Register Modal -->
        <div id="registerpage" class="iziModal">
            <!-- Modal content -->
            <!-- Include register page -->
            <%@ include file="register.jsp" %>
        </div>
    </section>

    <!-- ------------------------------------------------ -->
    <!-- ------------------------------------------------ -->

    <!-- Category Page -->
    <section id="categorypage" class="active-menu tab-pane p-b-150 fade">

        <!-- Content -->
        <section class="bg0 p-t-23 p-b-140 bg-silver">
            <!-- Include category page -->
            <%@ include file="categorypage.jsp" %>
        </section>

        <!-- Load more -->
        <!--
        <div class="flex-c-m flex-w w-full p-t-45">
            <a href="#" class="flex-c-m stext-101 cl5 size-103 bg2 bor1 hov-btn1 p-lr-15 trans-04"> Load More </a>
        </div> -->
    </section>

    <!-- ------------------------------------------------ -->
    <!-- ------------------------------------------------ -->

    <!-- Wishlist Page -->
    <section id="wishlistpage" class="active-menu tab-pane p-b-150 fade">
        <header class="header-account-page bg-primary d-flex align-items-end pt-2">
            <!-- Header container -->
            <div class="container">
                <div class="row">
                    <div class=" col-lg-12">
                        <div class="row align-items-center mb-4">
                            <div class="col"><span class="h2 mb-0 text-white d-block">My Wishlist</span> <span class="text-white">  </span></div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <main class="p-b-100">
            <!-- Include wishlist page -->
            <%@ include file="wishlist.jsp" %>
        </main>
    </section>

    <!-- ------------------------------------------------ -->
    <!-- ------------------------------------------------ -->

    <!-- Cart Page -->
    <section id="cartpage" class="active-menu tab-pane p-b-150 fade">
        <header class="header-account-page bg-primary d-flex align-items-end pt-2">
            <!-- Header container -->
            <div class="container">
                <div class="row">
                    <div class=" col-lg-12">
                        <!-- Salute + Small stats -->
                        <div class="row align-items-center mb-4">
                            <div class="col"><span class="h2 mb-0 text-white d-block">Shopping Cart</span> <span class="text-white">Have a nice day .. </span> <em class="ti-shopping-cart cl0"></em></div>
                        </div>
                        <!-- Account navigation -->
                        <div class="d-flex">
                            <div class="btn-group btn-group-nav " role="group" aria-label="Basic example">
                                <div class="btn-group" role="group">
                                    <div class="btn btn-white btn-icon cl0 cart-step1 cart-form-active"><span class="btn-inner--icon"><i class="ti-shopping-cart-full"></i></span> <span class="btn-inner--text fs-9 ">Cart</span></div>
                                    <div class="btn btn-white btn-icon cart-step2 cl0"><span class="btn-inner--icon"><i class="ti-user"></i></span> <span class="btn-inner--text fs-9">Customer</span></div>
                                    <div class="btn btn-white btn-icon cart-step3 cl0"><span class="btn-inner--icon"><i class="ti-truck"></i></span> <span class="btn-inner--text fs-9">Shipping</span></div>
                                    <div class="btn btn-white btn-icon cart-step4 cl0"><span class="btn-inner--icon"><i class="ti-credit-card"></i></span> <span class="btn-inner--text fs-9">Payment</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <main class="p-b-100">

            <!-- Include shopping cart page -->
            <%@ include file="cart.jsp" %>

        </main>
    </section>

    <!-- ------------------------------------------------ -->
    <!-- ------------------------------------------------ -->

    <!-- Account Page -->
    <section id="accountpage" class="active-menu tab-pane p-b-150 fade">
        <main class="p-b-100">
            <%@ include file="account.jsp" %>
        </main>
    </section>

    <!-- ------------------------------------------------ -->
    <!-- view product Modal -->
    <div class="wrap-modal1 js-modal1 p-t-60 p-b-20">
        <div class="overlay-modal1 js-hide-modal1"></div>

        <div class="container">
            <div class="bg0 p-t-60 p-b-30 p-lr-15-lg how-pos3-parent">
                <button class="how-pos3 hov3 trans-04 js-hide-modal1">
                    <img src="images/icons/icon-close.png" alt="CLOSE">
                </button>

                <div class="row">
                    <div class="col-md-6 col-lg-7 p-b-30">
                        <div class="p-l-25 p-r-30 p-lr-0-lg" id="show-product-images">

                        </div>
                    </div>

                    <div class="col-md-6 col-lg-5 p-b-30">
                        <div class="p-r-50 p-t-5 p-lr-0-lg" id="show-product-details">
                            <h4 class="mtext-105 cl2 js-name-detail p-b-14" id="show-product-name"> Lightweight Jacket </h4>
                            <span class="mtext-106 cl3" id="show-product-price"> $58.79 </span>
                            <p class="stext-102 cl2 p-t-23" id="show-product-desc">
                                Fully immersive, completely impressive
                                Clarity on display: Enjoy the crisp detail of 15.6" FHD non-touch anti-glare display to see everything better, especially outside or in bright light.
                                Stream seamlessly: SmartByte technology makes your gaming and streaming smooth and uninterrupted, so you never miss a second.
                            </p>

                            <!-- product specification -->
                            <div class="p-t-33">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Specification</th>
                                        <th>Value</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th>Processor</th>
                                        <td id="show-product-processor">8th Generation Intel® Core™ i7 8550U 8M Cache, up to 4.00 GHz</td>
                                    </tr>
                                    <tr>
                                        <th>RAM</th>
                                        <td id="show-product-ram">8 GB DDR4 2400MHz</td>
                                    </tr>
                                    <tr>
                                        <th>Graphic card</th>
                                        <td id="show-product-vga">Intel UHD Graphics 620</td>
                                    </tr>
                                    <tr>
                                        <th>Storage</th>
                                        <td id="show-product-storage">256GB</td>
                                    </tr>
                                    <tr>
                                        <th>Operating System</th>
                                        <td id="show-product-os">Win 10</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>


                            <div class="p-t-33">
                                <!-- Product color
                                <div class="flex-w flex-r-m p-b-10">
                                    <div class="size-203 flex-c-m respon6"> Color</div>
                                    <div class="size-204 respon6-next">
                                        <div class="rs1-select2 bor8 bg0">
                                            <select class="js-select2" name="time" id="show-product-colours">
                                                <option>Choose an option</option>
                                                <option>Red</option>
                                                <option>Blue</option>
                                                <option>White</option>
                                                <option>Grey</option>
                                            </select>
                                            <div class="dropDownSelect2"></div>
                                        </div>
                                    </div>
                                </div> -->
                                <!-- Product Quantity -->
                                <div class="flex-w flex-r-m p-b-10">
                                    <div class="size-203 flex-c-m respon6"> Quantity</div>

                                    <div class="wrap-num-product flex-w m-r-20 m-tb-10">
                                        <div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
                                            <i class="fs-16 zmdi zmdi-minus"></i>
                                        </div>

                                        <input id="show-product-quantity" class="mtext-104 cl3 txt-center num-product" type="number" name="num-product" min="1" value="1" max="1">

                                        <div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
                                            <i class="fs-16 zmdi zmdi-plus"></i>
                                        </div>
                                    </div>


                                    <div id="show-product-id">
                                        <button class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail"> Add to cart</button>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ------------------------------------------------ -->

</main>

<!-- Footer -->
<footer>
    <!-- Include nav-menu page-->
    <%@ include file="nav-menu.jsp" %>
</footer>

<!--================   Vendors JS ======================-->
<script src="vendor/jquery/jquery-3.3.1.min.js"></script>
<script src="vendor/jqueryvalidation/jquery.validate.js"></script>
<script src="vendor/bootstrap/popper.min.js"></script>
<script src="vendor/bootstrap/bootstrap.min.js"></script>
<!--====================================================-->
<script src="vendor/iziModal/js/iziModal.min.js"></script>
<script src="vendor/iziToast/iziToast.min.js"></script>
<!--====================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--=====================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--======================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================-->
<script src="vendor/slick/slick.min.js"></script>
<script src="js/slick-custom.js"></script>
<!--============================================-->
<script src="vendor/parallax100/parallax100.js"></script>
<!--======================================-->
<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
<!--===========================-->
<script src="vendor/isotope/isotope.pkgd.min.js"></script>
<!--=========================================-->
<script src="vendor/sweetalert/sweetalert.min.js"></script>
<!--===============================-->
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<!--===============================================================================================-->
<script src="js/util.js"></script>
<script src="js/modals.js"></script>
<script src="js/main.js"></script>
<script src="js/update-profile.js"></script>
<script src="js/register.js"></script>
<script src="js/order.js"></script>
<script src="js/cart.js"></script>
<script src="js/wishlist.js"></script>
<script src="js/product.js"></script>
</body>
</html>