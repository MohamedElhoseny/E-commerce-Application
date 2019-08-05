<section cite="registerForm">
    <div class="container py-4 px-md-0 d-flex">
        <div class="w-100">
            <div class="row row-grid justify-content-center justify-content-lg-between align-items-center">
                <div class="col">
                    <div class="card zindex-100 mb-0">
                        <div class="card-body px-md-5 py-5">
                            <form role="form" method="post" id="register" action="../register" enctype="multipart/form-data">
                                <div class="mb-5">
                                    <div class="pos-relative">
                                        <label for="r-upload-photo" class="px-2 py-2 pos-absolute bg-silver fs-20 card" style="left: 72%;"><i class="ti-camera"></i></label>
                                        <input type="file" name="photo" id="r-upload-photo" />
                                        <img id="r-profile-img-tag" src="images/icons/male.png" type="file" width="50%" height="50%" class="pb-2">
                                    </div>
                                    <h6 class="h3">Create account</h6>
                                    <p class="text-muted mb-0">Please fill the following information to register</p>
                                </div>
                                <span class="clearfix"></span>
                                <div class="form-group">
                                    <label class="form-control-label">Username</label>
                                    <div class="input-group input-group-merge">
                                        <div class="input-group-prepend"> <span class="input-group-text"><i class="ti-user"></i></span> </div>
                                        <input type="text" name="name" id="r-name" required class="form-control" placeholder="Your name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">Email address</label>
                                    <div class="input-group input-group-merge">
                                        <div class="input-group-prepend"> <span class="input-group-text"><i class="ti-email"></i></span> </div>
                                        <input type="email" id="r-email" name="email" class="form-control" placeholder="name@example.com" required>
                                    </div>
                                    <label id="r-email-validation"></label>
                                </div>
                                <div class="form-group mb-4">
                                    <label class="form-control-label">Password</label>
                                    <div class="input-group input-group-merge">
                                        <div class="input-group-prepend"> <span class="input-group-text"><i class="ti-key"></i></span> </div>
                                        <input name="password" id="r-password" type="password" class="form-control" placeholder="********" required autocomplete="off">
                                        <div class="input-group-append"> </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="form-control-label">Confirm password</label>
                                    <div class="input-group input-group-merge">
                                        <div class="input-group-prepend"> <span class="input-group-text"><i class="ti-key"></i></span> </div>
                                        <input name="confirm_password"  type="password" class="form-control" id="r-input-password-confirm" placeholder="********" required autocomplete="off">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="form-control-label">Phone</label>
                                    <div class="input-group input-group-merge">
                                        <div class="input-group-prepend"> <span class="input-group-text"><i class="fa fa-phone"></i></span> </div>
                                        <input  pattern="^01[012][0-9]{8}$" 
                                                name="phone" id="r-tel" type="tel" class="form-control" placeholder="Your phone" required>
                                    </div>
                                </div>


                                <label class="form-control-label">Gender</label>
                                <!-- Material inline 1 -->
                                <div class="form-check form-check-inline">
                                    <input type="radio" class="form-check-input" name="gender" id="male" value="male" checked>
                                    <label class="form-check-label" for="materialInline1"> Male</label>
                                </div>

                                <!-- Material inline 2 -->
                                <div class="form-check form-check-inline">
                                    <input type="radio" class="form-check-input" name="gender" id="female" value="female">
                                    <label class="form-check-label" for="materialInline2"> Female</label>
                                </div>




                                <div class="my-4">
                                    <div class="custom-control custom-checkbox mb-3">
                                        <input type="checkbox" class="custom-control-input" id="check-terms">
                                        <label class="custom-control-label" for="check-terms">I agree to the <a href="#">terms and conditions</a></label>
                                    </div>
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="check-privacy">
                                        <label class="custom-control-label" for="check-privacy">I agree to the <a href="#">privacy policy</a></label>
                                    </div>
                                </div>
                                <div class="mt-4">
                                    <button type="submit" id="r-submit-button"  class="btn btn-primary skew"> <span class="btn-inner--text skew">Create my account</span> <span class="btn-inner--icon"><i class="far fa-long-arrow-alt-right"></i></span> </button>
                                </div>
                            </form>
                        </div>
                        <div class="card-footer px-md-5 fs-16"><small>Already have an acocunt?</small> <a href="#" class="small font-weight-bold loginModal">Sign in</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>