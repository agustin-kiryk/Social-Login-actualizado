$(document).ready(function(){
    $.getJSON('/userVisit', function(data) {
        $('#login').text(data.email);
        $('#avatar').attr("src", data.pictureUrl);
    });

    assignButtons();
    loadPages();
    loadData(0);
});

function assignButtons() {
    $("#submitButton").click(function (e) {
        if ($("#taskText").val() == "")
            $("#textSpan").text("Enter text");
        else
            $("#textSpan").text("");

        if ($("#taskDate").val() == "")
            $("#dateSpan").text("Enter date");
        else
            $("#dateSpan").text("");

        if (($("#taskText").val() != "") && ($("#taskDate").val() != "")) {
            const task = {
                date: $("#taskDate").val(),
                text: $("#taskText").val()
            };

            $.ajax({
                type: "POST",
                url: "/add",
                contentType: "application/json",
                data: JSON.stringify(task),
                dataType: "json",
                success: function (result, status, xhr) {
                    if (result.description == "OK") {
                        $("#messageSpan").text("Added successfully");
                        setTimeout(function () {
                            window.location = "/";
                        }, 2000);
                    } else {
                        $("#messageSpan").text("Error occured!");
                    }
                },
                error: function (xhr, status, error) {
                    var jsonError = jQuery.parseJSON( xhr.responseText );
                    var desc = (jsonError != "") ? jsonError.description : "no details";

                    $("#messageSpan").text("Result: " + status + " " + error + " " +
                        xhr.status + " " + xhr.statusText + ": " + desc);
                }
            });
        }
    });

    $('#deleteButton').click(function() {
        var idList = { 'toDelete' : []};

        $(":checked").each(function() {
            idList['toDelete'].push($(this).val());
        });

        $.post("/delete", idList, function(data, status) {
            window.location = "/";
        });
    });
}

function loadPages() {
    $("#pages").empty();

    $.getJSON('/count', function(data) {
        var pageCount = (data.count / data.pageSize) +
            (data.count % data.pageSize > 0 ? 1 : 0);
        var i;

        for (i = 1; i <= pageCount; i++) {
            $('#pages').append(
                $('<li>').attr('class', 'page-item').append(
                    $('<a>').attr('class', 'page-link').attr('id', i - 1)
                        .append('Page ' + i))
            );
        }
    });

    $("#pages").on("click", ".page-link", function(event) {
        loadData(event.target.id);
    });
}

function loadData(page) {
    $("#data > tbody").empty();

    $.getJSON('/tasks?page=' + page, function(data) {
        var i;

        for (i = 0; i < data.length; i++) {
            $('#data > tbody:last-child').append(
                $('<tr>')
                    .append(
                        $('<td>').append(
                            $('<input>').attr('type', 'checkbox').attr('value', data[i].id)
                        )
                    )
                    .append($('<td>').append(data[i].date.replace('T', '  ')))
                    .append($('<td>').append(data[i].text))
            );
        }
    });
}