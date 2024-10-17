document.addEventListener('DOMContentLoaded', () => {
	const modifyBtns = document.querySelectorAll(`button[name='modify-btn']`);
	const deleteBtns = document.querySelectorAll(`button[name='delete-btn']`);
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
	
	Array.from(deleteBtns).forEach(btn => {
		btn.addEventListener('click', e => {
			const addrId = e.target.dataset.addrId;
			
			const form = document.createElement('form');
			form.method = 'POST';
			form.action = 'deleteShippingAddress.do'
			
			const data = new URLSearchParams();
			data.append('id', addrId);
			
			data.forEach((value, key) => {
				const input = document.createElement('input');
				
				input.type = 'hidden';
				input.name = key;
				input.value = value;
				
				form.appendChild(input);
			})
			
			document.body.appendChild(form);
			
			form.submit();
		})
	})
})