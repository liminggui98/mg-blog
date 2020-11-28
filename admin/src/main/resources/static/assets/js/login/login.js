$(document).on('keypress', function (e) {
    // 回车键事件
    if (e.which == 13) {
        $('#loginButton').click();
    }
});

$('input[type="text"], input[type="password"]').focus(function () {
    $(this).prev().animate({
        'opacity': '1'
    }, 200);
});

$('input[type="text"],input[type="password"]').blur(function () {
    $(this).prev().animate({
        'opacity': '.5'
    }, 200);
});

$('input[name="username"],input[name="password"]').keyup(function () {
    var Len = $(this).val().length;
    if (!$(this).val() + "" === "" && Len >= 5) {
        $(this).next().animate({
            'opacity': '1',
            'right': '30'
        }, 200);
    } else {
        $(this).next().animate({
            'opacity': '0',
            'right': '20'
        }, 200);
    }
});



