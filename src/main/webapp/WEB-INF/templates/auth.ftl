<#include "macro/base.ftl">

<#macro page_head>
    <title>Title</title>
    <link href="${path}/css/reg.css" rel="stylesheet">
</#macro>

<#macro content>
    <div class="text-center">
        <div class="form-signin">
            <form method="post">
                <h1 class="h3 mb-3 font-weight-normal">Вход</h1>
                <input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username"
                       autofocus="">
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password">
                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" name="remember-me" value="on"> Запомнить меня
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block form-control" id="submitBtn" type="submit">Войти
                </button>
            </form>

            <span>Нет аккаунта? <a href="${path}/registration">Зарегистрироваться</a></span>
        </div>
    </div>
</#macro>
<@display_page/>