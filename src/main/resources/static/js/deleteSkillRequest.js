$(document).ready(function() {
    $("#btnGetFiles").on("click", function () {
        $("#deletebtn").on("click", function (event) {
            var id = event.target.dataset.id;
            $.ajax({
                url:'/technologyList/' + id,
                type:'DELETE'
            })
        })
    })
});
