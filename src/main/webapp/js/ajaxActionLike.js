function deleteLikeFromList(movieId) {
    $.ajax({
        url: "deleteLike",
        type: "POST",
        data: {movieId: movieId},
        dataType: "json",
        success: function (response) {
            if (response.success) {
                const id = "#movie" + movieId;
                const content = document.getElementsByClassName("movie-card");
                $(id).html("");
                if (content.length === 0) $(id).html("Вы еще не добавили ни одного фильма");
            }
        }
    });
}



function like(movieId) {
    const btnId = "like-button" + movieId
    const button = document.getElementById(btnId);
    const isFavorite = button.getAttribute("data-favorite");

    if (isFavorite === 'false') {
        addLike(movieId, button);
    } else {
        deleteLike(movieId, button);
    }
}

function addLike(movieId, button) {
    $.ajax({
        url: "addLike",
        type: "POST",
        data: {movieId: movieId},
        dataType: "json",
        success: function (response) {
            if (response.success) {
                button.innerHTML = '<i class="fas fa-heart text-danger"></i>';
                button.setAttribute('data-favorite', 'true');
            }
        }
    });
}

function deleteLike(movieId, button) {
    $.ajax({
        url: "deleteLike",
        type: "POST",
        data: {movieId: movieId},
        dataType: "json",
        success: function (response) {
            if (response.success) {
                button.innerHTML = '<i class="fas fa-heart text-secondary"></i>';
                button.setAttribute('data-favorite', 'false');
            }
        }
    });
}


