$(document).ready(function(){
    $.getJSON('/userVisit', function(data) {
        $('#login').text(data.email);
        $('#avatar').attr("src", data.pictureUrl);
    });}

