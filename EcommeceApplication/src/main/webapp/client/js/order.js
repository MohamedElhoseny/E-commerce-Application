function checkQuantity() {
    var cartproducts = $('#cart-products > div');
    var jsonContent = getJSONCurrentCartProduct(cartproducts);
    return getRequestedOrderState(jsonContent, cartproducts);
}

function getJSONCurrentCartProduct(cartproducts) {
    var jsonContent = {
        "sufficient": false,
        "products": []
    };

    for (var i = 0; i < cartproducts.length; i++) {
        var product = cartproducts[i];
        console.log(product);

        var pid = product.getAttribute('data-id');
        var pavailable = product.getAttribute('data-available');
        var pquanitity = $("#cart-product-quantity-" + pid).val();

        console.log(pid);
        console.log(pavailable);
        console.log(pquanitity);
        jsonContent.products.push({
            "pid": pid,
            "available": pavailable,
            "quantity": pquanitity,
            "valid": false
        });
    }

    console.log(jsonContent);

    return jsonContent;
}

function getRequestedOrderState(jsonContent, cartProducts) {
    var accept = true;
    console.log("Checking order state ..");

    //send to servlet to add to user cart
    $.ajax({
        type: 'POST',
        url: 'validateProduct',
        data: {"order": JSON.stringify(jsonContent)},
        dataType: 'json',
        async : false,
        contentType: "application/x-www-form-urlencoded",
        traditional: true,
        success: function (data) {
            var sufficient = data.sufficient;
            console.log("server response to sufficient : " + sufficient);

            if (sufficient == false) {
                accept = false;
                iziToast.error({
                    title: 'Info : ',
                    position: 'topCenter',
                    progressBar: false,
                    timeout: '3000',
                    transitionIn: 'bounceInDown',
                    message: 'Insufficient funds to process this order, check your wallet !'
                });
            } else {
                var products = data.products;
                console.log(products);
                for (var i = 0; i < cartProducts.length; i++) {
                    var productvalid = products[i].valid;
                    console.log("Product "+i+" : valid = "+productvalid);
                    if (productvalid == false) {
                        accept = false;
                        var productdiv = cartProducts[i];
                        console.log("available = "+ products[i].available);
                        var productavailable = products[i].available;
                        productdiv.setAttribute('data-available', productavailable);
                        $('#cart-product-available-'+products[i].pid).html(productavailable);
                        iziToast.error({
                            title: 'Info : ',
                            position: 'topCenter',
                            progressBar: false,
                            timeout: '3000',
                            transitionIn: 'bounceInDown',
                            message: 'Check availability of products !'
                        });
                        break;
                    } else {
                        accept = true;
                    }
                }
            }
        },
        error: function (data) {
            accept = false;
            iziToast.error({
                title: 'Info : ',
                position: 'topCenter',
                progressBar: false,
                timeout: '3000',
                transitionIn: 'bounceInDown',
                message: 'Check your wallet first !'
            });
        }
    });

    console.log("after ajax request ... ");
    return accept;
}

function checkoutOrder() {
    var accept = false;
    var cartproducts = $('#cart-products > div');
    var jsonContent = getJSONCurrentCartProduct(cartproducts);

    // get the form data
    // there are many ways to get this data using jQuery (you can use the class or id also)
    var orderJson = {
        'products': jsonContent.products,
        'fname': $('#cart-fname').val(),
        'lname': $('#cart-lname').val(),
        'address': $('#cart-address').val(),
        'country': $('#country').val(),
        'city': $('#state').val(),
        'postalcode': $('#cart-postalcode').val(),
        'phone': $('#cart-phone').val(),
        'creditcardnumber': $('#creditcardnumber').val()
    };
    console.log("Order request Json : "+orderJson);
    // process the form
    $.ajax({
        type: 'POST', // define the type of HTTP verb we want to use (POST for our form)
        url: 'createOrder', // the url where we want to POST
        dataType: 'json',
        async : false,
        data: {"order": JSON.stringify(orderJson)},
        contentType: "application/x-www-form-urlencoded",
        traditional: true,
        success: function (data) {
            console.log("Order data received from server = "+data);
            $('#order-summary-id').html('#'+data);
            if (data != -1) {
                accept = true;
                iziToast.success({
                    title: 'Info : ',
                    position: 'topCenter',
                    progressBar: false,
                    timeout: '3000',
                    transitionIn: 'bounceInDown',
                    message: 'Your Order is processed succeded, OrderID = ' + data + ' !'
                });
            } else {
                accept = false;
                iziToast.error({
                    title: 'Info : ',
                    position: 'topCenter',
                    progressBar: false,
                    timeout: '3000',
                    transitionIn: 'bounceInDown',
                    message: 'Failed to process your order, Try again later !'
                });
            }
        },
        error: function (data) {
            accept = false;
            iziToast.error({
                title: 'Info : ',
                position: 'topCenter',
                progressBar: false,
                timeout: '3000',
                transitionIn: 'bounceInDown',
                message: 'Failed to process your order, Try again later !'
            });
        }
    });
    return accept;
}