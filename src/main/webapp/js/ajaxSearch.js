function search() {
    if ($("#query").val().length >= 1) {
        $.ajax({
            url: "search",
            data: {"query": $("#query").val()},
            dataType: "json",
            success: function (msg) {
                if (msg.objects.length > 0) {
                    $("#searchResult").html("");
                    for (var i = 0; i < msg.objects.length; i++) {
                        $("#searchResult").append("<li><a class=\"dropdown-item\" style=\"white-space: pre-wrap\" href=\"/moviecard?MovieId=" + msg.objects[i].id + "\">" + msg.objects[i].localName + "</a></li>");
                    }
                } else {
                    $("#searchResult").html("");
                }
            }
        })
    } else {
        $("#searchResult").html("");
    }
}

