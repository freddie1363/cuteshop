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
    <script type="text/javascript" src="/js/history.js"></script>
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
              src="./image/historymainimage.jpg"
              alt="이미지"
              width="100%"
            />
          </div>
          <div id="severalhtmldiv">
            <div id="severalhtmldivcontent">
              <div><br /></div>
              <div id="severalhtmltitle">
                연혁 <span>함께 걷고, 나누는 기업</span><br /><br />
                <hr />
              </div>
              <div><br /></div>
              <!-- <div class="severalhtmluldiv">
          <img src="./image/businessimage1.jpg" alt="" width="99.9%" height="99.9%">
        </div><br> -->
              <div class="historyhtmldiv">
                <div class="historyclickbox">
                  <ul>
                    <li class="historybox" id="historybox1" boxnumber="1">
                      <p
                        class="historyclickboxtitle"
                        onclick="historyboxclicked1();"
                      >
                        <b>2023 INNOVATION</b>
                        <i class="fa-solid fa-circle-minus" boxnumber="1"></i>
                      </p>
                      <p class="historyclickboxcontent" boxnumber="1">
                        <b>2023.11</b> - 영진전문대학교
                      </p>
                      <p class="historyclickboxcontent" boxnumber="1">
                        <b>2023.9</b> - 컴퓨터정보계열
                      </p>
                      <p class="historyclickboxcontent" boxnumber="1">
                        <b>2023.5</b> - GC-3A
                      </p>
                      <p class="historyclickboxcontent" boxnumber="1">
                        <b>2023.3</b> - 2101060 김정현
                      </p>
                      <p class="historyclickboxcontent" boxnumber="1">
                        <b style="color: blue"
                          >2023.1 - 반갑습니다 반갑습니다
                        </b>
                      </p>
                    </li>
                    <li>
                      <img
                        src="./image/historyboximage1.jpg"
                        alt=""
                        width="99%"
                        height="99%"
                      />
                    </li>
                  </ul>
                </div>
              </div>
              <br />

              <div class="historyhtmldiv">
                <div class="historyclickbox">
                  <ul>
                    <li class="historybox" id="historybox2" boxnumber="2">
                      <p
                        class="historyclickboxtitle"
                        onclick="historyboxclicked2();"
                      >
                        <b>2022 CREATION</b>
                        <i class="fa-solid fa-circle-plus" boxnumber="2"></i>
                      </p>
                      <p class="historyclickboxcontent" boxnumber="2">
                        <b>2022.11</b> - 모바일 사업 전담 자회사 '더디자인모바일' 설립
                      </p>
                      <p class="historyclickboxcontent" boxnumber="2">
                        <b>2022.9</b> - 더디자인 문화재단 설립
                      </p>
                      <p class="historyclickboxcontent" boxnumber="2">
                        <b>2022.5</b> - 창립 1주년 맞아 기업로고(CI) 변경
                      </p>
                      <p class="historyclickboxcontent" boxnumber="2">
                        <b>2022.3</b> - 코스닥 업종 시가총액 1위 기업 등극
                      </p>
                      <p class="historyclickboxcontent" boxnumber="2">
                        <b style="color: blue"
                          >주식회사 영진GC-3A 설립(대표 김정현)</b
                        >
                      </p>
                    </li>
                    <li>
                      <img
                        src="./image/historyboximage2.jpg"
                        alt=""
                        width="99%"
                        height="99%"
                      />
                    </li>
                  </ul>
                </div>
              </div>
              <br />

              <div class="historyhtmldiv">
                <div class="historyclickbox">
                  <ul>
                    <li class="historybox" id="historybox3" boxnumber="3">
                      <p
                        class="historyclickboxtitle"
                        onclick="historyboxclicked3();"
                      >
                        <b>2021 ADVANCE</b>
                        <i class="fa-solid fa-circle-plus" boxnumber="3"></i>
                      </p>
                      <p class="historyclickboxcontent" boxnumber="3">
                        <b>2021.12</b> - 2021년 12월에 있었던 일
                      </p>
                      <p class="historyclickboxcontent" boxnumber="3">
                        <b>2021.10</b> - 2021년 10월에 있었던 일
                      </p>
                      <p class="historyclickboxcontent" boxnumber="3">
                        <b>2021.6</b> - 2021년 6월에 있었던 일
                      </p>
                      <p class="historyclickboxcontent" boxnumber="3">
                        <b>2021.4</b> - 2021년 4월에 있었던 일
                      </p>
                      <p class="historyclickboxcontent" boxnumber="3">
                        <b style="color: blue">2021.2 - 가나다라마바사 </b>
                      </p>
                    </li>
                    <li>
                      <img
                        src="./image/historyboximage3.jpg"
                        alt=""
                        width="99%"
                        height="99%"
                      />
                    </li>
                  </ul>
                </div>
              </div>
              <br />

              <!-- <div class="historyhtmldiv">
          <div class="historyclickbox">
            <div class="historyclickboxtitle" onclick="historyboxclicked2();"><B>2010 Establishment</B> <i class="fa-solid fa-arrow-down"></i></div>
            <div class="historyclickboxcontent2" boxnumber="2"><p><B>2010.11</B> - JH SOFT로 회사 이름 변경 </p></div>
            <div class="historyclickboxcontent2" boxnumber="2"><p><B>2010.9</B> - 2010년 9월에 있었던 일 </p></div>
            <div class="historyclickboxcontent2" boxnumber="2"><p><B>2010.5</B> - 2010년 5월에 있었던 일 </p></div>
            <div class="historyclickboxcontent2" boxnumber="2"><p><B>2010.3</B> - 2010년 3월에 있었던 일 </p></div>
            <div class="historyclickboxcontent2" boxnumber="2"><p><B>2010.1</B> - 정현소프트 설립 </p></div>
          </div>
        </div><br>

        <div class="historyhtmldiv">
          <div class="historyclickbox">
            <div class="historyclickboxtitle" onclick="historyboxclicked3();"><B>1994 Born</B> <i class="fa-solid fa-arrow-down"></i></div>
            <div class="historyclickboxcontent2" boxnumber="3"><p><B>1994.10</B> - 1994년 10월에 있었던 일 </p></div>
            <div class="historyclickboxcontent2" boxnumber="3"><p><B>1994.8</B> - 1994년 8월에 있었던 일 </p></div>
            <div class="historyclickboxcontent2" boxnumber="3"><p><B>1994.6</B> - 1994년 6월에 있었던 일 </p></div>
            <div class="historyclickboxcontent2" boxnumber="3"><p><B>1994.4</B> - 1994년 4월에 있었던 일 </p></div>
            <div class="historyclickboxcontent2" boxnumber="3"><p><B>1994.2</B> - 김정현 태어남 </p></div>
          </div>
        </div><br> -->
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
