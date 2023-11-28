<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.kjhuser.service.KjhuserVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>영진고시원 김정현 김보성 김경진 이원희</title>
    <link rel="stylesheet" href="/css/kjh.css" />
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/kjh.js"></script>
    <script src="/js/mouseani.js"></script>
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
            <a href="/index.jsp"
              ><img src="/image/logo.png" alt="이미지" width="100%"
            /></a>
          </h1>
          <div id="topnav2">
            <ul>
              <li class="topnav2">
                <a href="/greeting.jsp">고시원소개</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/greeting.jsp">고시원소개</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/living.jsp">생활안내</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/living.jsp">생활안내</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/map.jsp">오시는길</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/map.jsp">오시는길</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/estimate.jsp">입실문의</a>
                <div class="topmenu">
                  <ul>
                    <li><a href="/estimate.jsp">입실문의</a></li>
                  </ul>
                </div>
              </li>
              <li class="topnav2">
                <a href="/kjhgallery/KjhgalleryList.do">게시판</a>
                <div class="topmenu">
                  <ul>
                    <!-- <li><a href="/notice.jsp">공지사항</a></li> -->
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
            <p id="indextext1">Welcome to 고시원!</p>
            <p id="indextext2">김정현 김보성 김경진 이원희</p>
            <p id="indextext3">여러분들의 방문을 환영합니다</p>
            <div class="slider">
              <ul class="igms">
                <li class="slide02clone">
                  <img src="/image/indexmainimage2.jpg" />
                </li>
                <li class="slide01">
                  <img src="/image/indexmainimage1.jpg" />
                </li>
                <li class="slide02">
                  <img src="/image/indexmainimage2.jpg" />
                </li>
                <li class="slide01clone">
                  <img src="/image/indexmainimage1.jpg" />
                </li>
              </ul>
            </div>
            <div class="btnwrap">
              <input
                type="radio"
                name="slide"
                id="slideBtn1"
                value="1"
                class="slide indexbtn"
                checked
              />
              <input
                type="radio"
                name="slide"
                id="slideBtn2"
                value="2"
                class="slide indexbtn"
              />
            </div>
          </div>

          <div class="bottomsection">
            <ul class="section1">
              <li id="bottomlist1">
                <div style="">
                  <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12928.390926881291!2d128.622427!3d35.895622!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3565e1bb3ae69edd%3A0x8aa4f6b999146d66!2z7JiB7KeE7KCE66y464yA7ZWZ6rWQIOuzte2YhOy6oO2NvOyKpA!5e0!3m2!1sko!2skr!4v1681797169018!5m2!1sko!2skr" width="720" height="400" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
              </li>

              <style>
                div#cscenterdiv {
                  text-align: center;
                }
                .cscenter {
                  margin: 10px;
                }
              </style>

              <li id="bottomlist2">
                <div id="cscenterdiv">
                  <h2 class="cscenter">
                    <span style="color: #029cda">CUSTOMER</span> 고객센터
                  </h2>
                  <div class="cscenter">
                    <span
                      ><i
                        class="fa-solid fa-headphones"
                        style="font-size: 3em; color: #029cda"
                      ></i
                    ></span>
                  </div>
                  <h1 class="cscenter">
                    <a href="tel:02-1234-5678">02-1234-5678</a>
                  </h1>
                  <div class="cscenter">
                    <p>평일: AM 9:00 ~ PM 6:00 / 공휴일 휴무</p>
                  </div>
                </div> 
              </li>
              
            </ul>
          </div>

          <div class="section">
            <ul class="section1">
              <!-- <li class="article1">
                <div
                  class="boardwrap"
                  style="background-color: #f2af3c; color: white"
                >
                  <div>
                    <span>FACILITIES</span>
                  </div>
                  <div><hr /></div>
                  <div>
                    <img src="/image/indexlistimage1.jpg" alt="" />
                  </div>
                  <div>
                    <p>
                      프리미엄급 쾌적한 방, 개인 샤워실 및 화장실, 개별
                      에어컨/세탁기...
                    </p>
                  </div>
                  <div>
                    <button
                      type="button"
                      style="
                        width: 33%;
                        height: 13%;
                        border: 0px solid black;
                        font-weight: bold;
                      "
                     onclick="location.href='/greeting.jsp'">
                      자세히보기 →
                    </button>
                  </div>
                </div>
              </li> -->
              
              <li class="article1">
                <div class="boardwrap" style="background-color: #31384A; color:white;">
                  <div style="margin-bottom: 35px;">
                    <span><a href="./notice.html" style="color: white;">GALLERY</a></span>
                    
                    <div style="padding-top: 15px;"><hr /></div>
                    
                  </div>
                  
                  <ul class="list_style">
                    <li style="color: white;">
                      <a href="./noticepost.html">
                        <dl style="color: white;">
                          <dt>
                            111공지사항 입니다!!! 큰 기업이 되도록
                            노력하겠습니다
                          </dt>
                          <dd>21.04.05</dd>
                        </dl>
                      </a>
                    </li>
                    
                    <li style="color: white;">
                      <a href="./noticepost.html">
                        <dl style="color: white;">
                          <dt>
                            222공지사항 입니다!!! 큰 기업이 되도록
                            노력하겠습니다
                          </dt>
                          <dd>21.04.05</dd>
                        </dl>
                      </a>
                    </li>
                    
                    <li style="color: white;">
                      <a href="./noticepost.html">
                        <dl style="color: white;">
                          <dt>
                            333공지사항 입니다!!! 큰 기업이 되도록
                            노력하겠습니다
                          </dt>
                          <dd>21.04.05</dd>
                        </dl>
                      </a>
                    </li>
                    
                    <li style="color: white;">
                      <a href="./noticepost.html">
                        <dl style="color: white;">
                          <dt>
                            444공지사항 입니다!!! 큰 기업이 되도록
                            노력하겠습니다
                          </dt>
                          <dd>21.04.05</dd>
                        </dl>
                      </a>
                    </li>
                    
                  </ul>
                </div>
              </li>
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              

              <li class="article1">
                <div
                  class="boardwrap"
                  style="background-color: #84af3c; color: white"
                >
                  <div>
                    <span>LIVING</span>
                  </div>
                  <div><hr /></div>
                  <div>
                    <img src="/image/indexlistimage2.jpg" alt="" />
                  </div>
                  <div>
                    <p>
                      안전한 생활, 쾌적한 시설, 무선인터넷... 믿고 쓰는 영진
                      고시원
                    </p>
                  </div>
                  <div>
                    <button
                      type="button"
                      style="
                        width: 33%;
                        height: 13%;
                        border: 0px solid black;
                        font-weight: bold;
                      "
                     onclick="location.href='/living.jsp'">
                      자세히보기 →
                    </button>
                  </div>
                </div>
              </li>

              <li class="article1">
                <div
                  class="boardwrap"
                  style="background-color: #aaaaaa; color: white"
                >
                  <div>
                    <span>SURROUNDING</span>
                  </div>
                  <div><hr /></div>
                  <div>
                    <img src="/image/indexlistimage3.jpg" alt="" />
                  </div>
                  <div>
                    <p>
                      편리한 교통, 인근 각종 편의시설, 공원등이 위치하고 있어
                      편리한 생활...
                    </p>
                  </div>
                  <div>
                    <button
                      type="button"
                      style="
                        width: 33%;
                        height: 13%;
                        border: 0px solid black;
                        font-weight: bold;
                      "
                     onclick="location.href='/map.jsp'">
                      자세히보기 →
                    </button>
                  </div>
                </div>
              </li>
            </ul>
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
                  <a
                    href='javascript:window.open("/privacy.jsp","name", "width=600px,height=380px,left=500px,top=450px");'
                    >개인정보취급방침</a
                  >
                </li>
                <li><a href="/estimate.jsp">입실문의</a></li>
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