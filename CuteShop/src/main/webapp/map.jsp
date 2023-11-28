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
            <img src="/image/mapmainimage.jpg" alt="이미지" width="100%" />
          </div>
          <div id="centercontentdiv">
            <div id="centerleftmenu">
              <ul>
                <li style="background-color: #3176f9">
                  <a href="map.jsp">오시는길</a>
                </li>
              </ul>
              <ul>
                <div>
                  <img src="/image/call.jpg" alt="이미지" width="100%" />
                </div>
                <div>
                  <p>
                    <span
                      style="color: #1b5e20; font-weight: 600; font-size: 20px"
                      >영진 김정현</span
                    >
                    <br />
                    GC-3A 2101060
                    <br />
                    <strong style="color: #e65100">053-1234-5678</strong>
                  </p>
                </div>
              </ul>
            </div>
            <div id="gallerycontent" style="margin-left: 20px">
              <div><br /></div>
              <div><br /></div>

              <div
                class="gallerycontentunderdiv"
                style="font-weight: bold; font-size: 2em"
              >
                &nbsp;&nbsp;오시는길
              </div>
              <br />
              <hr />
              <br />
              <div><br /></div>
              <div id="googlemapdiv">
                <iframe
                  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3232.097716199762!2d128.6202379161561!3d35.895622380145!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3565e1bb3ae69edd%3A0x8aa4f6b999146d66!2z7JiB7KeE7KCE66y464yA7ZWZ6rWQIOuzte2YhOy6oO2NvOyKpA!5e0!3m2!1sko!2skr!4v1656074721021!5m2!1sko!2skr"
                  width="99%"
                  height="500px"
                  style="border: 0"
                  allowfullscreen=""
                  loading="lazy"
                  referrerpolicy="no-referrer-when-downgrade"
                ></iframe>
              </div>
              <br />
              <div id="mapcontentdiv">
                <p>
                  <i class="fa-solid fa-location-arrow"></i> 대구광역시 북구
                  복현로 35
                </p>
                <p><i class="fa-solid fa-phone"></i> 053-940-5114</p>
                <p>
                  <i class="fa-solid fa-train-subway"></i> 지하철1호선 아양교역
                  1번출구 → 버스환승(836, 323-1) - 약 15분 소요
                </p>
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