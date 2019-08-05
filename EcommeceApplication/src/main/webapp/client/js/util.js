/* ============= iziToast =========== */
iziToast.info({
    title: '',
    position: 'topCenter',
    progressBar: false,
    timeout: '8000',
    pauseOnHover: false,
    message: 'We recommend to run this web application on mobile !'
});

/* ================   PerfectScrollbar ======================*/
$('.js-pscroll').each(function () {
    $(this).css('position', 'relative');
    $(this).css('overflow', 'hidden');
    var ps = new PerfectScrollbar(this, {
        wheelSpeed: 1,
        scrollingThreshold: 1000,
        wheelPropagation: false
    });

    $(window).on('resize', function () {
        ps.update();
    })
});

/*================   sweetalert ======================*/

$('.js-addcart-detail').each(function () {
    var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
    $(this).on('click', function () {
        swal(nameProduct, "is added to cart !", "success");
    });
});

/*-================   select2 ======================*/
$(".js-select2").each(function () {
    $(this).select2({
        minimumResultsForSearch: 20,
        dropdownParent: $(this).next('.dropDownSelect2')
    });
});

/*-================   parallax100 ======================-*/
$('.parallax100').parallax100();


/*-================   magnificPopup ======================-*/
$('.gallery-lb').each(function () { // the containers for all your galleries
    $(this).magnificPopup({
        delegate: 'a', // the selector for gallery item
        type: 'image',
        gallery: {
            enabled: true
        },
        mainClass: 'mfp-fade'
    });
});