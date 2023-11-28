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
		//location.href = "/faq/FaqList.do";
		getList();
	});
	
	$('#registbtn').click(function() {
		$('#contentrightdiv > div').hide();	
		
		//faq.faqjoinfrm.reset();
		$('#faqjoinfrm input[name="id"]').val("-1");
		$('#faqjoinfrm input[name="title"]').val("");		
		$('#faqjoinfrm input[name="content"]').val("");
		$('#faqjoinfrm input[name="writer"]').val("");
		$('#contentrightdiv > div#registdiv').show();	
	});
	
});

function getList() {
	alert("getList()");
	//location.href = "/faq/selectFaq.do?id=" + id;	
	//alert('faqModify(), id : ' + id);	   
	   $.ajax({
	       url:'/faq/getFaqVOListJson.do', //request 보낼 서버의 경로
	       type:'post', // 메소드(get, post, put 등)
	       data:{},
	       dataType: "json",
	       success: function(data) {
	           //서버로부터 정상적으로 응답이 왔을 때 실행
	           objData = data;
	           alert("정상수신 ");	           
	           $('#contentrightdiv > div').hide();
	           
	           var liString = "";
	           
	           $(data.faqVOList).each(function () {
	           		var id = this.id;
	           		var subject = this.subject;
	           		var content = this.content;
	           		var writer = this.writer;
	           		//alert(subject);
	           		liString += "<li class='bgonoff' onclick=\"faqModify('" + id + "');\">" + id + " th " + subject + " " + content + "</li>";
	           });
	           //alert(liString);
	           $('#faqListUL').html(liString); 
	           //$('#faqListUL').refresh();                   
	           $('#contentrightdiv > div#listdiv').show();
	       },
	       error: function(err) {
	           //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
	           objErr = err;
	          alert("오류발생 , error="+err.state());
	       }
	   });
	   
}