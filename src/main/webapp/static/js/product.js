document.addEventListener('DOMContentLoaded', () => {
	const productId = document.querySelector('input[type="hidden"][name="product-id"]');
	
	const unitPrice = document.querySelector('input[type="hidden"][name="unit-price"]');
	const totalPrice = document.querySelector('span.total-price');
	
	const minusBtn = document.querySelector('button.minus-btn');
	const plusBtn = document.querySelector('button.plus-btn');
	
	minusBtn.addEventListener('click', () => handleQtyBtn('minus'));
	plusBtn.addEventListener('click', () => handleQtyBtn('plus'));
	
	const handleQtyBtn = (command) => {
		const productQty = document.querySelector('.product-quantity-number');
		const qty = Number(productQty.textContent);
		
		if (command === 'minus') productQty.textContent = qty - 1;
		if (command === 'plus') productQty.textContent = qty + 1;
		
		totalPrice.textContent = (unitPrice.value * productQty.textContent).toLocaleString();
	}
	
	const purchaseBtn = document.querySelector('button[name="purchase-btn"]');
	
	purchaseBtn.addEventListener('click', () => {
		const form = document.createElement('form');
        form.method = 'POST';
        form.action = 'paymentView.do';
        
        const data = new URLSearchParams();
        data.append('id', [productId.value]);
        data.append('qty', [getQty()]);
        
        data.forEach((value, key) => {
            const input = document.createElement('input');
            
            input.type = 'hidden';
            input.name = key;
            input.value = value;
            
            form.appendChild(input);
        });
        
        document.body.appendChild(form);
        
		form.submit();
	})
	
	const getQty = () => {
		return document.querySelector('.product-quantity-number').textContent;
	}
	
})