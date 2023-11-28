<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.kjhuser.service.KjhuserVO" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>영진 GC-3A 2101060 김정현</title>
    <link rel="stylesheet" href="/css/kjh.css" />
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
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
            <img
              src="./image/businessmainimage.jpg"
              alt="이미지"
              width="100%"
            />
          </div>
          <div id="severalhtmldiv">
            <div id="severalhtmldivcontent">
              <div><br /></div>
              <div id="severalhtmltitle">
                사업소개 <span>함께 걷고, 나누는 기업</span><br /><br />
                <hr />
              </div>
              <div><br /></div>
              <div class="severalhtmluldiv">
                <img
                  src="./image/businessimage1.jpg"
                  alt=""
                  width="99.9%"
                  height="99.9%"
                />
              </div>
              <br />
              <div
                class="severalhtmluldiv"
                style="border: 0px solid red; height: 40%"
              >
                <p>
                  <b
                    >영진김정현은 세계에서 가장 뛰어난 디자인과 성능을 제공합니다.
                    항상 고객님께 최고의 만족감을 드릴 수 있도록 도와
                    드리겠습니다.</b
                  >
                </p>
                <br />
                <p>
                  또한 ㈜정현물류는 업계 최고의 노하우와 전문인력으로 포장에서
                  운송, 보관, 통관, 배달 등의 TOTAL SERVICE를 제공하고 있습니다.
                </p>
                <br />
                <p><b>DOOR TO DOOR</b></p>
                <br />
                <p>
                  현재 거주하고 계신 자택에서 부터 해외 자택의 지정장소까지
                  운송해 드리는 서비스 입니다.
                </p>
                <p>
                  포장에서 부터 선적, 운송, 배달 등 모든 서비스가 포함된
                  조건이며, 큰 물건은 포장 제거 후 원하시는 위치에 배치해
                  드립니다!
                </p>
                <p>
                  해외이사 고객의 90% 이상이 DOOR TO DOOR 서비스를 이용하십니다.
                </p>
                <br />
                <p><b>DOOR TO PORT</b></p>
                <br />
                <p>
                  현재 거주하고 계신 자택에서 부터 도착지의 세관까지 운송해
                  드리는 서비스 입니다.
                </p>
                <p>
                  포장 후 도착지 항구까지만 배달해 드리면, 그 이후부터는
                  고객님께서 직업 통관부터 운송까지 진행하시는 조건이므로,현지
                  세관에서 발생하는 통관비, 하역료, 취급료등은 고객 부담입니다.
                </p>
                <p>
                  통관 후 현지 자택까지의 내륙운송비와 현지 인력비용이 절감되는
                  실속 있는 해외이사 서비스 상품
                </p>
              </div>
              <br />
            </div>
          </div>
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
                  <a href= 'javascript:window.open("/privacy.jsp","name", "width=600px,height=380px,left=500px,top=450px");'>개인정보취급방침</a>
                </li>
                <li><a href="/estimate.jsp">후원하기</a></li>
              </ul>
              <ul style="float: right">
                <li style="border: 0px solid white">
                  <a href="https://facebook.com" target="_blank"><i class="fa-brands fa-facebook"></i></a>
                </li>
                <li style="border: 0px solid white">
                  <a href="https://twitter.com" target="_blank"><i class="fa-brands fa-twitter"></i></a>
                </li>
                <li style="border: 0px solid white">
                  <a href="https://instagram.com" target="_blank"><i class="fa-brands fa-instagram"></i></a>
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
