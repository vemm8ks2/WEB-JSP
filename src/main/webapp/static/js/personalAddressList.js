document.addEventListener('DOMContentLoaded', () => {
	const modifyBtns = document.querySelectorAll(`button[name='modify-btn']`);
	const hiddenInputs = document.querySelectorAll(`input[type='hidden'][name='addr-info']`);
	const modifyForm = document.querySelector(`form[method='POST'][action='modifyShippingAdddressDestination.do']`);
	let modifiedShippingAddrId = modifyForm.querySelector(`input[name='shipping-address-id']`);
	let prevShippingAddr = modifyForm.querySelector(`input[name='prev-shipping-address']`);
	
	Array.from(modifyBtns).forEach(btn => {
		btn.addEventListener('click', e => {
			const addrId = e.target.dataset.addrId;

			Array.from(hiddenInputs).forEach(input => {
				if (addrId === input.dataset.addrId) {
					const dest = input.dataset.addrDest;
					const id = input.dataset.addrId;
					
					prevShippingAddr.value = dest;
					modifiedShippingAddrId.value = id;
				};
			})
		})
	});
})