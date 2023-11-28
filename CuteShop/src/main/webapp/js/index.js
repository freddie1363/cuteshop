$(function(){
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
	$('ul#contentleftmenu > li').click(function () {
		$('.contentmenu').css('background-color', 'white');
		$(this).css('background-color', 'red');
		var divname = $(this).prop('id');
		//alert(divname);
		$('.contentmenudiv').hide();
		$('#' + divname + 'div').show();
	}); 
});