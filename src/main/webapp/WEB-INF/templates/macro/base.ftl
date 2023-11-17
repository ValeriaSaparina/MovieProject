<#macro content></#macro>
<#macro page_head></#macro>

<#macro display_page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <link href="/MovieProject_war_exploded/css/main.css" rel="stylesheet">
        <script src="/MovieProject_war_exploded/js/ajaxActionLike.js" type="application/javascript"></script>
        <#include "baseLinks.ftl">
        <@page_head/>
    </head>

    <body>

    <#include "nav.ftl">

    <@content/>

<#--    <#include "footer.ftl">-->
    </body>

    </html>
</#macro>