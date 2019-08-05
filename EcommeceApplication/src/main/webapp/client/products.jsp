<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- sales rows -->
<!--<div class="_2dZM1"> <a href="#"><img src="images/anniverary.gif" width="100"></a>
<div></div>
<a href="https://sale.aliexpress.com/20190328AnniversarySale.htm?wx_navbar_hidden=true&amp;wx_navbar_transparent=true">
<p class="wxgAm" style="color: rgba(253,248,248,1.00);">Pick from millions of deals</p>
</a></div> -->

<div class="products-classify">
<!-- divider products by titles -->
<div class="divide-section card">
    <div class="container">

        <!-- 1 x 2 Grid -->
        <div class="row">
            <div class="col-12 py-3">
                <img class="img-fluid" src="images/adv1.jpg">
            </div>
        </div>
    </div>
</div>

<div class="anniv-sales m-t-20 p-t-10">
    <c:choose>
        <c:when test="${ (fn:length(requestScope.products) >  0) }">
            <div id="single-row-product1" class="p-l-10 p-r-10">
                <div data-role="single-row-product">
                    <div class="card _3VCBs">
                        <div class="flex justify-space-between _2LrhB">
                            <div class="flex align-center"><img class="aV6qY" src="https://ae01.alicdn.com/kf/HTB1KREIbdjvK1RjSspi763EqXXaA.png">
                                <span class="_30Dc_">Flash Deals</span></div>
                            <div></div>
                        </div>
                        <div class="container">
                            <ul class="row flex">
                                <!-- Products inserted here ... -->
                                <c:forEach items="${requestScope.products}" begin="0" end="3" var="product">
                                    <div class="col-3">
                                        <li class="RaDM7">
                                            <div class="_2v-hL">
                                                <a href="#" onclick="showProductDetails()" class="js-show-modal1">
                                                    <img id="${product.pid}" src="images/products/<c:out value="${product.detailsDTOs.iterator().next().productImage}"/>">
                                                </a>
                                            </div>
                                            <div class="_3VO8c"><a href="#">
                                                <div class="_2CyKW">- <c:out value="${product.discount}"/> %</div>
                                                <div class="_3hVOG">EGP <c:out value="${product.price}"/></div>
                                            </a></div>
                                        </li>
                                    </div>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${ (fn:length(requestScope.products) >  3) }">
            <div id="single-row-product2">
                <div data-role="single-row-product" data-spm="flash-deals" class="_3KVHY" data-aplus-ae="x5_5778879e" data-spm-anchor-id="a2g0n.home.0.flash-deals">
                    <div class="_3VCBs card">
                        <div class="flex justify-space-between _2LrhB">
                            <div class="flex align-center"><img class="aV6qY" src="https://ae01.alicdn.com/kf/HTB1KREIbdjvK1RjSspi763EqXXaA.png"><span class="_30Dc_">New User Zone</span></div>
                            <div></div>
                        </div>
                        <!-- <div class="_3IJYv"><a href="#"><img src="https://ae01.alicdn.com/kf/HTB1FkUPbjDuK1Rjy1zj762raFXan.png">
                            <p class="_1lw9L">GET YOUR US $5 COUPON</p>
                        </a></div> -->
                        <p class="_1ZMkG text-left">Ideas For Your First Order</p>
                        <br>
                        <div class="container">

                            <ul class="flex">
                                <c:forEach items="${requestScope.products}" begin="4" end="7" var="product">
                                    <div class="col-3">
                                        <li class="RaDM7">
                                            <div class="_2v-hL">
                                                <a href="#" onclick="showProductDetails()" class="js-show-modal1">
                                                    <img id="${product.pid}" src="images/products/<c:out value="${product.detailsDTOs.iterator().next().productImage}"/>">
                                                </a>
                                            </div>
                                            <div class="_3VO8c"><a href="#">
                                                <div class="_3hVOG">EGP <c:out value="${product.price}"/></div>
                                            </a></div>
                                        </li>
                                    </div>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </c:when>
    </c:choose>
</div>

<c:choose>
    <c:when test="${ (fn:length(requestScope.products) >  7) }">
        <div id="single-row-product4">
            <div data-role="single-row-product">
                <div class="card _3VCBs">
                    <div class="flex justify-space-between _2LrhB">
                        <div class="flex align-center">
                            <img class="aV6qY" src="https://ae01.alicdn.com/kf/HTB1KREIbdjvK1RjSspi763EqXXaA.png"><span class="_30Dc_">Awesome products</span></div>
                        <div></div>
                    </div>
                    <ul class="flex">
                        <c:forEach items="${requestScope.products}" begin="8" var="product">
                            <li class="RaDM7">
                                <div class="_2v-hL"><a href="#" onclick="showProductDetails()" class="js-show-modal1">
                                    <img id="${product.pid}" src="images/products/<c:out value="${product.detailsDTOs.iterator().next().productImage}"/>"></a>
                                </div>
                                <div class="_3VO8c"><a href="#">
                                    <div class="_2CyKW">-<c:out value="${product.discount}"/>%</div>
                                    <div class="_3hVOG">EGP <c:out value="${product.price}"/></div>
                                </a></div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

    </c:when>
</c:choose>