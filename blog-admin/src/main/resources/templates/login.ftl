<!DOCTYPE html>
<html>
<#include "include/macros.ftl">
<@header></@header>
<#if loginFailed?? && loginFailed>
    <script type="text/javascript">
        alert("用户名或密码不正确");
    </script>
</#if>
<body>
<div class="login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>MG后台管理系统</h1>
                            </div>
                            <p>做大于说</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form id="login_form" class="form-validate mb-4" method="post">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="userName" required
                                           data-msg="请输入用户名" class="input-material">
                                    <label for="login-username" class="label-material">用户名</label>
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="pass" required
                                           data-msg="请输入您的密码" class="input-material">
                                    <label for="login-password" class="label-material">密码</label>
                                </div>
                                <button type="submit" class="btn btn-primary" onclick="doLogin()">登录</button>
                            </form>
                            <a href="#" class="forgot-pass">忘记密码?</a>
                            <br>
                            <#if canRegister>
                                <small>还未有账号? </small>
                                <a href="/register" class="注册">去注册</a>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<@footer></@footer>
<script type="text/javascript">
    function doLogin() {
        console.log("do login")
        if (validateLoginForm()) {
            $("#login_form").attr("action", "/login");
            $("#login_form").submit();
        }
    }

    function validateLoginForm() {
        return true;
    }
</script>
</body>
</html>