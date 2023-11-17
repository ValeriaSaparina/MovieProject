<#include "macro/base.ftl">
<#include "macro/top_movies_macro.ftl">

<#macro page_head>
    <title>Main Page</title>
    <link href="${path}/css/main.css" rel="stylesheet">
    <script src="${path}/js/ajaxActionLike.js" type="application/javascript"></script>
</#macro>

<#macro content>
    <div class="container text-center">
        <h1 class="display-4">Welcome to Movie Site</h1>
        <p class="lead">Discover the latest movies and explore various actors.</p>
    </div>

    <@topList top, "Top 10"/>
    <@topList topExpected, "Top 10 expected"/>
    <@topList topDiscussed, "Top 10 discussed"/>

</#macro>
<@display_page/>