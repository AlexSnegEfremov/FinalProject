// проверка валидности email на лету
$(document).ready(function(){
    var pattern = /^[a-z0-9_-]+@[a-z0-9-]+\.[a-z]{2,6}$/i;
    var mail = $('#emailAdd');

    mail.blur(function(){
        if(mail.val() != ''){
            if(mail.val().search(pattern) == 0){
                $('#validAdd').text('');
                $('#addUserButton').attr('disabled', false);
                mail.removeClass('error').addClass('ok');
            }else{
                $('#validAdd').text('Введите подходящий email адрес');
                $('#addUserButton').attr('disabled', true);
                mail.addClass('ok');
            }
        }else{
            $('#validAdd').text('Поле e-mail не должно быть пустым!');
            mail.addClass('error');
            $('#addUserButton').attr('disabled', true);
        }
    });
});
// проверка валидности email при изменении юзера
$(document).ready(function(){
    let pattern = /^[a-z0-9_-]+@[a-z0-9-]+\.[a-z]{2,6}$/i;
    let mail = $('#userEmail');

    mail.blur(function(){
        if(mail.val() != ''){
            if(mail.val().search(pattern) == 0){
                $('#validEdit').text('');
                $('#userEditButton').attr('disabled', false);
                mail.removeClass('error').addClass('ok');
            }else{
                $('#validEdit').text('Введите подходящий email адрес');
                $('#userEditButton').attr('disabled', true);
                mail.addClass('ok');
            }
        }else{
            $('#validEdit').text('Поле e-mail не должно быть пустым!');
            mail.addClass('error');
            $('#userEditButton').attr('disabled', true);
        }
    });
});