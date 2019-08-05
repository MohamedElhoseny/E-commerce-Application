/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showProductDetails() {
    event.preventDefault();
    console.log("click on product : " + event.target.id);
    var ss = "#product-"+event.target.id;
    var jsonContent = $(ss).attr('data-product');
    renderShowProductDetails(jsonContent);
}

function renderShowProductDetails(productJson) {
    var product = JSON.parse(productJson);
    //rendering
    $('#show-product-name').html(product.name);
    $('#show-product-price').html(product.price);
    $('#show-product-id').html(getAddToCartBtn(product.pid));
    $('#show-product-quantity').attr("max", product.quantity);
    injectProductDescription(product.description);
    injectProductImages(product.detailsDTOs);
}

function injectProductImages(productImgs)
{
    var productImages = [];

    for (var j = 0; j < productImgs.length; j++)
        productImages.push(productImgs[j].productImage);

    var showproductdiv = '<div class="wrap-slick3 flex-sb flex-w">\n' +
        '                                    <div class="wrap-slick3-dots"></div>\n' +
        '                                    <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>\n' +
        '\n' +
        '                                    <div class="slick3 gallery-lb" id="images-gallery">\n' +
        '                                        \n' +
        '                                    </div>\n' +
        '                                </div>';


    $('#show-product-images').html(showproductdiv);

    for (var i = 0; i < productImages.length; i++) {
        $('#images-gallery').append('<div class="item-slick3" data-thumb="images/products/' + productImages[i] + '">\n' +
            '<div class="wrap-pic-w pos-relative">\n' +
            '<img src="images/products/' + productImages[i] + '" alt="IMG-PRODUCT">\n' +
            '<a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/products/' + productImages[i] + '">\n' +
            '<i class="fa fa-expand"></i>\n' +
            '</a>\n' +
            '</div>\n' +
            '</div>');
    }
    applySlickonProduct();
}

function applySlickonProduct()
{
    $('.wrap-slick3').each(function () {
        $(this).find('.slick3').slick({
            slidesToShow: 1,
            slidesToScroll: 1,
            fade: true,
            infinite: true,
            autoplay: false,
            autoplaySpeed: 6000,

            arrows: true,
            appendArrows: $(this).find('.wrap-slick3-arrows'),
            prevArrow: '<button class="arrow-slick3 prev-slick3"><i class="fa fa-angle-left" aria-hidden="true"></i></button>',
            nextArrow: '<button class="arrow-slick3 next-slick3"><i class="fa fa-angle-right" aria-hidden="true"></i></button>',

            dots: true,
            appendDots: $(this).find('.wrap-slick3-dots'),
            dotsClass: 'slick3-dots',
            customPaging: function (slick, index) {
                var portrait = $(slick.$slides[index]).data('thumb');
                return '<img src=" ' + portrait + ' "/><div class="slick3-dot-overlay"></div>';
            }
        });
    });
}

function getAddToCartBtn(pid)
{
    //add to cart get json not id SOLVE THIS
    var islogin = $('body').attr('data-login')
    return '<button onclick="addToCart('+pid+', '+islogin+')" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail"> Add to cart</button>\n';
}

function injectProductDescription(productDesc)
{
    var jsonContent = JSON.parse(productDesc);
    $('#show-product-processor').html(jsonContent.processor);
    $('#show-product-ram').html(jsonContent.ram);
    $('#show-product-vga').html(jsonContent.graphicsCard);
    $('#show-product-storage').html(jsonContent.storage);
    $('#show-product-os').html(jsonContent.os);
    $('#show-product-desc').text(jsonContent.description);
}