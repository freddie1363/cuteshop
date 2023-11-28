<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.kjhuser.service.KjhuserVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>영진 GC-3A 2101060 김정현</title>
    <link rel="stylesheet" href="/css/kjh.css" />
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/signin.js"></script>
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
  </head>
  <body>
    <div id="viewport">
      <div id="header">
        <div id="nav">
          <div id="topnav">
<%
	KjhuserVO userVO = null;
	if(session.getAttribute("loginedUserVO") != null)
		userVO = (KjhuserVO)session.getAttribute("loginedUserVO");
	if(userVO==null){
%>
            <a href="/signin.jsp"><i class="fa-solid fa-user"></i> 로그인</a>
            <a href="/signup.jsp"
              ><i class="fa-solid fa-user-plus"></i> 회원가입</a
            >
<% 
	} else{
%>
			<a href="/kjhuser/userLogout.do"><i class="fa-solid fa-user"></i> 로그아웃</a>
            <a href="/userinfo.jsp"
              ><i class="fa-solid fa-user-plus"></i> 정보수정</a
            >
<%
	}
%>
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
      <div id="mainwrap">
        <div class="main">
          <div class="banner">
            <p id="severaltext1">영진전문대 컴퓨터정보계열</p>
            <p id="severaltext2">GC-3A 2101060 김정현</p>
            <img src="/image/signmainimage.jpg" alt="이미지" width="100%" />
          </div>
          <div id="centercontentdiv">
            <div id="centerleftmenu">
              <ul>
                <li style="background-color: #3176f9">
                  <a href="/signin.jsp">로그인</a>
                </li>
                <li><a href="/signup.jsp">회원가입</a></li>
              </ul>
            </div>
            <div id="centercontent">
              <div style="font-weight: bold; font-size: 2em; height: 34px">
                &nbsp;&nbsp;로그인
              </div>
              <br />
              <div style="height: 40px; width: 81%"><hr /></div>
              <br />
              <div
                style="
                  border: 1px solid gray;
                  height: 600px;
                  margin: 15px;
                  width: 80%;
                "
              >
                <div
                  style="
                    margin: 20 40 20 20px;
                    height: 500px;
                    padding: 50px;
                    width: 80%;
                  "
                >
                  <div style="font-weight: bold; font-size: 1.5em">LOGIN</div>
                  <div><hr /></div>
                  <br />
                  <div
                    style="
                      text-align: center;
                      margin: 0;
                      padding: 0;
                      height: 380px;
                    "
                  >
                    <form action ="/kjhuser/checkUserLogin.do" id="memberloginfrm" name="memberloginfrm" target="ABC">
                      <br />
                      <div>
                        <input
                          id="signinid"
                          class="signininput"
                          type="text"
                          placeholder="    아이디" 
                          name="userid"
                        />
                      </div>
                      <div>
                        <input
                          id="signinpw"
                          class="signininput"
                          type="password"
                          placeholder="    비밀번호" 
                          name="userpw"
                        />
                      </div>
                      <div>
                        <button
                          type="button"
                          class="signininput"
                          onclick="signincheck();"
                          style="
                            background-color: #212020;
                            color: white;
                            cursor: pointer;
                          "
                        >
                          로그인
                        </button>
                      </div>
                      <div class="signinunder">
                        <input type="checkbox" />아이디 저장
                        <input type="checkbox" />보안접속
                      </div>
                      <div class="signinunder">
                        <a href='javascript:window.open("/finduserid.jsp","name", "width=600px,height=380px,left=500px,top=450px");'>아이디 찾기</a
                        >
                      </div>
                      <div class="signinunder">
                        <a href='javascript:window.open("/finduserpw.jsp","name", "width=600px,height=380px,left=500px,top=450px");'>비밀번호 찾기</a
                        >
                      </div>
                      <div class="signinunder">
                        <a href="/signup.jsp">회원가입</a>
                      </div>
                    </form>
                  </div>
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