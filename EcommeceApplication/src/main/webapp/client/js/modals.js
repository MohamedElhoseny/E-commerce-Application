/*============================= Attributes of iziModal ========================================
 title: '', //Title in modal's header.
 subtitle: '', //Caption below modal's title.
 headerColor: '#88A0B9', //Color to fill the header background, will also be applied to the bottom edge of the modal.
 background: null, //Modal background.
 theme: '', //Theme of the modal, can be empty or "light". 
 icon: null, //Icon class (font-icon of your choice) that will be displayed in modal header.
 iconText: null, //Icon text (font-icon using text) that will be displayed in modal header.
 iconColor: '', //Color of the header icon.
 rtl: false, //Right To Left option.
 width: null, //	Fixed width of the modal. You can use %, px, em or cm. If not using a measure unity, PX will be assumed as measurement unit.
 top: null, //Top static margin.
 bottom: null, //Bottom static margin.
 borderBottom: false, //Enable/disable border bottom.
 padding: 0, //Modal inner margin.
 radius: 0, //Border-radius that will be applied in modal.
 zindex: 999, //The z-index CSS attribute of the modal.
 iframe: false, //If true, an Iframe will be used inside the modal.
 iframeHeight: 400, //Fixed height of the iframe.
 iframeURL: null, //Address that will open in the iframe inside the modal, if not set, the user can alternatively use the href link responsible for opening it.
 focusInput: false, //If set true, whenever you open a modal, the first visible field is active.
 group: '',	//Create a group with same 'group' name, so can navigate between them.
 loop: false,	//It allows loop with modals of the same group.
 arrowKeys: false, //Enable control by arrows keys.
 navigateCaption: false,	//Displays arrows to navigate.
 navigateArrows: 'false', // Change arrows position to navigate between the modals. It can be: 'closeToModal' or 'closeScreenEdge'.
 history: false,	//Enable browsing history with hash.
 restoreDefaultContent: false,	//Reset the modal to default to be opened again.
 autoOpen: 0, // If true, the modal opens automatically with any user action. Or you can set a delay time (in milliseconds) to open.
 bodyOverflow: false, //Forcing overflow hidden in the document when opening the modal, closing the modal, overflow will be restored.
 fullscreen: false,	//Show a button in modal header to expand.
 openFullscreen: true, //Force to open modal in fullscreen.
 closeOnEscape: true, //If set true, you can close the modal only pressing the escape key.
 closeButton: false,	//Display close button in the header.
 appendTo: '#mainpage', // Where the modal will be placed?
 appendToOverlay: '#mainpage', // Where the modal overlay will be placed?
 overlay: true,	//Enable or disable background overlay.
 overlayClose: false,	//If set true, the modal will be closed clicking outside of it.
 overlayColor: 'rgba(0, 0, 0, 0.4)',	//Color overlay.
 timeout: false,	//Amount in milliseconds to close the modal or false to disable.
 timeoutProgressbar: false,	//Enable timeout progress bar.
 pauseOnHover: false,  //Pause the progress bar when mouse cursor hover the modal.
 timeoutProgressbarColor: 'rgba(255,255,255,0.5)', //Progress bar color.
 transitionIn: 'comingIn', // comingIn, bounceInDown, bounceInUp, fadeInDown, fadeInUp, fadeInLeft, fadeInRight, flipInX
 transitionOut: 'comingOut', // comingOut, bounceOutDown, bounceOutUp, fadeOutDown, fadeOutUp, , fadeOutLeft, fadeOutRight, flipOutX
 transitionInOverlay: 'fadeIn',	//Default transition of overlay opening.
 transitionOutOverlay: 'fadeOut', //Default transition of overlay closure.
 onFullscreen: function () {},
 onResize: function () {},
 onOpening: function () {},
 onOpened: function () {},
 onClosing: function () {},
 onClosed: function () {},
 */


