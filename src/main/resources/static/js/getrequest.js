$( document ).ready( () => {
	
	var url = window.location;

	// GET REQUEST
	$("#btnGetFiles").click( (event) => {
		event.preventDefault();
		ajaxGet();
	});
	$('#listFiles').on('click', 'button[name="deletebtn"]', function () {
		deleteMe(event.target.dataset.id);
	})

function deleteMe(id) {
		var retVal = confirm("Do you want to delete the skill with id " + id);
		if ( retVal == true) {
			$.ajax({
				url: '/api/technologyList' + '/' + id,
				type: 'DELETE',
				success: function () {
					window.location.reload(true);
					var getSkillsButton = document.getElementById('listFiles');
					getSkillsButton.click();
				}
			})
			return true;
		}
		else {
			window.alert("Skill not delete!");
			return false;
		}


}

// DO GET
function ajaxGet() {
	$.ajax({
		type: 'GET',
		url: '/api/technologyList',
		success: function (skills) {
			$.each(skills, function (i, skill) {
				$('#listFiles').append('<tr>' + '<td>' + '<button ' +
					'type="submit" ' +
					'data-id="' + skill.id + '" ' +
					'onclick="deleteMe('+skill.id+')"' +
					'name="deletebtn">' +
					'Delete' +
					'</button>' + '</td>' +
					'<td>' + skill.id + '</td>' +
					'<td>' + skill.logo + '</td>' +
					'<td>' + skill.techName + '</td></tr>')
			})
		}
	});
}
});
