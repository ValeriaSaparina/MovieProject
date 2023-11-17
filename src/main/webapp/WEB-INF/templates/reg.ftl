<#include "macro/base.ftl">
<#include "macro/top_movies_macro.ftl">

<#macro page_head>
    <title>Регистрация</title>
    <#include "macro/baseLinks.ftl">
    <link href="${path}/css/reg.css" rel="stylesheet">
    <script src="${path}/js/validateData.js" type="application/javascript"></script>
    <script src="${path}/js/ajaxIsUniqueUsername.js" type="application/javascript"></script>
</#macro>

<#macro content>
    <div class="form-signin text-center">
        <form method="post">
            <h1 class="h3 mb-3 font-weight-normal">Регистрация</h1>
            <input type="text" name="username" id="inputUsername" class="myInput form-control"
                   onblur="validateUsername()"
                   placeholder="Username" autofocus="">
            <p class="error" id="errorUsername"></p>
            <input type="text" name="name" id="inputName" class="myInput form-control" onblur="validateFirstname()"
                   placeholder="Name" autofocus="">
            <p class="error" id="errorFirstname"></p>
            <input type="text" name="surname" id="inputSurname" class="myInput form-control" placeholder="Surname"
                   onblur="validateLastname()" autofocus="">
            <p class="error" id="errorLastname"></p>
            <input type="password" name="password" id="inputPassword" class="myInput form-control"
                   onblur="validatePassword()" placeholder="Password">
            <p class="error" id="errorPassword"></p>
            <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" name="remember-me" value="on"> Запомнить меня
                </label>
            </div>
            <input class="btn btn-lg btn-primary btn-block form-control" type="submit" id="submitBtn" disabled
                   value="Зарегистрироваться">


        </form>

        <span>Уже зарегистрированы? <a href="${path}/auth">Войти</a></span>
    </div>

</#macro>
<@display_page/>