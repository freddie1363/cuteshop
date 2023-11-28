<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.kjhuser.service.KjhuserVO" %>
<%@ page import="egovframework.kjhgallery.service.KjhgalleryVO" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>영진 GC-3A 2101060 김정현</title>
    <link rel="stylesheet" href="/css/kjh2.css" />
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/kjh2.js"></script>
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
            <p id="indextext1">영진전문대학교</p>
            <p id="indextext2">컴퓨터정보계열</p>
            <p id="indextext3">GC-3A 2101060 김정현</p>
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
          <div class="section">
            <ul class="section1">
              <li class="article1">
                <div class="boardwrap" style="background-color: #31384A; color:white;">
                  <div>
                    <span><a href="/kjhgallery/KjhgalleryList.do" style="color: white;">NOTICE 공지사항</a></span>
                    <a href="/kjhgallery/KjhgalleryList.do"
                      ><i class="fa-solid fa-magnifying-glass" style="color: white;"></i
                    ></a>
                  </div>
                  
                  <ul class="list_style">
                  	<c:forEach var="result" items="${resultList}" varStatus="status">
	 				
                    <li style="color: white;">
                      <a href="/kjhgallery/selectGallery.do?id=${result.id}">
                        <dl style="color: white;">
                          <dt>
                            ${result.subject}
                          </dt>
                          <dd>${result.regdate}</dd>
                        </dl>
                      </a>
                    </li>
                    
                    </c:forEach>
	<div class="paging" style="font-size:1.3em;">
  		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/>
	</div>
 
<script type="text/javascript">
/* 페이징과 글 목록 조회  */
var currentPageNo = ${pageNo};
 
function linkPage(pageNo){
    location.href = "/index.do?pageNo=" + pageNo;
}
</script>      
                  </ul>
                  
                </div>
              </li>




<li class="article1">
                <div class="boardwrap">
                  <div>
                    <span><a href="/business.jsp">BUSINESS 사업소개</a></span>
                    <a href="/business.jsp"
                      ><i class="fa-solid fa-magnifying-glass"></i
                    ></a>
                  </div>
                  <ul>
                    <li style="text-align: center; list-style: none">
                      <a href="">
                        <dl>
                          <dt style="border: none"></dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/business.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              font-size: 1em;
                              margin-left: 50px;
                            "
                          >
                            독보적인 기술인 풍부한 경험, 최고
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/business.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              font-size: 1em;
                              margin-left: 50px;
                            "
                          >
                          의 친환경 테크놀로지 기술을 선도
                         
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/business.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              font-size: 1em;
                              margin-left: 50px;
                            "
                          >
                            합니다.
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/business.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              color: yellowgreen;
                              margin-left: 50px;
                            "
                          ><br>
                            <button type="button" style="width:40%; height:15%; background-color: #00468C; color:white; font-weight: bold; ">바로가기</button>
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                  </ul>
                </div>
              </li>



              <li>
                <div class="boardwrap" style="background-color: #5A8EC8;">
                  <div>
                    <span><a href="/estimate.jsp" style="color:white;">CS CENTER 고객센터</a></span>
                    <a href="/estimate.jsp"
                      ><i class="fa-solid fa-magnifying-glass" style="color: white;"></i
                    ></a>
                  </div>
                  <ul>
                    <li style="text-align: center; list-style: none">
                      <a href="">
                        <dl>
                          <dt style="border: none"></dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/estimate.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              font-size: 2em;
                              margin-left: 50px;
                            "
                          >
                            02-1234-5678
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/estimate.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              font-size: 1.5em;
                              font-weight: bold;
                              color: white;
                              margin-left: 50px;
                            "
                          >
                            FAX. 02-3333-3333
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/estimate.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              color: white;
                              margin-left: 50px;
                            "
                          >
                            평일: AM 9:00 ~ PM 6:00
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                    <li style="text-align: center; list-style: none">
                      <a href="/estimate.jsp">
                        <dl>
                          <dt
                            style="
                              border: none;
                              color: white;
                              margin-left: 50px;
                            "
                          >
                            주말 / 공휴일 휴무
                          </dt>
                          <dd></dd>
                        </dl>
                      </a>
                    </li>
                  </ul>
                </div>
              </li>
            </ul>
          </div>

          <div class="bottomsection">
            <ul class="section1">
              <li id="bottomlist1">
                <img id="indexgallimg1" src="/image/galleryimage1.jpg" alt="" onclick="location.href='/kjhgallery/KjhgalleryList.do'"/>
                <img id="indexgallimg2" src="/image/galleryimage2.jpg" alt="" onclick="location.href='/kjhgallery/KjhgalleryList.do'"/>
                <img id="indexgallimg3" src="/image/galleryimage3.jpg" alt="" onclick="location.href='/kjhgallery/KjhgalleryList.do'"/>
                <img id="indexgallimg4" src="/image/galleryimage4.jpg" alt="" onclick="location.href='/kjhgallery/KjhgalleryList.do'"/>
              </li>

              <li id="bottomlist2">
                <form action="" id="askform">
                  <div style="padding: 4px; height: 23%">
                    <input
                      type="text"
                      id="askname"
                      placeholder="  이름"
                      style="width: 100%; height: 100%"
                    />
                  </div>
                  <div style="padding: 4px; height: 23%">
                    <input
                      type="text"
                      id="askphone"
                      placeholder="  연락처"
                      style="width: 100%; height: 100%"
                    />
                  </div>
                  <div style="padding: 4px; height: 33%">
                    <input
                      type="text"
                      id="askcontent"
                      placeholder="  문의내용"
                      style="width: 100%; height: 100%"
                    />
                  </div>
                  <div style="padding: 4px; height: 20%">
                    <span style="font-size: 0.9em; width: 64%; height: 100%"
                      ><label for="askprivacyagree"><input type="checkbox" id="askprivacyagree" value="" /> 개인정보취급방침을
                      동의합니다.</label>
                    </span>
                    <span style="float: right; width: 35%; height: 100%"
                      ><button
                        type="button"
                        onclick="askcheck();"
                        style="
                          width: 100%;
                          height: 100%;
                          background-color: #212020;
                          color: white;
                          cursor: pointer;
                        "
                      >
                        전송하기
                      </button></span
                    >
                  </div>
                </form>
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
