document.addEventListener('DOMContentLoaded', () => {
  const prevBtn = document.querySelector('button.carousel-prev-btn');
  const nextBtn = document.querySelector('button.carousel-next-btn');

  prevBtn.addEventListener('click', () => slideCarousel('prev'));
  nextBtn.addEventListener('click', () => slideCarousel('next'));

  const slideCarousel = (direction) => {
    const carousel = document.querySelector('div.display-products__carousel');
    const transformValue = carousel.style.transform;

    const regex = /translateX\((-?\d+(\.\d+)?)%\)/;
    const match = transformValue.match(regex);

    const distance = 20;
    const max = 0;
    const min = -79;
    let translateXValue = parseFloat(match[1])

    if (direction == 'prev') {
      translateXValue += distance;
      if (translateXValue > max) translateXValue = max;
    }
    if (direction == 'next') {
      translateXValue -= distance;
      if (translateXValue < min) translateXValue = min;
    }

    carousel.setAttribute('style', `transform: translateX(${translateXValue}%)`)
  }
})