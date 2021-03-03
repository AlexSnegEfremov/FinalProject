$(document).ready(function(){
    let pattern = /^[a-z0-9_-]+@[a-z0-9-]+\.[a-z]{2,6}$/i;
    let mail = $('#emailValue');

    mail.blur(function(){
        if(mail.val() != ''){
            if(mail.val().search(pattern) == 0){
                $('#validEmailAdd').text('');
                $('#loginStart').attr('disabled', false);
                mail.removeClass('error').addClass('ok');
            }else{
                $('#validEmailAdd').text('Введите подходящий email адрес');
                $('#loginStart').attr('disabled', true);
                mail.addClass('ok');
            }
        }else{
            $('#validEmailAdd').text('Поле e-mail не должно быть пустым!');
            mail.addClass('error');
            $('#loginStart').attr('disabled', true);
        }
    });
});