var numberOfProductsInCartID = document.getElementById("numberOfProductsInCartID").getAttribute("data-notify");

function addToCart(productID, islogin) {
    event.preventDefault();

    var productelement = $("#product-" + productID);
    var incart = productelement.attr('data-incart');


    if (!islogin) {
        iziToast.warning({
            title: 'Caution',
            position: 'topCenter',
            progressBar: false,
            timeout: '3000',
            transitionIn: 'bounceInDown',
            message: 'Please login inorder to add product to your cart !'
        });
    } else {
        if (incart == "true") {
            iziToast.info({
                title: 'Info',
                position: 'topCenter',
                progressBar: false,
                timeout: '3000',
                transitionIn: 'bounceInDown',
                message: 'This product is already in your cart !'
            });
        } else {
            var productJson = productelement.attr('data-product');
            var jsonContent = JSON.parse(productJson);

            console.log("Adding to cart");
            //send to servlet to add to user cart
            $.ajax({
                type: 'POST',
                url: 'cart',
                data: {
                    'productId': productID,
                    'quantity': 1
                },
                success: function (msg) {
                    //render cart ui
                    $('#cart-products').append(getProductCartItem(jsonContent));
                    $('#headerCart').append(getProductHeaderCartItem(jsonContent));
                    numberOfProductsInCartID++;
                    document.getElementById("numberOfProductsInCartID").setAttribute("data-notify", numberOfProductsInCartID);

                    productelement.attr('data-incart', "true");

                    iziToast.success({
                        title: 'OK',
                        position: 'topCenter',
                        progressBar: false,
                        timeout: '3000',
                        transitionIn: 'bounceInDown',
                        message: 'Successfully Added To Your Cart !'
                    });
                }
            });
        }
    }
}

function removeFromCart(productID) {
    event.preventDefault();

    console.log("removing product from cart ..");
    //send ajax to servlet to remove this element from user cart
    $.ajax({
        type: 'DELETE',
        url: 'cart?productId=' + productID,
        contentType: "application/x-www-form-urlencoded",

        success: function (msg) {
            //update add cart attribute
            var productelement = $("#product-" + productID);
            productelement.attr("data-incart", "false");
            //remove from ui list
            var productIdentifier = "#cart-product-" + productID;
            var productIdentifierHeader = "#cart-product-header-" + productID;
            $(productIdentifier).remove();
            $(productIdentifierHeader).remove();
            numberOfProductsInCartID--;
            document.getElementById("numberOfProductsInCartID").setAttribute("data-notify", numberOfProductsInCartID);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            iziToast.error({
                title: 'Error',
                position: 'topCenter',
                progressBar: false,
                timeout: '3000',
                transitionIn: 'bounceInDown',
                message: 'Unexpected error ocurred plz try again later !'
            });
        }
    });
}

function getProductCartItem(productJson) {

    var element = "  <div class=\"cart-item pt-4\" id=\"cart-product-" + productJson.pid + "\""
        + "   data-id=\"" + productJson.pid + "\" "
        + "   data-available=\"" + productJson.quantity + "\"> "
        + "   <div class=\"row\"> "
        + "   <div class=\"col-5\"> "
        + "   <img id=\"cart-product-image-" + productJson.pid + "\" src=\"images/products/" + productJson.detailsDTOs[0].productImage + "\"></div>"
        + "   <div class=\"col-7\">"
        + "   <div class=\"row\"><span id='cart-product-name-" + productJson.name + "' class=\"cart-item-name\">" + productJson.name + "</span></div>";

    if (productJson.discount == 0)
        element += " <div  class=\"row mt-2\"><span  class=\"cart-item-cost text-decoration-none\">EGP <b id=\"cart-product-price-"+productJson.pid+"\">" + productJson.price + "</b></span></div>";
    else {
        element += " <div  class=\"row mt-2\"><b  class=\"cart-item-cost\">EGP <b id=\"cart-product-price-"+productJson.pid+"\">" + productJson.price + "</b></span></div>"
            + " <div class=\"row mt-1\"><span class=\"cart-item-discount text-decoration-none\">EGP " + (productJson.price - ((productJson.price * productJson.discount)/100)) + "</span></div>  </div> </div>";
    }

    element += "   <div class=\"row mt-3 d-block\">"
        + "   <div class=\"m-l-30 float-left\"><button type=\"button\"><i class=\"ti-trash fs-22\" onclick=\"removeFromCart(" + productJson.pid + ")\"></i></button></div>"
        + "   <div class=\"m-l-40 float-left cl2 font-weight-bolder fs-17\">Available : <span id=\"cart-product-available-"+productJson.pid+"\" class=\"cl3\">" + productJson.quantity + "</span></div>"
        + "   <div class=\"m-r-20 pb-2 float-right\">"
        + "   <div class=\"wrap-num-product flex-w\">"
        + "   <div class=\"btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m\"><i class=\"fs-10 zmdi zmdi-minus\"></i></div>"
        + "   <input id=\"cart-product-quantity-" + productJson.pid + "\" class=\"txt-center num-product\" type=\"number\" name=\"num-product\" value=\"1\" min=\"0\" max=" + productJson.quantity + ">"
        + "   <div class=\"btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m\"><em class=\"fs-10 zmdi zmdi-plus\"></em></div> </div></div></div></div>";
    return element;
}

