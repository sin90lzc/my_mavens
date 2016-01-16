
$(document).ready(function(){
	$.ajax(
	{
		type:'POST',
		url:'http://192.168.1.254/cors/getData',
		headers:{'ContentType':'application/json'},
		success:function(resp){
			console.log(resp)
			$("#resp").text(resp.name);
		}
	}
	);
});