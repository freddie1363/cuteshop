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
	
	$('ul#contentleftmenu > li').click(function () {
		$('.contentmenu').css('background-color', 'white');
		$(this).css('background-color', 'red');
		var divname = $(this).prop('id');
		//alert(divname);
		$('.contentmenudiv').hide();
		$('#' + divname + 'div').show();
	}); 
});

function showModifyDiv() {
	$('#contentrightdiv > div').hide();	
	$('input[name="id"]').val("-1");
	$('input[name="subject"]').val("abc");		
	$('textarea[name="content"]').val("def");
	$('#contentrightdiv > div#registdiv').show();	
}

