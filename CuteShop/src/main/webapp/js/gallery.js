//GC-3A 2101060 김정현
var issearchboxclicked = 1;//검색박스 1 안보이는 기본 hidden 상태

function searchboxclicked() {// 갤러리에서 검색 버튼 클릭하면 호출
  if (issearchboxclicked == 0) {//보일때 누르면 다시 안보이게 하고 스위치용 변수 1로 변경
    $('#galleryhiddendiv').css("display", "none");
    issearchboxclicked = 1;
  } else {//안 보일때 누르면 보이게 하고 스위치용 변수 0으로 변경
    $('#galleryhiddendiv').css("display", "block");
    issearchboxclicked = 0;
  }
}
