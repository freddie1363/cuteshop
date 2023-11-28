<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.kjhuser.service.KjhuserVO" %>
<%@ page import="egovframework.kjhgallery.service.KjhgalleryVO" %>
<%@ page import="egovframework.kjhgallery.service.KjhgalleryDefaultVO" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<script>
function loginCheck() {
	alert("글 작성은 회원만 이용 가능 합니다.");
}
</script>
              <div class="gallerycontentunderdiv"></div>
              <div class="gallerycontentunderdiv"><hr /></div>
              <div id="gallerybtndiv">         
                <button onclick="searchboxclicked();">검색</button>
<%
if(session.getAttribute("loginedUserVO") != null)
	userVO = (KjhuserVO)session.getAttribute("loginedUserVO");
if(userVO==null){
%>     
                <button onclick="loginCheck();">글작성</button>
 <%
} else { 
  %>               
                <button onclick="location.href='/uploadform.jsp'">글작성</button>
<%
}
%>                
              </div>
<script>
function searchCheck() {
	document.searchfrm.submit();
}
</script>              
              <div id="galleryhiddendiv">
              <form name="searchfrm" id="searchfrm" class="" target="ABC" action ="/kjhgallery/KjhgalleryList.do">
                <input
                  type="text"
                  style="
                    width: 90%;
                    height: 99.9%;
                    font-size: 15px;
                    border: 1px solid black;
                  " name="searchKeyword"
                  	value="${keyword.searchKeyword }"
                />
                <input type="hidden" name="searchCondition" value="1" />
                <label onclick="searchCheck();"
                  ><i class="fa-solid fa-magnifying-glass"></i
                ></label>
                </form>
              </div>
              <hr />
              <div id="galleryuldiv">
                <ul id="galleryul">
                  <c:forEach var="result" items="${resultList}" varStatus="status">
                  
	 			<li onclick="location.href='/kjhgallery/selectGallery.do?id=${result.id}'">
                    <a href="/kjhgallery/selectGallery.do?id=${result.id}"
                      ><img src="/${result.appendix}" alt="이미지"
                    />
                    <dl>
                      <dt><a href="/kjhgallery/selectGallery.do?id=${result.id}">${result.subject}</a></dt>
                      <dd id="precontent">
                        <a href="/kjhgallery/selectGallery.do?id=${result.id}">${result.content}</a>
                      </dd>
                      <dd id="regdate"><a href="/kjhgallery/selectGallery.do?id=${result.id}">${result.writer} ${result.regdate} 조회: ${result.views} 추천: ${result.likes }</a></dd>
                    </dl>
                  </li>
	 		
                  </c:forEach>
                  
                </ul>
                <hr />
              </div>
              <br />
    <div class="paging" style="font-size:1.3em;">
  		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage"/>
	</div>
 
<script type="text/javascript">
/* 페이징과 글 목록 조회  */
var currentPageNo = ${pageNo};
 
function linkPage(pageNo){
		location.href = "/kjhgallery/KjhgalleryList.do?pageNo=" + pageNo;	
}
</script>
              
              
              <!-- <div class="gallerycontentunderdiv" style="text-align: center; margin-top: 35px;">
                <span
                  style="
                    height: 50px;
                    width: 820px;
                    font-weight: bold;
                    text-decoration: underline;
                  "
                  ><a href="">1</a></span
                >
              </div> -->
              
              
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