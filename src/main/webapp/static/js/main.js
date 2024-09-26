document.addEventListener('DOMContentLoaded', () => {
  const prevBtnList = document.querySelectorAll('button.carousel-prev-btn');
  const nextBtnList = document.querySelectorAll('button.carousel-next-btn');

  prevBtnList.forEach((node, i) => {
    node.addEventListener('click', () => slideCarousel('prev', i + 1));
  })

  nextBtnList.forEach((node, i) => {
    node.addEventListener('click', () => slideCarousel('next', i + 1));
  })

  const slideCarousel = (direction, i) => {
    const carousel = document.querySelector(`div.display-products__carousel.carousel-no-${i}`);
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