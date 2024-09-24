IMP.init("imp73344216");

function requestPay() {
	const paymentName = document.querySelector('input[type="hidden"][name="payment-name"]');
	const paymentAmount = document.querySelector('input[type="hidden"][name="payment-amount"]');
	const buyerName = document.querySelector('input[type="hidden"][name="payment-buyer-name"]');
	const buyerTel = document.querySelector('input[type="hidden"][name="payment-buyer-tel"]');
	const buyerAddr = document.querySelector('input[type="hidden"][name="payment-buyer-addr"]');
	
	IMP.request_pay(
		{
			pg: "html5_inicis.INIpayTest",
			pay_method: "card",
			merchant_uid: `payment-${crypto.randomUUID()}`, // 주문 고유 번호
			name: paymentName.value,
			amount: paymentAmount.value,
			buyer_name: buyerName,
			buyer_tel: buyerTel,
			buyer_addr: buyerAddr,
		},
		function(response) {
			// TODO(24.09.24)
			// 결제 종료 시 호출되는 콜백 함수
			// response.imp_uid 값으로 결제 단건조회 API를 호출하여 결제 결과를 확인하고,
			// 결제 결과를 처리하는 로직을 작성합니다.

 		    if (response.success) {
 				console.log(response);
			} else {
				console.log(response);
			}
			/*$.ajax({
              type: 'POST',
              url: '/verify/' + rsp.imp_uid
            }).done(function(data) {
              if(rsp.paid_amount === data.response.amount){
                alert("결제 성공");
              } else {
                alert("결제 실패");
              }
            });*/
		}
	);
}