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


/* swiper dos jogos */
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
let currentGame = 0;


document.querySelector(".feature-arrow.right").onclick = () => {
  const total = document.querySelectorAll(".feature-item").length;
  currentGame = (currentGame + 1) % total;
  changeGame(currentGame);
};

document.querySelector(".feature-arrow.left").onclick = () => {
  const total = document.querySelectorAll(".feature-item").length;
  currentGame = (currentGame - 1 + total) % total;
  changeGame(currentGame);
};


function renderStars(score){

let stars=""

for(let i=1;i<=10;i++){

if(i<=score){
stars+="★"
}else{
stars+="☆"
}

}

return stars

}

function changeGame(index){
  currentGame = index;

  const items = document.querySelectorAll(".feature-item");
  const game = items[index];

  const title = game.getAttribute("data-title");
  const description = game.getAttribute("data-description");
  const price = game.getAttribute("data-price");
  const image = game.getAttribute("data-image");
  const rating = game.getAttribute("data-rating");
  
  document.getElementById("feature-img").style.opacity = 0;

  setTimeout(() => {
    document.getElementById("feature-img").src = image;
    document.getElementById("feature-img").style.opacity = 1;
  }, 200);
  
  document.getElementById("game-title").innerText = title;
  document.getElementById("game-description").innerText = description;
  document.getElementById("game-price").innerText = price;
  document.getElementById("game-rating").innerHTML = renderStars(rating);

  
  // ativa thumbnail
  document.querySelectorAll(".feature-item").forEach((el, i) => {
    el.classList.toggle("active", i === index);
  });
}

new Swiper(".popular-slider",{

slidesPerView:1,
spaceBetween:20,

loop:false,

navigation:{
nextEl:".popular-slider .swiper-button-next",
prevEl:".popular-slider .swiper-button-prev",
},

scrollbar:{
el:".popular-slider .swiper-scrollbar",
draggable:true,
},

observer: true,
observeParents: true,
observeSlideChildren: true,

updateOnWindowResize: true,

speed:800

});


window.onload = () => {
  const items = document.querySelectorAll(".feature-item");

  if (items.length > 0) {
    changeGame(0);
  }
};


