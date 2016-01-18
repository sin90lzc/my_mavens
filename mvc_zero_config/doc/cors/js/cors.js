
$(document).ready(function(){
	$.ajax(
	{
		type:'POST',
		url:'http://192.168.100.190:8080/mc/cors/getData',
//		headers:{'ContentType':'application/json'},
		complete:function(xhr,code){
			$("#resp").text(xhr.responseText);
		}
	}
	);
});