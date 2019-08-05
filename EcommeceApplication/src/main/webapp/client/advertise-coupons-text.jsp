<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

    <c:forEach items="${requestScope.coupons}" var="coupon">
        <div class="textslidercontent">
            <p><c:out value="${coupon.description}"/></p>
        </div>

    </c:forEach> 
</div>


