let menuIcon = document.querySelector('#menu-icon');
let navbar = document.querySelector('.navbar');

menuIcon.onclick = () => {
  menuIcon.classList.toggle('bx-x');
  navbar.classList.toggle('active');
}

/*Script para o carrosel do banner*/ 
$(document).ready(function(){
let current = 0
const slides = $(".slides")
const total = $(".slide").length
const dots = $(".dot")

let timer;
function resetTimer() {
    clearInterval(timer)
    timer = setInterval(() => nextSlide(), 5000)
}

function updateSlider(){

slides.css("transform","translateX(-"+current*100+"%)")

dots.removeClass("active")
dots.eq(current).addClass("active")

}

function nextSlide(){

current++

if(current >= total){
current = 0
}
resetTimer()
updateSlider()

}

function prevSlide(){

current--

if(current < 0){
current = total - 1
}
resetTimer()
updateSlider()

}

$(".arrow.right").click(function(){
nextSlide()
})

$(".arrow.left").click(function(){
prevSlide()
})

dots.click(function(){

current = $(this).index()

updateSlider()

})
resetTimer()
})

var sliders = document.querySelectorAll(".games-slider");

sliders.forEach(slider => {

new Swiper(slider, {

slidesPerView: 5,
spaceBetween: 20,

loop: true,
slidesPerGroup: 1,

speed: 800,

navigation: {
nextEl: slider.querySelector(".swiper-button-next"),
prevEl: slider.querySelector(".swiper-button-prev"),
},

scrollbar: {
el: slider.querySelector(".swiper-scrollbar"),
draggable: true
},
breakpoints: {

0: {
slidesPerView: 2
},

600: {
slidesPerView: 3
},

900: {
slidesPerView: 4
},

1200: {
slidesPerView: 5
}

}



});

});
