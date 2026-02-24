(function ($) {
	
	"use strict";

	// Page loading animation
$(window).on('load', function() {
    setTimeout(function() {
        $('#js-preloader').addClass('loaded');
    }, 5000);
});


})(window.jQuery);