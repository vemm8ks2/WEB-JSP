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

	const checkboxes = document.querySelectorAll(`input[type='checkbox'][name='category-filter']`);
	const priceFilters = document.querySelectorAll(`input[type='radio'][name='price-filter']`);
	const sortFilters = document.querySelectorAll(`input[type='input'][name='sort-filter']`);
	const paginationBtns = document.querySelectorAll(`button[name='pagination-btn']`);
	
	const filterForm = document['search-filter-form'];
	 
	Array.from(checkboxes).forEach(checkbox => {
		checkbox.addEventListener('click', (e) => {
			uncheckingParentCheckboxes(e.target, checkboxes);
			uncheckingChildCheckboxes(e.target, checkboxes);

			filterForm.submit();
		})
	})
	
	Array.from(priceFilters).forEach(filter => {
		filter.addEventListener('click', () => handleFilter());
	})
	
	Array.from(sortFilters).forEach(filter => {
		filter.addEventListener('click', () => handleFilter());
	})
	
	const paginationInput = document.querySelector(`input[type='hidden'][name='page']`);
	
	Array.from(paginationBtns).forEach(btn => {
		btn.addEventListener('click', (e) => {
			const page = e.currentTarget.dataset.page;
			paginationInput.value = page;
			
			filterForm.submit();
		})
	})
})

const uncheckingParentCheckboxes = (target, checkboxes) => {
	checkboxes.forEach((checkbox) => {
		if (target.dataset.parentCategory == checkbox.value) {
			const parentId = checkbox.value;
			const parentCheckbox = document.querySelector(`input[name="category-filter"][value="${parentId}"]`);

			parentCheckbox.checked = false;
			parentCheckbox.classList.add('display-products__filter-category__open');
		}
	})
}

const uncheckingChildCheckboxes = (target, checkboxes) => {
	const uncheckRecursively = (parentValue) => {
		checkboxes.forEach((checkbox) => {
			if (checkbox.dataset.parentCategory == parentValue) {
				checkbox.checked = false;
				checkbox.classList.remove('display-products__filter-category__open');

				uncheckRecursively(checkbox.value);
			}
		});
	};

	uncheckRecursively(target.value);
}

const handleFilter = () => {
  const filterForm = document['search-filter-form'];
  filterForm.submit();
}