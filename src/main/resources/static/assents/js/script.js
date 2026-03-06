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

updateSlider()

}

function prevSlide(){

current--

if(current < 0){
current = total - 1
}

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

setInterval(function(){
nextSlide()
},5000)

})