$(document).ready( () => {
    $("#btnSubmit").click((event) => {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        doAjax();
    });
 
});
 
function doAjax() {
 
    // Get form
    var form = $('#fileUploadResume')[0];
    var data = new FormData(form);
 
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/resumeForm/update",
        data: data,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        success: (data) => {
            $("#listFiles2").text(data);
        },
        error: (e) => {
            $("#listFiles2").text(e.responseText);
        }
    });
}
