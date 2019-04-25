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
			url: '/api/resumeForm',
			success: function(resume) {
				$.each(resume, function(i, resume) {
					$('#listFiles2').append('<ul><li> ' + resume.id + resume.file + '</li></ul>')
				})

			}
		});
	}
})
