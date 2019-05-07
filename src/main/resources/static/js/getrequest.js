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
					$('#listFiles').append('<tr>' + '<td>' + '<button type="button" id="deletebtn" data-id="' + skill.id+ '" name="deletebtn">' + 'Delete' + '</button>'  + '</td>'+ '<td>' + skill.id + '</td>' + '<td>' + skill.logo +'</td>' + '<td>' + skill.techName + '</td></tr>')
				})

			}
		});
	}
})
