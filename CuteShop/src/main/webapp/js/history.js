//GC-2A 2101060 김정현
var boxnumberclicked1 = 1;//연혁1버튼 기본1이 보이고 있는 상태
var boxnumberclicked2 = 1;//연혁2버튼 기본1이 안 보이는 히든 상태
var boxnumberclicked3 = 1;//연혁3버튼 기본1이 안 보이는 히든 상태

function historyboxclicked1() {//연혁1 버튼
  if (boxnumberclicked1 == 0) {//안 보이는 상태0에서 클릭하면 -> 보이게 하고 스위치용 변수 1로 변경
    $('.historyclickboxcontent[boxnumber="1"]').css("display", "block");
    $('li[boxnumber="1"]').css("border", "1px solid lightgray");
    $('i[boxnumber="1"]').attr("class", "fa-solid fa-circle-minus");
    boxnumberclicked1 = 1;
  } else {//보이는 상태1에서 클릭하면 -> 안 보이게 하고 스위치용 변수 0으로 변경
    $('.historyclickboxcontent[boxnumber="1"]').css("display", "none");
    $('li[boxnumber="1"]').css("border", "0px solid lightgray");
    $('i[boxnumber="1"]').attr("class", "fa-solid fa-circle-plus");
    boxnumberclicked1 = 0;
  }
}

function historyboxclicked2() {//연혁 두 번째 버튼
  if (boxnumberclicked2 == 0) {//보이는 상태에서 클릭하면 -> 안 보이게 하고 스위치용 변수 1로 변경
    $('.historyclickboxcontent[boxnumber="2"]').css("display", "none");
    $('li[boxnumber="2"]').css("border", "0px solid lightgray");
    $('i[boxnumber="2"]').attr("class", "fa-solid fa-circle-plus");
    boxnumberclicked2 = 1;
  } else {//안 보이는 상태1에서 클릭하면 -> 보이게 하고 스위치용 변수 0으로 변경
    $('.historyclickboxcontent[boxnumber="2"]').css("display", "block");
    $('li[boxnumber="2"]').css("border", "1px solid lightgray");
    $('i[boxnumber="2"]').attr("class", "fa-solid fa-circle-minus");
    boxnumberclicked2 = 0;
  }
}

function historyboxclicked3() {//연혁 세 번째 버튼
  if (boxnumberclicked3 == 0) {//보이는 상태에서 클릭하면 -> 안 보이게 하고 스위치용 변수 1로 변경
    $('.historyclickboxcontent[boxnumber="3"]').css("display", "none");
    $('li[boxnumber="3"]').css("border", "0px solid lightgray");
    $('i[boxnumber="3"]').attr("class", "fa-solid fa-circle-plus");
    boxnumberclicked3 = 1;
  } else {//안 보이는 상태1에서 클릭하면 -> 보이게 하고 스위치용 변수 0으로 변경
    $('.historyclickboxcontent[boxnumber="3"]').css("display", "block");
    $('li[boxnumber="3"]').css("border", "1px solid lightgray");
    $('i[boxnumber="3"]').attr("class", "fa-solid fa-circle-minus");
    boxnumberclicked3 = 0;
  }
}
