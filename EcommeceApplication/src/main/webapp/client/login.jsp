<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="loginForm">
    <div class="container py-4 px-md-0 d-flex">
        <div class="w-100">
            <div class="row row-grid justify-content-center justify-content-lg-between align-items-center">
                <div class="col">
                    <div class="card zindex-100 mb-0">
                        <div class="card-body px-md-5 py-5">
                            <div class="mb-5">
                                <h6 class="h3 cl11">Login</h6>
                                <p class="text-muted mb-0">Sign in to your account to continue.</p>
                            </div>
                            <span class="clearfix"></span>
                            <form role="form" action ="../login" method ="post"> 
                                <div class="form-group">
                                    <label class="form-control-label">Email address</label>
                                    <div class="input-group input-group-merge">
                                        <div class="input-group-prepend"> <span class="input-group-text"><i class="ti-user"></i></span> </div>
                                        <input name = "email" type="email" class="form-control" id="input-email" placeholder="name@example.com">
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    <div class="d-flex align-items-center justify-content-between">
                                        <div>
                                            <label class="form-control-label">Password</label>
                                        </div>
                                        <div class="mb-2"> </div>
                                    </div>
                                    <div class="input-group input-group-merge">
                                        <div class="input-group-prepend"> <span class="input-group-text"><i class="ti-key"></i></span> </div>
                                        <input name ="password" type="password" class="form-control" id="input-password" placeholder="Password" autocomplete="off">
                                        <div class="input-group-append"> </div>
                                    </div>
                                </div>
                                <div class="mt-4">
                                    <button type= "submit" class="btn btn-sm btn-primary btn-icon px-5 py-2 sk skew"><span class="btn-inner--text">Sign in &nbsp; </span><span class="btn-inner--icon"><em class="ti-arrow-right fs-11"></em></span></button>
                                </div>

                                <c:choose>
                                    <c:when test="${requestScope.error != null}">
                                        <p class="cl3">Invalid email or password .</p>
                                    </c:when>
                                </c:choose>
                            </form>
                        </div>
                        <div class="card-footer px-md-5 fs-16"><small>Not registered?</small> <a href="#" class="small font-weight-bold registerModal">Create account</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>