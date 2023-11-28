//GC-3A 2101060 김정현
function estimatecheck(){//견적 문의 버튼 누르면 호출
  var ename = document.getElementById('estimatename').value;//이름
  var ephone = document.getElementById('estimatephone').value;//전화
  var emoney = document.getElementById('estimatemoney').value;//후원금액
  var econtent = document.getElementById('estimatecontent').value;//내용
  var eagree = document.getElementById('estimateprivacyagree').checked;//동의버튼 체크 여부

  if(ename.length < 1){//이름 썼는지 확인
    alert('이름을 입력하세요');
    document.getElementById('estimatename').focus();
    return false;
  }
  if(ephone.length < 1){//전화 썼는지 확인
    alert('핸드폰을 입력하세요');
    document.getElementById('estimatephone').focus();
    return false;
  }
  if(emoney.length < 1 || emoney < 1000){//후원금액 썼는지 확인
    alert('후원금액은 최소 1000원 이상으로 숫자로만 입력하세요');
    document.getElementById('estimatemoney').focus();
    return false;
  }
  if(econtent.length < 1){//내용 썼는지 확인
  	alert('내용을 입력하세요');
    document.getElementById('estimatecontent').focus();
    return false;
  }
  if(eagree != true){//동의버튼 체크했는지 확인
    alert('개인정보 취급 방침에 동의 하셔야 합니다.');
    return false;
  }


//실제 복사하여 사용시에는 모든 주석을 지운 후 사용하세요
	  BootPay.request({
	      price: emoney, //실제 결제되는 가격
	 
	      // 관리자로그인 -> 결제설치 -> 인증키 및 보안 -> WEB Application ID
	      application_id: "6443c41b755e27001ce57da5",
	 
	      name: '영진 김정현 사이트 후원하기', //결제창에서 보여질 이름
	      pg: 'nicepay',
	      method: '', //결제수단, 입력하지 않으면 결제수단 선택부터 화면이 시작합니다.
	      show_agree_window: 0, // 부트페이 정보 동의 창 보이기 여부
	      items: [
	          {
	              item_name: '나는 아이템', //상품명
	              qty: 1, //수량
	              unique: '123', //해당 상품을 구분짓는 primary key
	              price: 1000, //상품 단가
	          }
	      ],
	      order_id: '고유order_id_1234', //고유 주문번호로, 생성하신 값을 보내주셔야 합니다.
	  }).error(function (data) {
	      //결제 진행시 에러가 발생하면 수행됩니다.
	      alert('결제 에러 발생');
	      console.log(data);
	  }).cancel(function (data) {
	      //결제가 취소되면 수행됩니다.	      
	      console.log(data);
	  }).close(function (data) {
	      // 결제창이 닫힐때 수행됩니다. (성공,실패,취소에 상관없이 모두 수행됨)
	      console.log(data);
	  }).done(function (data) {
	      //결제가 정상적으로 완료되면 수행됩니다
	      //비즈니스 로직을 수행하기 전에 결제 유효성 검증을 하시길 추천합니다.
	      document.payfrm.submit();
	      alert('결제 정상 완료. 후원 감사합니다');
	      console.log(data);
	  });
}
