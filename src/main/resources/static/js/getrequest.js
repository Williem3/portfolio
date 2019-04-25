$( document ).ready( () => {
	
	var url = window.location;
	
	// GET REQUEST
	$("#btnGetFiles").click( (event) => {
		event.preventDefault();
		ajaxGet();
	});
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type: 'GET',
			url: '/api/technologyList',
			success: function(skills) {
				$.each(skills, function(i, skill) {
					$('#listFiles').append('<tr><td> '+ '<img src="' + base64List + '"/>' +'</td>' + '<td>' + skill.techName + '</td></tr>')
				})

			}
		});
	}
})
