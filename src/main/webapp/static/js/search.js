  document.addEventListener('DOMContentLoaded', () => {
    const url = new URL(location.href);
    const params = new URLSearchParams(url.search);

    const sort = params.get('sort-filter');
    const price = params.get('price-filter');
    const categories = params.getAll('category-filter');

    if (sort) {
      const radio = document.querySelector(`input[name='sort-filter'][value='${sort}']`)
      if (radio) radio.checked = true;
    }

    if (price) {
      const radio = document.querySelector(`input[name='price-filter'][value='${price}']`)
      if (radio) radio.checked = true;
    }

    categories.forEach(value => {
      const checkbox = document.querySelector(`input[name='category-filter'][value='${value}']`)
      if (checkbox) checkbox.checked = true;
    })
  })

  const handleFilter = () => {
    const filterForm = document['search-filter-form'];
    filterForm.submit();
  }
