<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.kjhuser.service.KjhuserVO" %>
<%@ page import="egovframework.kjhgallery.service.KjhgalleryVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>영진 GC-3A 2101060 김정현</title>
    <link rel="stylesheet" href="/css/kjh.css" />
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/gallery.js"></script>
    <script type="text/javascript" src="/js/textani.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
    />
    <script
      src="https://kit.fontawesome.com/bbfc782959.js"
      crossorigin="anonymous"
    ></script>

<script>
function loginPlz() {
	alert("비회원은 추천 기능을 이용할 수 없습니다. 로그인을 해주세요.");
}

function likeClick(id) {//개추 누르면 호출
	
  $.ajax({
	       url:'/kjhgallerylikes/selectKjhgallerylikes.do', //request 보낼 서버의 경로
	       type:'post', // 메소드(get, post, put 등)
	       data:{'gno': id}, //보낼 데이터 id=1
	       dataType: "json",
	       success: function(data) {
	           //서버로부터 정상적으로 응답이 왔을 때 실행
	            objData = data;
	           //alert("정상수신 , result = "+data.searchedVO);
	          //alert("id = "+data.searchedVO.id);
	           //alert("userid = "+data.searchedVO.userid);
	           //alert("userpw = "+data.searchedVO.userpw);     
	        $('#likesDiv').text(data.searchedVO.likes);
	        
	       },
	       error: function(err) {
	           //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
	           objErr = err;
	          //alert("오류발생 , error="+err.state());
	          alert("에러뜸 ㅅㄱ");
	       }
	   });
}
function commentfrmCheck() {
	document.commentfrm.submit();
	
}
</script>

  </head>
  <body>
    <div id="viewport">
      <div id="header">
        <div id="nav">
          <div id="topnav">

<c:if test="${empty sessionScope.loginedUserVO }">
            <a href="/signin.jsp"><i class="fa-solid fa-user"></i> 로그인</a>
            <a href="/signup.jsp"
              ><i class="fa-solid fa-user-plus"></i> 회원가입</a
            >
</c:if>

<c:if test="${!empty sessionScope.loginedUserVO }">
			<a href="/kjhuser/userLogout.do"><i class="fa-solid fa-user"></i> 로그아웃</a>
            <a href="/userinfo.jsp"
              ><i class="fa-solid fa-user-plus"></i> 정보수정</a
            >
</c:if>


          </div>
        </div>
      </div>
      <div id="header2">
        <div id="logowrap">
          <h1>
            <a href="/index.do"
              ><img src="/image/logo.png" alt="이미지" width="100%"
            /></a>
          </h1>
          <div id="topnav2">
            <ul>
              <li class="topnav2">
                <a href="/greeting.jsp">회사소개</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/greeting.jsp">인사말</a></li>
                    <li><a href="/history.jsp">연혁</a></li>
                    <li><a href="/map.jsp">오시는길</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/business.jsp">사업소개</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/business.jsp">사업소개</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/product.jsp">제품소개</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/product.jsp">제품소개</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/estimate.jsp">후원하기</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/estimate.jsp">후원하기</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/kjhgallery/KjhgalleryList.do">게시판</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/kjhgallery/KjhgalleryList.do">갤러리</a></li>
                    
                  </ul>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div id="mainwrap" style="height: 2000px;">
        <div class="main">
          <div class="banner">
            <p id="severaltext1">영진전문대 컴퓨터정보계열</p>
            <p id="severaltext2">GC-3A 2101060 김정현</p>
            <img src="/image/gallerymainimage.jpg" alt="이미지" width="100%" />
          </div>
          <div id="centercontentdiv">
            <div id="centerleftmenu">
              <ul>
                <!-- <li><a href="notice.jsp">공지사항</a></li> -->
                <li style="background-color: #3176f9">
                  <a href="/kjhgallery/KjhgalleryList.do">갤러리</a>
                </li>
              </ul>
              <ul>
                <div>
                  <img src="/image/call.jpg" alt="이미지" width="100%">
                </div>
                <div>
                  <p>
                    <span style=
                    "color: #1b5e20;
                    font-weight: 600;
                    font-size: 20px;">영진 김정현</span>
                    <br>
                    GC-3A 2101060
                    <br>
                    <strong style="    color: #e65100;">053-1234-5678</strong>
                  </p>
                </div>
              </ul>
            </div>
            <div id="gallerycontent" style="margin-left: 20px;">
              <div><br /></div>
              <div><br /></div>

              <div
                class="gallerycontentunderdiv"
                style="font-weight: bold; font-size: 2em"
              >
                &nbsp;&nbsp;갤러리
              </div>
              <br />
              <div class="gallerycontentunderdiv"></div>
              <div class="gallerycontentunderdiv"><hr /></div>
              <div id="gallerybtndiv">
                <!-- <button onclick="searchboxclicked();">검색</button>
                <button onclick="nextSemester();">글작성</button> -->
              </div>
              <div id="galleryhiddendiv">
                <input
                  type="text"
                  style="
                    width: 90%;
                    height: 99.9%;
                    font-size: 15px;
                    border: 1px solid black;
                  "
                />
                <label onclick="nextSemester();"
                  ><i class="fa-solid fa-magnifying-glass"></i
                ></label>
              </div>
              <hr />
              <div id="gallerypostdiv">

