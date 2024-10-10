document.addEventListener('DOMContentLoaded', () => {
	const genderSelector = document.querySelector(`select[name='customer_gender']`);
	const defaultGender = document.querySelector(`input[type='hidden'][name='customer_default_gender']`);
	
	for (let i = 0; i < genderSelector.options.length; i++) {
		if (genderSelector.options[i].value === defaultGender.value) {
			genderSelector.options[i].selected = true;
			break;
		}
	}
})