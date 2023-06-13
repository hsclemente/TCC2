$('.slider-content').slick({
  dots: true,
  infinite: true,
  speed: 300,
  slidesToShow: 1,
  adaptiveHeight: true
});

function sair() {
  localStorage.clear();
}