function getProductHeaderCartItem(productJson) {
    return '<li id="cart-product-header-' + productJson.pid + '" class="header-cart-item flex-w flex-t m-b-12">'
        + '<div class="header-cart-item-img"><img src="images/products/' + productJson.detailsDTOs[0].productImage + '"></div>'
        + '<div class="header-cart-item-txt p-t-8"><a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04"> '
        + productJson.name + ' </a> <span class="header-cart-item-info"> ' + productJson.price + '</span></div>'
        + '</li> ';
}

//logic of cart form
jQuery().ready(function () {
    $.validator.addMethod("regx", function (value, element, regexpr) {
        return regexpr.test(value);
    }, "Please enter a valid Egyptian Mobile Phone Number.");
    $.validator.addMethod("regxzip", function (value, element, regexpr) {
        return regexpr.test(value);
    }, "Please enter a valid Egyptian Post Code.");
    $.validator.addMethod("regxcreditcard", function (value, element, regexpr) {
        return regexpr.test(value);
    }, "Please enter a valid credit card number.");

    var v = jQuery("#cartform").validate({
        rules: {
            fname: {
                required: true,
                minlength: 2,
                maxlength: 16
            },
            lname: {
                required: true,
                minlength: 2,
                maxlength: 16
            },
            address: {
                required: true,
                minlength: 4,
                maxlength: 60
            },
            country: {
                required: true
            },
            state: {
                required: true
            },
            phone: {
                required: true,
                regx: /^01[012][0-9]{8}$/
            },
            shippingmethod: {
                required: true
            },
            postcode: {
                required: true,
                regxzip: /^[0-9]{5}$/
            }

        },
        errorElement: "span",
        errorClass: "help-inline"
    });

    $("#creditcardnumber").on("input", function () {
        num = $("#creditcardnumber").val();
        var reg = /^(\d{4}[- ]){3}\d{4}|\d{16}$/;
        if (reg.test(num)) {
            // perform some task
            $("#completeOrder").attr("disabled", false);
            $("#credit-validation").html("Valid")
        } else {
            $("#credit-validation").html("Invalid")
            $("#completeOrder").attr("disabled", true);
        }

    });

    // Binding next button on first step
    $(".open1").click(function () {
        console.log("Checking quantity ..");
        var isaccept = checkQuantity();
        console.log("Order state = " + isaccept);

        if (isaccept == true) {
            if (v.form()) {
                $(".frm").hide("fast");
                $(".cart-step1").removeClass("cart-form-active");
                $("#sf2").show("slow");
                $(".cart-step2").addClass("cart-form-active");
            }
        } else {
            console.log("Not matched conditions");
        }
    });

    // Binding next button on second step
    $(".open2").click(function () {


        if (v.form()) {
            $(".frm").hide("fast");
            $(".cart-step2").removeClass("cart-form-active");
            $("#sf3").show("slow");
            $(".cart-step3").addClass("cart-form-active");
        }


    });

    // Binding next button on third step
    $(".open3").click(function () {
        if (v.form()) {
            $(".frm").hide("fast");
            $(".cart-step3").removeClass("cart-form-active");
            $("#sf4").show("slow");
            $(".cart-step4").addClass("cart-form-active");
        }
    });


    // Binding back button on second step
    $(".back2").click(function () {
        $(".frm").hide("fast");
        $(".cart-step1").addClass("cart-form-active");
        $("#sf1").show("slow");
        $(".cart-step2").removeClass("cart-form-active");
    });

    // Binding back button on third step
    $(".back3").click(function () {
        $(".frm").hide("fast");
        $(".cart-step2").addClass("cart-form-active");
        $("#sf2").show("slow");
        $(".cart-step3").removeClass("cart-form-active");
    });

    // Binding back button on forth step
    $(".back4").click(function () {
        $(".frm").hide("fast");
        $(".cart-step3").addClass("cart-form-active");
        $("#sf3").show("slow");
        $(".cart-step4").removeClass("cart-form-active");
    });

    //when completing multi-form order cart
    $('.completeOrder').click(function () {
        $(".frm").hide("fast");
        var isstillaccepted = checkQuantity();
        if (isstillaccepted == true) {
            if (v.form()) {
                //now checkout order now
                var isSuccess = checkoutOrder();
                if (isSuccess) {
                    console.log("order saved !");
                    //Order summary
                    var cartproducts = $('#cart-products > div');
                    console.log("products in order = " + cartproducts.length);

                    var subtotal = 0;
                    for (var i = 0; i < cartproducts.length; i++)
                    {
                        var product = cartproducts[i];
                        var pid = product.getAttribute('data-id');
                        var pname = $('#cart-product-name-' + pid).html();
                        var price = $('#cart-product-price-' + pid).html();
                        subtotal += price;
                        var quantity = $('#cart-product-quantity-' + pid).val();
                        var img = $('#cart-product-image-' + pid).attr('src');
                        var element = getOrderSummeryElement(pid, pname, price, quantity, img);
                        console.log("to insert : " + element);
                        $("#order-summary-items").append(element);  //dummy
                        //set shipping cost
                        //set total cost
                    }
                    //set number of item
                    $('#order-summary-number').html(cartproducts.length);
                    $('#order-summary-subtotal').html(subtotal);
                    $('#order-summary-total').html(subtotal + 25);  //dummy shipping

                    //display summary of cart
                    //$("#cartform").html($(".cart-summary").html());
                    $(".frm").hide("fast");
                    $(".cart-step4").removeClass("cart-form-active");
                    $("#sf5").show("slow");
                    $(".cart-step1").addClass("cart-form-active");

                    setTimeout(rendercartafterorder, 10000);
                } else {
                    console.log("order failed !");
                }

                // Remove this if you are not using ajax method for submitting values
                return false;
            }
        }else{
            console.log("failed to ordering another user buy products");
            $(".frm").hide("fast");
            $(".cart-step4").removeClass("cart-form-active");
            $("#sf1").show("slow");
            $(".cart-step1").addClass("cart-form-active");
        }
    });
});

