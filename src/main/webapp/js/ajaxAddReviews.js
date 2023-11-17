function add() {
    var reviewText = $("#reviewTextInput").val();
    var reviewTitle = $("#reviewTitleInput").val();
    var reviewType = $("#reviewTypeInput").val();
    var movieId = window.location.search.split("=")[1];

    var colorType;
    if (reviewType === "1") colorType = "#98FB98";
    else {
        if (reviewType === "2") colorType = "#FFE4E1"
    }

    $.ajax({
        url: "addReview",
        type: "POST",
        data: {text: reviewText, title: reviewTitle, type: reviewType, movieId: movieId},
        dataType: "json",
        success: function (response) {
            if (response.success) {
                $("#reviewTitleInput").val("");
                $("#reviewTypeInput").val(1);
                $("#reviewTextInput").val("");
                $("#reviewAjax").append("<div class=\"card\"> <div class=\"card-body\" style=\"background-color: " + colorType + "\"> <h6 class=\"card-text\">" + reviewTitle + "</h6><hr>" +
                    "<p class=\"card-text\">" + reviewText + "</p></div></div>");
            }
        }
    });
}
