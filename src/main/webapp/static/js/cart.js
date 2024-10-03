document.addEventListener('DOMContentLoaded', () => {
	const form = document.querySelector(`form[method='POST'][action='paymentView.do']`);

	form.addEventListener('submit', () => {
		const hiddenInputs = document.querySelectorAll(`input[type='hidden']`);
		
		hiddenInputs.forEach(el => el.remove());
		
		const checkboxes = document.querySelectorAll(`input[type='checkbox']`);

		checkboxes.forEach(checkbox => {
			if (!checkbox.checked) return;

			const idInput = document.createElement('input');
			const qtyInput = document.createElement('input');

			idInput.name = 'id';
			idInput.type = 'hidden';
			idInput.value = checkbox.name;

			qtyInput.name = 'qty';
			qtyInput.type = 'hidden';
			qtyInput.value = document.querySelector(`input[type='number'][data-product-id='${checkbox.name}']`).value;

			form.appendChild(idInput);
			form.appendChild(qtyInput);
		})
	})
	
	const quantities = document.querySelectorAll(`input[type='number']`);

	quantities.forEach(el => {
		el.addEventListener('change', (e) => {
						
			const id = e.currentTarget.dataset.productId;
			let qty = e.currentTarget.value;
			
			const totalPriceByProduct = document.querySelector(`span[data-product-total-price='${id}']`);
			const unitPrice = document.querySelector(`span[data-product-unit-price='${id}']`).textContent;
			
			if (e.target.value < 1) {
				e.currentTarget.value = 1;
				qty = 1;
				totalPriceByProduct.textContent = unitPrice;
			} else {
			    totalPriceByProduct.textContent = Number(qty) * Number(unitPrice);
			}
			
			const data = {
				id: document.querySelector(`input[type='hidden'][data-cart-id='${id}']`).value,
				qty
			}
			
			fetch('updateCart.do', {
				method: 'POST',
				body: new URLSearchParams(data),
			})
		})
	})	
	
	const deleteBtns = document.querySelectorAll(`button[type='button'][name='delete']`);
	
	deleteBtns.forEach(btn => {
		btn.addEventListener('click', (e) => {
			
			const id = e.currentTarget.dataset.deleteId;
			const form = document.createElement('form');
			
			form.method = 'POST';
			form.action ='deleteProductFromCart.do';
        
			const input = document.createElement('input');
			
			input.type = 'hidden';
			input.name = 'id';
			input.value = id;
			
			form.appendChild(input);
	        document.body.appendChild(form);
	        
			form.submit();
			
		})
	})
		
})
