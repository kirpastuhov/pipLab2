<%--
  Created by IntelliJ IDEA.
  User: Kirill-MBP
  Date: 16/11/2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jQuery, Ajax and Servlet/JSP integration example</title>

    <script src="https://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>
    <script src="js/app-ajax.js" type="text/javascript"></script>
</head>
<body>

<form>
    Enter Your Name: <input type="text" id="userName" />
</form>
<br>
<br>

<strong>Ajax Response</strong>:
<div id="ajaxGetUserServletResponse"></div>
</body>

<script>
    $(document).ready(function() {
        $('#userName').blur(function(event) {
            var name = $('#userName').val();
            $.get('GetUserServlet', {
                userName : name
            }, function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            });
        });
    });
</script>
</html>