<c:if test="${!empty sessionScope.selectedVO }">
         <div id="posttitle">${selectedVO.subject }</div>
                <div id="postdate">${selectedVO.regdate }&nbsp;&nbsp;| ${selectedVO.writer }&nbsp;&nbsp;| 조회: ${selectedVO.views} </div>
                <div class="posthrdiv"><hr></div>
                <div id="postcontent">
                  <img src="/${selectedVO.appendix }" alt="">
                  <p>${selectedVO.content }</p>
                </div>
                
                <div id="postlikesdiv">
                	<c:if test="${!empty sessionScope.loginedUserVO }">
                		<i class="fa-solid fa-star" onclick="likeClick(${selectedVO.id });"></i>
                	</c:if>
                	<c:if test="${empty sessionScope.loginedUserVO }">
                		<i class="fa-solid fa-star" onclick="loginPlz();"></i>
                	</c:if>
	                  
	                  <br>
	                  <span id="likesDiv" style="font-size:2em;"> ${selectedVO.likes }</span>               
	            </div>
</c:if>                
                
                
                
                <div id="postcontentbtn">
                  <button onclick="window.open('https://instagram.com')"><i class="fa-brands fa-instagram-square"></i></button>
                  <button onclick="window.open('https://twitter.com')"><i class="fa-brands fa-twitter-square"></i></button>
                  <button onclick="window.open('https://facebook.com')"><i class="fa-brands fa-facebook-square"></i></button>
                </div>
                <div class="posthrdiv"><hr></div>
                <div id="postunderbtn">
                	<button onclick="location.href='/kjhgallery/KjhgalleryList.do'">목록</button>


<c:if test="${!empty sessionScope.selectedVO && !empty sessionScope.loginedUserVO}">
	<c:if test="${selectedVO.writer == loginedUserVO.userid}">
		<button onclick="location.href='/modifyform.jsp'">수정</button>
					<button onclick="location.href='/kjhgallery/deleteKjhgallery.do'">삭제</button>
	</c:if>		
					

</c:if>            	
                </div>
              </div>
              <br />
              <div class="gallerycontentunderdiv" style="margin-top: 60px;">
              	<div><B> 댓글</B></div>
                <table style="marign: 0 auto; text-align:center; width: 100%;">
	  				<tr>
					    <th style="border: 1px solid black; width: 15%;">작성자 </th>
					    <th style="border: 1px solid black; width: 65%;">내용</th>
					    <th style="border: 1px solid black; width: 20%;">작성일</th>  			
	  				</tr>
	  				<c:forEach var="comment" items="${commentList}" varStatus="status">
	  				<tr>
	  					<td style="border: 1px solid black; width: 15%;">${comment.writer } </td>
					    <td style="border: 1px solid black; width: 65%;">${comment.content} </td>
					    <td style="border: 1px solid black; width: 20%;">${comment.regdate} 
					    <c:if test="${comment.writer == loginedUserVO.userid}">
					    <button type="button" onclick="location.href='/kjhcomment/deleteKjhcomment.do?cno=${comment.cno}'">삭제</button>
					    </c:if>
					    </td>
	  				</tr>	  				
					</c:forEach>			
  				</table>
  				<div style="margin-top: 20px;">
  					<c:if test="${!empty sessionScope.selectedVO && !empty sessionScope.loginedUserVO}">
	                	<form name="commentfrm" id="commentfrm" class="" target="ABC" action ="/kjhcomment/addKjhcomment.do">
	                		<input type="hidden" value="${selectedVO.id }" name="id"/>
	                		<input type="hidden" value="${loginedUserVO.userid }" name="writer"/>
	                		<input type="text" value="" style="width:80%;" name="content"/> <button type="button" style="width:19%;" onclick="commentfrmCheck();">댓글등록</button>
	                	</form>
                	</c:if>
                </div>
              </div>
            </div>
            
            
            	
            
            
            
            
          </div>
          <!--end of contentdiv -->
        </div>
      </div>
      
      <div class="footer">
        <div class="footer_width">
          <div class="footerlogo">
            <img src="/image/logo.png" alt="" width="70%" />
          </div>
          <div class="footer_content">
            <div class="foot_nav" style="overflow: auto">
              <ul>
                <li><a href="/greeting.jsp">회사소개</a></li>
                <li>
                  <a
                    href='javascript:window.open("/privacy.jsp","name", "width=600px,height=380px,left=500px,top=450px");'
                    >개인정보취급방침</a
                  >
                </li>
                <li><a href="/estimate.jsp">후원하기</a></li>
              </ul>
              <ul style="float: right">
                <li style="border: 0px solid white">
                  <a href="https://facebook.com" target="_blank"
                    ><i class="fa-brands fa-facebook"></i
                  ></a>
                </li>
                <li style="border: 0px solid white">
                  <a href="https://twitter.com" target="_blank"
                    ><i class="fa-brands fa-twitter"></i
                  ></a>
                </li>
                <li style="border: 0px solid white">
                  <a href="https://instagram.com" target="_blank"
                    ><i class="fa-brands fa-instagram"></i
                  ></a>
                </li>
              </ul>
            </div>
            <div>
              <br />
              <p>
                상호 : 대한민국 대표자 : 김정현 주소 : 대구광역시 북구 영진로
              </p>
              <p>
                사업자 등록번호 : 123-12-12345 TEL. 02-1234-5678 FAX. 0212345678
                EMAIL. kjh@kjh.co.kr 통신판매 신고번호 :
              </p>
              <p>
                Copyright(c) 대한민국. All Rights Reserved.
                <i class="fa-solid fa-copyright"></i>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>