$(document).ready(function () {
  // 슬라이드
  $(".slide").not(".active").hide(); //active 클래스를 가지지 않는 div를 숨기기
});



function prevSlide() {
  let slides = $(".slide");
  slides.hide();
  let allSlide = slides;
  let curIndex = 0;

  slides.each(function (index, slide) {
    if ($(this).hasClass("active")) {
      curIndex = index;
    }
  });
  
  

  let newIndex = 0;
  if (curIndex <= 0) {
    newIndex = allSlide.length - 1;
  } else {
    newIndex = curIndex - 1;
  }

  slides.removeClass("active");

  slides.eq(newIndex).addClass("active");
  slides.eq(newIndex).show();
}

function nextSlide() {
  let slides = $(".slide");
  slides.hide();
  let allSlide = slides;
  let curIndex = 0;

  slides.each(function (index, slide) {
    if ($(this).hasClass("active")) {
      curIndex = index;
    }
  });

  let newIndex = 0;
  if (curIndex >= allSlide.length - 1) {
    newIndex = 0;
  } else {
    newIndex = curIndex + 1;
  }

  slides.removeClass("active");

  slides.eq(newIndex).addClass("active");
  slides.eq(newIndex).show();
}