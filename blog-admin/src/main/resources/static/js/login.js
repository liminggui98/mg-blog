function doLogin() {
    if(validateLoginForm()){
        $("#login_form").attr("action","login");
        $("#login_form").submit();
    }
}

function validateLoginForm(){
    return true;
}