const SERVER_BASE_URL = 'http://localhost:8585/WEB-JSP';

function proceedPay(){
	const paymentName = document.querySelector('input[type="hidden"][name="payment-name"]');
	const paymentAmount = document.querySelector('input[type="hidden"][name="payment-amount"]');
	const buyerName = document.querySelector('input[type="hidden"][name="payment-buyer-name"]');
	const buyerTel = document.querySelector('input[type="hidden"][name="payment-buyer-tel"]');
	const buyerAddr = document.querySelector('input[type="hidden"][name="payment-buyer-addr"]');
	const productIds = document.querySelectorAll('input[type="hidden"][name="purchase-product-id"]');
	const productsQty = document.querySelectorAll('input[type="hidden"][name="purchase-product-qty"]');
	
	const data = {
		payment_name: paymentName.value,
		payment_amount: paymentAmount.value,
		buyer_name: buyerName.value,
		buyer_tel: buyerTel.value,
		buyer_addr: buyerAddr.value,
		product_ids: Array.from(productIds).map(node => node.value),
		products_qty: Array.from(productsQty).map(input => input.value)
	}
	
	fetch(`${SERVER_BASE_URL}/paymentProceed.do`, {
		method: 'POST',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: new URLSearchParams(data),
	})
		.then(res => res.json())
		.then(data => {
			requestPay(data)
		})
}

function requestPay(data) {
	IMP.init("imp73344216");
	IMP.request_pay(
		{
			pg: "html5_inicis.INIpayTest",
			pay_method: "card",
			merchant_uid: data.orderId,
			name: data.paymentName,
			amount: data.paymentAmount,
          	buyer_email: "",
			buyer_name: data.buyerName,
			buyer_tel: data.buyerTel,
			buyer_addr: data.buyerAddr,
		},
		function(response) {
			if (!response.success) return;
			
			fetch(`${SERVER_BASE_URL}/paymentToken.do`, {
				method: 'POST',
				headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
				body: new URLSearchParams({ 
					imp_uid: response.imp_uid,
					merchant_uid: response.merchant_uid,
				})
			})
				.then(res => res.json())
				.then(data => {
					if (data.complete) {
						alert('상품 결제 완료');
						location.href = '';
					} else {
						alert('상품 결제 중 에러 발생');
						location.href = '';
					}
				})
		}
	);
}
