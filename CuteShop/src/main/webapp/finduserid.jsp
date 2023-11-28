<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.kjhuser.service.KjhuserVO" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>아이디 찾기</title>
  <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
  <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
  <style>
    div#privacydiv { width: 99%; height:33%; border: 0px solid red; padding: 5px; margin: 0;}
    div#privacydiv > div#privacytitle { width:100%; height: 9.9%; text-align:center;  background-color: #B9EEFF; line-height: 30px; font-size: 1.1em; font-weight: bold;}
    div#privacydiv > div#privacycontent { width: 99.9%; height: 90%; font-size: 0.9em;}
    div#privacydiv > div#privacycontent > p.privacycontentbold { font-weight: bold;}
  </style>
  
  <script>
  function findCheck(phone){//아이디 찾기 버튼 누르면 호출
		if(phone.length <1) {//폰 안씀 확인
		    alert('핸드폰 번호를 입력해주세요.');
		    document.getElementById('userphone').focus();
		    return false;
		  }
		  
	  $.ajax({
		       url:'/kjhuser/findId.do', //request 보낼 서버의 경로
		       type:'post', // 메소드(get, post, put 등)
		       data:{'userphone': phone}, //보낼 데이터 id=1
		       dataType: "json",
		       success: function(data) {
		           //서버로부터 정상적으로 응답이 왔을 때 실행
		            objData = data;
		           //alert("정상수신 , result = "+data.searchedVO);
		          //alert("id = "+data.searchedVO.id);
		           //alert("userid = "+data.searchedVO.userid);
		           //alert("userpw = "+data.searchedVO.userpw);     
		        alert("가입하신 아이디는 " + data.findVO.userid + " 입니다.");
		           
		       },
		       error: function(err) {
		           //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
		           objErr = err;
		          //alert("오류발생 , error="+err.state());
		          alert("가입하지 않은 휴대폰 번호 입니다.");
		       }
		   });
	}
  </script>
</head>
<body>
  <div id="privacydiv">
    <div id="privacytitle">아이디 찾기</div>
    <div id="privacycontent">
      <p class="privacycontentbold">가입시 입력한 휴대폰 번호</p>
      <form name="findfrm" id="findfrm" class="" target="ABC" action ="/kjhuser/findId.do">
      	<input
                        type="text"
                        class="signininput"
                        id="userphone" 
                        name="userphone"
                      />
        <p>ex) 0101231234</p>
        <button
                        type="button"
                        onclick="findCheck(document.findfrm.userphone.value);"
                        style="
                          width: 20%;
                          height: 30px;
                          font-weight: bold;
                          background-color: #B9EEFF;
                          color: black;
                          cursor: pointer; 
                          border: 0px solid black;
                        "
                      >
                       찾기
         </button>
      </form>
    </div>
  </div>
</body>
</html>