function getOrderSummeryElement(pid, pname, price,quantity, img)
{
    return '                            <div class="row mt-3 pt-3 delimiter-top">\n' +
        '                                <div class="col-8">\n' +
        '                                    <div class="media align-items-center"><img alt="Image placeholder" class="mr-2" src="'+img+'" style="width: 42px;">\n' +
        '                                        <div class="media-body">\n' +
        '                                            <div class="text-limit lh-100">\n' +
        '                                                <small class="font-weight-bold mb-0">'+pname+'</small>\n' +
        '                                            </div>\n' +
        '                                            <small class="text-muted">'+quantity+' x '+price+'</small>\n' +
        '                                        </div>\n' +
        '                                    </div>\n' +
        '                                </div>\n' +
        '                                <div class="col-4 text-right lh-100">\n' +
        '                                    <small class="text-dark">$ '+(quantity * price)+'</small>\n' +
        '                                </div>\n' +
        '                            </div>\n';
}

function rendercartafterorder() {
    $(".frm").hide("fast");
    $("#order-summary-items").html('');

    var cartproducts = $('#cart-products > div');
    for (var i = 0; i < cartproducts.length; i++)
    {
        var pid = cartproducts[i].getAttribute('data-id');
        var productelement = $("#product-" + pid);
        productelement.attr('data-incart', false);
    }
    $('#cart-products').html('');

    //switch to first item in list
    $(".cart-step4").removeClass("cart-form-active");
    $("#sf1").show("slow");
    $(".cart-step1").addClass("cart-form-active");
}