/*************************** Modals ****************************/
$("#loginpage").iziModal({
    title: 'Account',
    subtitle: 'Sign in with your account.',
    headerColor: '#37475A',
    background: 'light',
    theme: 'dark', // light
    icon: "ti-user",
    iconText: null,
    iconColor: '#FFF',
    rtl: false,
    width: 600,
    top: null,
    bottom: null,
    borderBottom: true,
    padding: 0,
    radius: 3,
    zindex: 999,
    iframe: false,
    iframeHeight: 400,
    iframeURL: null,
    focusInput: false,
    group: 'modals',
    loop: true,
    arrowKeys: false,
    navigateCaption: true,
    navigateArrows: true, // Boolean, 'closeToModal', 'closeScreenEdge'
    history: false,
    restoreDefaultContent: false,
    autoOpen: 0, // Boolean, Number
    bodyOverflow: false,
    fullscreen: false,
    openFullscreen: true,
    closeOnEscape: true,
    closeButton: true,
    appendTo: 'body', // or false
    appendToOverlay: 'body', // or false
    overlay: true,
    overlayClose: true,
    overlayColor: 'rgba(0, 0, 0, 0.4)',
    timeout: false,
    timeoutProgressbar: false,
    pauseOnHover: false,
    timeoutProgressbarColor: 'rgba(255,255,255,0.5)',
    transitionIn: 'fadeInUp', // comingIn, bounceInDown, bounceInUp, fadeInDown, fadeInUp, fadeInLeft, fadeInRight, flipInX
    transitionOut: 'fadeOutUp',
    transitionInOverlay: 'fadeIn',
    transitionOutOverlay: 'fadeOut',
    onFullscreen: function () {},
    onResize: function () {},
    onOpening: function () {},
    onOpened: function () {},
    onClosing: function () {},
    onClosed: function () {},
    afterRender: function () {}
});
$("#registerpage").iziModal({
    title: 'Account',
    subtitle: 'Create a new account .',
    headerColor: '#37475A',
    background: 'light',
    theme: 'dark', // light
    icon: "ti-user",
    iconText: null,
    iconColor: '#FFF',
    rtl: false,
    width: 600,
    top: null,
    bottom: null,
    borderBottom: true,
    padding: 0,
    radius: 3,
    zindex: 999,
    iframe: false,
    iframeHeight: 400,
    iframeURL: null,
    focusInput: false,
    group: 'modals',
    loop: true,
    arrowKeys: false,
    navigateCaption: true,
    navigateArrows: true, // Boolean, 'closeToModal', 'closeScreenEdge'
    history: false,
    restoreDefaultContent: false,
    autoOpen: 0, // Boolean, Number
    bodyOverflow: false,
    fullscreen: false,
    openFullscreen: true,
    closeOnEscape: true,
    closeButton: true,
    appendTo: 'body', // or false
    appendToOverlay: 'body', // or false
    overlay: true,
    overlayClose: true,
    overlayColor: 'rgba(0, 0, 0, 0.4)',
    timeout: false,
    timeoutProgressbar: false,
    pauseOnHover: false,
    timeoutProgressbarColor: 'rgba(255,255,255,0.5)',
    transitionIn: 'fadeInUp', // comingIn, bounceInDown, bounceInUp, fadeInDown, fadeInUp, fadeInLeft, fadeInRight, flipInX
    transitionOut: 'fadeOutUp',
    transitionInOverlay: 'fadeIn',
    transitionOutOverlay: 'fadeOut',
    onFullscreen: function () {},
    onResize: function () {},
    onOpening: function () {},
    onOpened: function () {},
    onClosing: function () {},
    onClosed: function () {},
    afterRender: function () {}
});



/***************** Handling pages & modals events *****************/
$('.loginModal').click(function () {
    event.preventDefault();
    $('#registerpage').iziModal('close');
    $('#loginpage').iziModal('open');
});
$('.registerModal').click(function () {
    event.preventDefault();
    $('#loginpage').iziModal('close');
    $('#registerpage').iziModal('open');
});

