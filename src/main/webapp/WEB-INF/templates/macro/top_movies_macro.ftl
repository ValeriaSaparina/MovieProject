<#macro topList list name>
    <section class="container mt-5 ">
    <h2 class="mb-4">${name}</h2>
    <div class="scrolling-wrapper-flexbox">
    <#list list as movie>
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="${movie.posterPath!}" style="max-height: 150px; object-fit: cover" class="card-img-top" alt="Movie Title">
                <div class="card-body">
                    <h5 class="card-title">${movie.localName}</h5>
                    <p class="card-text">${movie.description}</p>
                    <#if isAuth><button onclick="like(${movie.id})" type="button" id="like-button${movie.id}"
                            class="btn btn-link like-button" data-favorite="${(favorites?seq_contains(movie))?c}"
                            data-movie-id="${movie.id}">
                        <i class="fas fa-heart text-<#if favorites?seq_contains(movie)>danger<#else>secondary</#if>"></i>
                    </button>
                    </#if>
                    <a href="${path}/moviecard?MovieId=${movie.id}" class="btn btn-primary">Read More</a>
                </div>
            </div>
        </div>
    </#list>
    </div>
    </section>
</#macro>