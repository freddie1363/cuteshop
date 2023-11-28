$(function(){
	//alert(initPage);
	if(initPage == "null")
		initPage = "userlogin";
	$('#contentrightdiv > div').hide();	
	$('#contentrightdiv > #' + initPage + 'div').show();
	$('.mgrmenu').click(function() {
		var nextpage = $(this).attr('nextpage');
		var param = $(this).attr('param');
		location.href = "/" + nextpage + ".jsp?param=" + param;
	});
	
	/*
	$('.usermgrmenu').click(function() {
		var param = $(this).attr('param');
		location.href = "/userMgr.jsp?param=" + param;
	});
	$('.companymgrmenu').click(function() {
		var param = $(this).attr('param');
		location.href = "/companyMgr.jsp?param=" + param;
	});
	$('.productmgrmenu').click(function() {
		var param = $(this).attr('param');
		location.href = "/productMgr.jsp?param=" + param;
	});
	*/
	
});