<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01"
                aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="${path}/">Movies</a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <#if isAuth><a class="nav-link" href="${path}/profile">Профиль</a>
                    <#else><a class="nav-link" href="${path}/auth">Войти</a></#if>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${path}/allMovies">Movies</a>
                </li>
                <#if isAuth>
                    <li class="nav-item">
                        <a class="nav-link" href="${path}/favoriteMovies">Favorite movies</a>
                    </li>
                </#if>
                <li class="nav-item">
                    <a class="nav-link" href="${path}/allPersons">Persons</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${path}/allAwards">Awards</a>
                </li>
            </ul>
            <form class="d-flex" action="${path}/allMovies">
                <div class="dropdown">
                    <input class="form-control me-2" id="query" name="q" oninput="search()" data-bs-toggle="dropdown"
                           type="search"
                           placeholder="Search"
                           aria-label="Search">
                    <ul class="dropdown-menu form-control" aria-labelledby="defaultDropdown" id="searchResult">
                    </ul>
                </div>
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>