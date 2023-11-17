<#macro all_list>
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <#list movies as movie>
                <div class="card mb-3">
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="${movie.posterPath}" style="max-height: 400px; object-fit: cover" class="card-img"
                                 alt="Movie 1 Poster">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${movie.localName}</h5>
                                <p class="card-text">${movie.description}</p>
                                <#if isAuth>
                                    <button onclick="like(${movie.id})" type="button" id="like-button${movie.id}"
                                            class="btn btn-link like-button"
                                            data-favorite="${(favorites?seq_contains(movie))?c}"
                                            data-movie-id="${movie.id}">
                                    <i class="fas fa-heart text-<#if favorites?seq_contains(movie)>danger<#else>secondary</#if>"></i>
                                    </button>
                                </#if>
                                <a href="${path}/moviecard?MovieId=${movie.id}" class="btn btn-primary">View Details</a>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>

            <#if !(movies?has_content)>По Вашему запросу ничегo</#if>
        </div>
    </div>
</#macro>