$(document).ready(function() {
    $('#userName').blur(function() {
        $.ajax({
            url : 'GetUserServlet',
            data : {
                userName : $('#userName').val()
            },
            success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });
});