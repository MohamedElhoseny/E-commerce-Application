/*     Wishlist dao     */

function addtoWishlist(productID, islogin) {
    event.preventDefault();

    console.log("productID = " + productID);
    var productJson = event.target.getAttribute('data-product');
    var heartIcon = "#heart-" + productID;
    var iswishlist = $(heartIcon).attr('data-wishlist');
    console.log(iswishlist);

    if (!islogin) {
        iziToast.warning({
            title: 'Caution',
            position: 'topCenter',
            progressBar: false,
            timeout: '3000',
            transitionIn: 'bounceInDown',
            message: 'Please login inorder to add product to your wishlist !'
        });
    } else {
        if (iswishlist == "true") {
            console.log("Removing from wishlist");
            removefromWishlist(productID);
            iziToast.info({
                title: 'Info',
                position: 'topCenter',
                progressBar: false,
                timeout: '3000',
                transitionIn: 'bounceInDown',
                message: 'Successfully deleted from Wishlist !'
            });

        } else {
            console.log("Adding to wishlist");

            //send to servlet to add to user wishlist
            $.ajax({
                type: 'POST',
                url: 'wishlist',
                data: {
                    'productId': productID
                },
                success: function (msg) {
                    //render wishlist ui
                    var jsonContent = JSON.parse(productJson);
                    $('#wishlist-products').append(getWishlistElement(jsonContent));
                    $(heartIcon).toggleClass("fa-heart fa-heart-o");
                    $(heartIcon).attr('data-wishlist', "true");

                    iziToast.success({
                        title: 'OK',
                        position: 'topCenter',
                        progressBar: false,
                        timeout: '3000',
                        transitionIn: 'bounceInDown',
                        message: 'Successfully Added To Wishlist !',
                    });
                }
            });
        }
    }
}

function removefromWishlist(productID) {
    event.preventDefault();

    var productIdentifier = "#wishlist-product-" + productID;
    console.log("removing element of id  : " + productIdentifier);

    var heartIcon = "#heart-" + productID;
    $(heartIcon).attr('data-wishlist', "false");
    $(heartIcon).toggleClass("fa-heart fa-heart-o");

    //send to servlet to remove from user wishlist 
    $.ajax({
        type: 'DELETE',
        url: 'wishlist?productId=' + productID,
        contentType: "application/x-www-form-urlencoded",

        success: function (msg) {
            //remove from ui list
            $(productIdentifier).remove();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //handle already exist or server is down
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

function getWishlistElement(productJson) {
    var element = "<div class=\"cart-item pt-4\" id=\"wishlist-product-" + productJson.pid + "\"> "
        + " <div class=\"row\"> "
        + " <div class=\"col-5\"><img src=\"images/products/" + productJson.detailsDTOs[0].productImage + " \">"
        + "</div> <div class=\"col-7\">"
        + " <div class=\"row\"><span class=\"cart-item-name\">" + productJson.name + "</span></div> ";

    if (productJson.discount == 0)
        element += "<div class=\"row mt-2\"><span class=\"cart-item-cost text-decoration-none\">EGP "
            + productJson.price + "</span></div>";
    else {
        element += "<div class=\"row mt-2\"><span class=\"cart-item-cost\">EGP " + productJson.price + "</span></div>"
            + "<div class=\"row mt-1\"><span class=\"cart-item-discount\">EGP " + (productJson.price-((productJson.price * productJson.discount) / 100)) + "</span></div>"
    }

    element += "</div> </div> "
        + " <div class=\"row mt-3 d-block\"> "
        + " <div class=\"m-l-30 float-left\"><button type=\"button\"><i class=\"ti-trash fs-22\" style=\"color:#007bff;\" onclick=\"removefromWishlist(" + productJson.pid + ")\" ></i></button></div>"
        + "<div class=\"m-r-20 pb-2 float-right\">"
        + "<button id=" + productJson.pid + " type=\"button\" onclick=\"addToCart(" + productJson.pid + ", true)\" class=\"btn primary-btn\">Add to cart</button> </div> </div></div>";
    return element;
}
