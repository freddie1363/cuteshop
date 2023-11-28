$(function(){
	if(initPage == "null")
		initPage = "list";
	$('#contentrightdiv > div').hide();	
	$('#contentrightdiv > #' + initPage + 'div').show();
	$('.mgrmenu').click(function() {
		var nextpage = $(this).attr('nextpage');
		var param = $(this).attr('param');
		location.href = "/" + nextpage + ".jsp?param=" + param;
	});
	$('#listbtn').click(function() {
		location.href = "/document/DocumentList.do";
	});
	
	$('#registbtn').click(function() {
		$('#contentrightdiv > div').hide();	
		
		//document.documentjoinfrm.reset();
		$('#documentjoinfrm input[name="id"]').val("-1");
		$('#documentjoinfrm input[name="title"]').val("");		
		$('#documentjoinfrm input[name="content"]').val("");
		$('#documentjoinfrm input[name="writer"]').val("");
		$('#contentrightdiv > div#registdiv').show();	
	});
	
});