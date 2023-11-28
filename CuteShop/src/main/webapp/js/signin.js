//GC-3A 2101060 김정현
function signincheck(){//로그인 버튼 누르면 호출
  var id = document.getElementById('signinid').value;//아이디
  var pw = document.getElementById('signinpw').value;//비번

  if(id.length <1) {//아이디 썼는지 확인
    alert('아이디를 입력해주세요.');
    document.getElementById('signinid').focus();
    return false;
  }

  if(pw.length <1) {//비번 썼는지 확인
    alert('비밀번호 입력해주세요.');
    document.getElementById('signinpw').focus();
    return false;
  }


  document.memberloginfrm.submit();
}
