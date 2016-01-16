
$(document).ready(function(){
	$.ajax(
	{
		type:'POST',
		url:'http://192.168.1.14:8080/mc/cors/getData',
		complete:function(xhr,code){
			$("#resp").text(xhr.responseText);
		}
	}
	);
});