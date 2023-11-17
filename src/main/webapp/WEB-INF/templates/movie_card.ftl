<#include "macro/base.ftl">

<#macro page_head>
    <title>Movie Page</title>
    <#include "macro/baseLinks.ftl">
    <link href="${path}/css/card.css" rel="stylesheet">
    <script src="${path}/js/ajaxAddReviews.js" type="application/javascript"></script>
    <script src="${path}/js/ajaxActionLike.js" type="application/javascript"></script>
</#macro>

<#macro content>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <img src="${movie.posterPath}" style="max-height: 400px; object-fit: cover" class="card-img-top"
                         alt="Movie Poster" style="width: 300px; height: 300px;">
                    <div class="card-body">
                        <h5 class="card-title">${movie.localName}
                            <#if user??><button onclick="like(${movie.id})" type="button" id="like-button${movie.id}"
                                    class="btn btn-link like-button"
                                    data-favorite="${(favorites?seq_contains(movie))?c}"
                                    data-movie-id="${movie.id}">
                                <i class="fas fa-heart text-<#if favorites?seq_contains(movie)>danger<#else>secondary</#if>"></i>
                            </button>
                            </#if>
                        </h5>
                        <p class="card-text">${movie.description}</p>

                        <h6 class="card-subtitle mb-2 text-muted">Rating: ${movie.rating}</h6>
                        <hr>

                        <#if user??>

                            <h6 class="card-subtitle mb-2 text-muted">Leave a Review:</h6>

                            <div class="mb-3">
                                <select class="form-control" id="reviewTypeInput" name="type">
                                    <option value="1">
                                        Positive
                                    </option>
                                    <option value="0">
                                        Neutral
                                    </option>
                                    <option value="2">
                                        Negative
                                    </option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <input class="form-control" id="reviewTitleInput" name="title" placeholder="Title">
                            </div>
                            <div class="mb-3">
                            <textarea class="form-control" id="reviewTextInput" name="text" rows="3"
                                      placeholder="Write your review here"></textarea>
                            </div>
                            <input type="submit" onclick="add()" id="submitReviewBtn" class="btn btn-primary"
                                   value="Submit Review">

                        <#else>
                            <p><a href="${path}/auth">Войдите</a>, чтобы оставить отзыв</p>
                        </#if>

                        <hr>
                        <h6 class="card-subtitle mb-2 text-muted">All Reviews:</h6>
                        <#list reviews as review>
                            <div class="card"
                                 style="background-color: <#if review.type == "1">#98FB98<#elseif review.type == "2">#FFE4E1</#if>">
                                <div class="card-body">
                                    <h6 class="card-text">${review.title}</h6>
                                    <hr>
                                    <p class="card-text">${review.text}</p>
                                </div>
                            </div>
                        </#list>
                        <div id="reviewAjax">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>
<@display_page/>