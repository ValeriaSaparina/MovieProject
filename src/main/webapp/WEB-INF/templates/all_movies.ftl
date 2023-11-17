<#include "macro/base.ftl">
<#include "macro/all_list_macro.ftl">


<#macro page_head>
    <title>List of Movies</title>
    <script src="${path}/js/ajaxActionLike.js" type="application/javascript"></script>
</#macro>


<#macro content>

    <div class="container">

        <h1 class="my-4 text-center">List of Movies</h1>

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

            <div class="row col-md-6 offset-md-3">
                <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseExample"
                        aria-expanded="false" aria-controls="collapseExample">
                    Настроить поиск
                </button>
            </div>
            <div class="collapse" id="collapseExample">
                <div class="row input-group mb-3">
                    <div class="col-md-6 offset-md-3">
                        <div class="form-group">
                            <label for="country">Страна</label>
                            <input type="text" class="form-control" id="country" name="country">
                        </div>
                        <div class="form-group">
                            <label for="rating">Рейтинг</label>
                            <input type="number" class="form-control" placeholder="больше, чем..." id="rating"
                                   name="rating"
                                   min="0" max="10">
                        </div>
                        <div class="form-group">
                            <label for="ageLimit">Возрастное ограничение</label>
                            <select class="form-control" id="ageLimit" name="ageLimit">
                                <option value="">Select Age Limit</option>
                                <option value="G">G</option>
                                <option value="PG-13">PG-13</option>
                                <option value="R">R</option>
                                <option value="NC-17">NC-17</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <@all_list/>
    </div>
</#macro>
<@display_page/>