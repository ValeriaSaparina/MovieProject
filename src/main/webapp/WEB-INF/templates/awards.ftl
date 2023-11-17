<#include "macro/base.ftl">

<#macro page_head>
<title>Awards</title>
<#include "macro/baseLinks.ftl">
</#macro>

<#macro content>

<#list awards as award>
<div class="row">
    <div class="col">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${award.awardName}</h5>
                <p class="card-text">
                    <strong>Award Category:</strong> ${award.awardCategory}<br>
                    <strong>Awarded Location:</strong> ${award.awardedLocation}<br>
                    <strong>Founder:</strong> ${award.founder}<br>
                    <strong>Date of Foundation:</strong> ${award.dateFoundation}<br>
                    <strong>History:</strong> ${award.history}<br>
                </p>
            </div>
        </div>
    </div>
</div>
</#list>

</#macro>
<@display_page/>