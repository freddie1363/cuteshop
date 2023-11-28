//GC-3A 2101060 김정현
$(document).ready(function () {
  textAni();//글자 애니메이션 효과 함수 호출
});

function nextSemester() {//DB연결 필요한 기능의 버튼들 누르면 호출
  alert("DB연결 및 기능 구현은 2학기 때 교수님께 배우고 적용하겠습니다.");
}

function textAni(){//글자 생기면서 이동시키는 jQuery 애니메이션 작동
  $('#severaltext1').animate({opacity:"1"},1000);//투명도 이용해서 점점 글자가 생기는거 처럼 보이게함.
  $('#severaltext2').animate({opacity:"1"},1000);
  $('#severaltext1').animate({top:"35%"},500);//글자가 아래로 점점 움직이는거 처럼 보이게함.
  $('#severaltext2').animate({top:"50%"},500);
}
