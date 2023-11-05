<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>Movie Page</title>
    <style>
        .card {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<script>

    function add() {
        var reviewText = $("#reviewTextInput").val();
        var reviewTitle = $("#reviewTitleInput").val();
        var reviewType = $("#reviewTypeInput").val();

        $.ajax({
            url: "addReview",
            type: "POST",
            data: {text: reviewText, title: reviewTitle, type: reviewType},
            dataType: "json",
            success: function (response) {
                if (response.success) {
                    $("#reviewTitleInput").val("");
                    $("#reviewTypeInput").val(1);
                    $("#reviewTextInput").val("");
                    $("#reviewAjax").append("<div class=\"card\"> <div class=\"card-body\"> <p class=\"card-text\">" + reviewTitle + "</p>" +
                        "<p class=\"card-text\">" + reviewText + "</p></div></div>");
                }
            }
        });
    }

</script>


<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <img src="${req.getContextPath()}/avatars/test.jpg" class="card-img-top"
                     alt="Movie Poster" style="width: 300px; height: 300px;">
                <div class="card-body">
                    <h5 class="card-title">${movie.localName}</h5>
                    <p class="card-text">${movie.description}</p>
                    <h6 class="card-subtitle mb-2 text-muted">Rating: ${movie.rating}</h6>
                    <hr>
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

                    <hr>
                    <h6 class="card-subtitle mb-2 text-muted">All Reviews:</h6>
                    <#list reviews as review>
                        <div class="card">
                            <div class="card-body">
                                <p class="card-text">${review.title}</p>
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
</body>
</html>