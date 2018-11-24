$(document).ready(function () {

    let $x = $("#inputX");

    for (let x = -3; x <= 5; x += 1) {
        $('<option/>', {
            val: x,
            text: x
        }).appendTo($x);
    }

    $('option[value="0"]', $x).attr('selected', 'selected');

    let $r = $("#inputR");

    for (let r = 1; r <= 5; r += 1) {
        $('<option/>', {
            val: r,
            text: r
        }).appendTo($r);
    }

    $('option[value="5"]', $r).attr('selected', 'selected');

});

