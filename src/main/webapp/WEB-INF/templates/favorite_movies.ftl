<#include "macro/base.ftl">

<#macro page_head>
    <title>List of Movies</title>
    <#include "macro/baseLinks.ftl">
    <script src="${path}/js/ajaxActionLike.js" type="application/javascript"></script>
</#macro>

<#macro content>
    <div class="container">

        <h1 class="my-4 text-center">List of Favorite Movies</h1>

        <div class="row">
            <div class="col-md-6 offset-md-3">
                <#list movies as movie>
                    <div id="movie${movie.id}">
                        <div class="movie-card">
                            <div class="card mb-3">
                                <div class="row no-gutters">
                                    <div class="col-md-4">
                                        <img src="${movie.posterPath}" style="max-height: 400px; object-fit: cover" class="card-img" alt="Movie 1 Poster">
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <h5 class="card-title">${movie.localName}</h5>
                                            <p class="card-text">${movie.description}</p>
                                            <button onclick="deleteLikeFromList(${movie.id})" type="button"
                                                    id="like-button"
                                                    class="btn btn-link like-button" data-favorite="true"
                                                    data-movie-id="${movie.id}">
                                                <i class="fas fa-heart text-danger"></i>
                                            </button>
                                            <a href="${path}/moviecard?MovieId=${movie.id}" class="btn btn-primary">View
                                                Details</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>

                <#if !(movies?has_content)>Вы еще не добавили ни одного фильма</#if>
            </div>
        </div>
    </div>
</#macro>
<@display_page/>