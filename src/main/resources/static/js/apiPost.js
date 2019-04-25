$(function (){

    var $users = $('#users');
    var firstName =  $('#firstname');
    var lastName =  $('#lastname');
    var $username =  $('#username');
    var $email =  $('#email');
    var phoneNumber =  $('#phonenumber');


    $.ajax({
        type: 'GET',
        url: '/api/users',
        success: function(users) {
            $.each(users, function(i, user) {
                $users.append('<li>username: '+ user.username + ', email: '+ user.email + '</li>')
            });
        },
        error: function() {
            alert('error loading users;');
        }
    })

    $('#add-user').on('click', function () {
        var user = {
            firstName: firstName.val(),
            lastName: lastName.val(),
            username: $username.val(),
            email: $email.val(),
            phoneNumber: phoneNumber.val()
        }
        $.ajax({
            type: 'POST',
            url:'/api/users',
            data: user,
            success: function (newUser) {
                $users.append('<li>username: '+ newUser.username + ',' +
                    'email: '+ newUser.email + ',' +
                    'First name: ' + newUser.firstName + ',' +
                    'Last name: ' + newUser.lastName + ',' +
                    'Phone number: ' + newUser.phoneNumber  + '</li>')
            }
        })
    })
})

