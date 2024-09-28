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

	Array.from(checkboxes).forEach(checkbox => {
		checkbox.addEventListener('click', (e) => {
			uncheckingParentCheckboxes(e.target, checkboxes);
			uncheckingChildCheckboxes(e.target, checkboxes);

			const filterForm = document['search-filter-form'];
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
