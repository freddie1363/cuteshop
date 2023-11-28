//GC-3A 2101060 김정현
function signupcheck(){//회원가입 버튼 누르면 호출
  var id = document.getElementById('userid').value;//아이디
  var pw = document.getElementById('userpw').value;//비번
  var phone = document.getElementById('userphone').value;//폰번

  if(id.length <1) {//아이디 안씀 확인
    alert('아이디를 입력해주세요.');
    document.getElementById('userid').focus();
    return false;
  }
	
	if(pw.length <1) {//비번 안씀 확인
    alert('비번을 입력해주세요.');
    document.getElementById('userpw').focus();
    return false;
  }

  if(phone.length <1) {//폰번 안씀 확인
    alert('전화번호를 입력해주세요.');
    document.getElementById('userphone').focus();
    return false;
  }

  document.memberjoinfrm.submit();
}

function iddoublecheck(id){//아이디 중복체크 버튼 누르면 호출
	if(id.length <1) {//아이디 안씀 확인
	    alert('아이디를 입력해주세요.');
	    document.getElementById('userid').focus();
	    return false;
	  }
	  
  $.ajax({
	       url:'/kjhuser/idDoubleCheck.do', //request 보낼 서버의 경로
	       type:'post', // 메소드(get, post, put 등)
	       data:{'userid': id}, //보낼 데이터 id=1
	       dataType: "json",
	       success: function(data) {
	           //서버로부터 정상적으로 응답이 왔을 때 실행
	            objData = data;
	           //alert("정상수신 , result = "+data.searchedVO);
	          //alert("id = "+data.searchedVO.id);
	           //alert("userid = "+data.searchedVO.userid);
	           //alert("userpw = "+data.searchedVO.userpw);     
	        alert("이미 사용중인 아이디 입니다.");
	           
	       },
	       error: function(err) {
	           //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
	           objErr = err;
	          //alert("오류발생 , error="+err.state());
	          alert("사용가능한 아이디 입니다.");
	       }
	   });
}


