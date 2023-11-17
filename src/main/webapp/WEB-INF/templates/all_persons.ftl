<#include "macro/base.ftl">

<#macro page_head>
    <title>List of Persons</title>
    <script src="${path}/js/ajaxActionLike.js" type="application/javascript"></script>
</#macro>

<#macro content>
    <div class="container">

        <h1 class="my-4 text-center">List of Persons</h1>

        <form class="row">

            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Search..." name="q" value="${query}"
                               aria-label="Search">
                        <div class="input-group-append">
                            <input class="btn btn-primary" type="submit" value="Search">
                        </div>
                    </div>
                </div>
            </div>

            <div class="row input-group mb-3">
                <div class="col-md-6 offset-md-3">
                    <div class="form-group">
                        <label for="role">Кого ищем?</label>
                        <select class="form-control" id="role" name="role">
                            <option value="">Выбор...</option>
                            <option value="actor">Актер</option>
                            <option value="director">Режиссёр</option>
                            <option value="producer">Продюсер</option>
                            <option value="screenwriter">Сценарист</option>
                        </select>
                    </div>
                </div>
            </div>
        </form>

        <div class="row">
            <div class="col-md-6 offset-md-3">
                <#list persons as person>
                    <div class="card mb-3">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <img src="${person.photoPath}" style="max-height: 400px; object-fit: cover" class="card-img" alt="Movie 1 Poster">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">${person.firstname} ${person.lastname}</h5>
                                    <p class="card-text"></p>
<#--                                    <a href="${path}/personcard?PersonId=${person.id}" class="btn btn-primary">View-->
<#--                                        Details</a>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>

                <#if !(persons?has_content)>По Вашему запросу ничегo</#if>
            </div>
        </div>
    </div>
</#macro>
<@display_page/>