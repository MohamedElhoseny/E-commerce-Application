<script type= "text/javascript" src = "js/countries.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="s-full js-hide-cart"></div>
<div class="header-cart flex-col-l p-l-65 p-r-25">
    <div class="header-cart-title flex-w flex-sb-m p-b-8"><span class="mtext-103 cl2"> Your Cart </span>
        <div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart"><i class="zmdi zmdi-close"></i></div>
    </div>
    <div class="header-cart-content flex-w js-pscroll">

        <ul id="headerCart" class="header-cart-wrapitem w-full">


            <c:choose>
                <c:when test="${sessionScope.user != null}">

                    <c:choose>
                        <c:when test="${ (fn:length(sessionScope.user.carts) ==  0) }">
                            <h4> You cart is empty ! </h4>
                        </c:when>                   

                        <c:otherwise>                    
                            <c:forEach items="${sessionScope.user.carts}"  var="cart">                  
                                <li id="cart-product-header-<c:out value="${cart.product.pid}"/>" class="header-cart-item flex-w flex-t m-b-12">
                                    <div class="header-cart-item-img"><img src="images/products/<c:out value="${cart.product.productDetails.iterator().next().productImage}"/>"></div>
                                    <div class="header-cart-item-txt p-t-8"><a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04"> <c:out value="${cart.product.name}"/>  </a> <span class="header-cart-item-info"> <c:out value="${cart.product.price}"/></span></div>
                                </li>                       

                            </c:forEach>  

                        </c:otherwise>
                    </c:choose>       

                </c:when> 
                <c:otherwise>
                    <h4> Read cart product from local storage </h4>
                </c:otherwise>
            </c:choose>

        </ul>

<!--        <div class="w-full">
            <div class="header-cart-total w-full p-tb-40"> Total: $75.00</div>
                                <div class="header-cart-buttons flex-w w-full"><a href="shoping-cart.html" class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10"> View Cart </a> <a href="../shoping-cart.html" class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10"> Check Out </a></div>
        </div>-->
    </div>
</div>