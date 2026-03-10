
(function ($) {
	
	"use strict";

	// Page loading animation
	$(window).on('load', function() {
		setTimeout(function(){
				$('#js-preloader').addClass('loaded');
			}, 1000);
        
    });
window.addEventListener("load", function() {
    setTimeout(function() {
        document.getElementById("js-preloader").classList.add("loaded");
    }, 5000);
});
	// Page loading animation
	$(window).on('load', function() { 
		if($('.cover').length){
			$('.cover').parallax({
				imageSrc: $('.cover').data('image'),
				zIndex: '1'
			});
		}

		$("#preloader").animate({
			'opacity': '0'
		}, 600, function(){
			setTimeout(function(){
				$("#preloader").css("visibility", "hidden").fadeOut();
			}, 300);
		});
	});
    


})(window.jQuery);