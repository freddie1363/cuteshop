//GC-2A 2101060 김정현
$(document).ready(function () {
  $(".slide").click(potalImgBtn); //메인사진 밑에 슬라이드 버튼 누르면 호출
  setInterval("changePotalImg()", "4000");//인덱스 메인사진 바꾸는 함수 주기적으로 계속 호출
  indexTextInitialize();//메인사진 글자 애니메이션 효과 초기화
  indexTextAni();//메인사진 글자 애니메이션 효과
  imageAni();//인덱스 아래에 있는 갤러리사진들 애니메이션 효과
});

function nextSemester() {//DB연결 필요한 기능의 버튼들 누르면 호출
  alert("DB연결 및 기능 구현은 2학기 때 교수님께 배우고 적용하겠습니다.");
}

function indexTextAni(){//글자 생기면서 이동시키는 jQuery 애니메이션 작동
  $('#indextext1').animate({opacity:"1"},600);//투명도 이용해서 점점 글자가 생기는거 처럼 보이게함.
  $('#indextext1').animate({top:"25%"},600);//글자가 아래로 점점 움직이는거 처럼 보이게함.
  $('#indextext2').animate({opacity:"1"},600);
  $('#indextext2').animate({top:"47%"},600);
  $('#indextext3').animate({opacity:"1"},600);
  $('#indextext3').animate({top:"67%"},600);

}

function indexTextInitialize(){//애니메이션 작동 전 상태로 돌리기, 초기화 initialize
  $('#indextext1').css("opacity", "0");//전부 0으로 초기화 한다.
  $('#indextext2').css("opacity", "0");
  $('#indextext3').css("opacity", "0");
  $('#indextext1').css("top","15%");
  $('#indextext2').css("top","32%");
  $('#indextext3').css("top","47%");
}

function askcheck(){//인덱스 문의사항 보내기 버튼 누르면 호출
  var askname = document.getElementById('askname').value;//이름
  var askphone = document.getElementById('askphone').value;//전화
  var askcontent = document.getElementById('askcontent').value;//내용
  var askagree = document.getElementById('askprivacyagree').checked;//동의버튼 체크 여부

  if(askname.length < 1){//이름 안씀 확인
    alert('이름을 입력하세요');
    document.getElementById('askname').focus();
    return false;
  }
  if(askphone.length < 1){//전화 안씀 확인
    alert('연락처를 입력하세요');
    document.getElementById('askphone').focus();
    return false;
  }
  if(askcontent.length < 1){//내용 안씀 확인
    alert('문의내용을 입력하세요');
    document.getElementById('askcontent').focus();
    return false;
  }
  if(askagree != true){//동의버튼 체크 안 했을 경우 확인
    alert('개인정보 취급 방침에 동의 하셔야 합니다.');
    return false;
  }


  alert('고객님의 소중한 문의내용이 접수되었습니다.');
  location.href = "/index.do";//문의 정상 발송하면 새로고침 용도

}

function imageAni(){//인덱스 아래 갤러리 사진4개 jQuery 애니메이션 효과 주기
  $("#bottomlist1").animate({textIndent:"105%"},4000);//들여쓰기를 점점 늘리는 효과로 사진들이 오른쪽으로 쭉 이동하는거 처럼 보이게함.
  $("#bottomlist1").animate({textIndent:"0%"},4000);//들여쓰기 다시 0%로 점점 줄이는 효과로 사진들이 다시 왼쪽으로 쭉 돌아오는거 처럼 보이게함.
  setTimeout("imageAni()", 10000);//끝나면 곧 바로 다시 애니메이션 시작하지 않고, 조금 여유두고 시작

}

var imgIndex = 2;//인덱스 확인용 변수
function changePotalImg() {//인덱스 메인 사진 변경 함수
  $(".slider").css("transition-duration", "1s");//transition duration이용하여 1초 줘서 css 1초 동안 서서히 변경
  //메인의 움직이는 사진은 2장처럼 보이지만 2장x2인 4장이고 실제로는 가로로 쭉 나열되어 있음(오버플로우 히든 이용)
  $(".slider").css("transform", `translateX(${imgIndex * -1450}px)`);//각 사진공간크기를 1450으로 맞췄기때문에 1450씩 이동시켜서 사진이 바뀌는거 처럼 보이게 함, 실제로 총 4장이기 때문에 왼쪽 오른쪽으로는 삐져 나오고 있지만 오버플로우 히든처리로 숨김
  indexTextInitialize();//메인 사진 변경 할때 글자 애니메이션 효과 초기화 함수 호출
  indexTextAni();//이후 글자 애니메이션 효과주는 함수도 맞춰서 호출
  imgIndex++;
  $("#slideBtn2").prop("checked", true);
  if (imgIndex == 4) {//더 밀게 되면 옆에 이제 사진이 없음, 초기화
    initialPotalImg();//메인 사진 초기화 함수 호출
    indexTextInitialize();//글자 애니메이션 효과 초기화 함수 호출
    indexTextAni();//글자 애니메이션 효과 함수 호출
  }
}

function initialPotalImg() {//인덱스 메인 사진 초기화 함수
  $("#slideBtn1").prop("checked", true);
  setTimeout(function () {
    $(".slider").css("transition-duration", "0s");
    $(".slider").css("transform", "translateX(-1450px)");
  }, 1001);
  imgIndex = 2;//인덱스 확인용 변수 다시 2로 초기화함
  indexTextInitialize();//글자 애니메이션 효과 초기화 함수 호출
}

function potalImgBtn() {//메인 사진 밑에 슬라이드 버튼 누르면 호출 하는 함수
  var btnNum = $(this).attr("value");
  if (btnNum == 1) {//누른게 첫 번째 버튼인 경우
    if (imgIndex == 2) return;//슬라이드 하기 전 기본 상태2면 효과주지 않고 리턴으로 함수 탈출
    if (imgIndex == 3) {//한번 슬라이드 한 상태에서 첫 번째 버튼 누른 경우
      $(".slider").css("transition-duration", "1s");
      $(".slider").css("transform", `translateX(-1450px)`);
      indexTextInitialize();//글자 애니메이션 효과 초기화 함수 호출
      indexTextAni();//글자 애니메이션 효과 함수 호출
      imgIndex = 2;//인덱스 확인용 변수 다시 2로 초기화함
    }
  } else {//누른게 두 번째 버튼인 경우
    if (imgIndex == 3) return;//슬라이드 한번해서 두 번째 사진인 상태인데 오른쪽으로 갈 수 없음. 리턴으로 함수 탈출
    if (imgIndex == 2) {
      $(".slider").css("transition-duration", "1s");
      $(".slider").css("transform", `translateX(-2900px)`);
      indexTextInitialize();//글자 애니메이션 효과 초기화 함수 호출
      indexTextAni();//글자 애니메이션 효과 함수 호출
      imgIndex = 3;
    }
  }
}
