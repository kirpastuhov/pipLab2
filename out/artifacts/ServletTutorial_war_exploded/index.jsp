<%--
  Created by IntelliJ IDEA.
  User: Kirill-MBP
  Date: 16/11/2018
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jcanvas.min.js"></script>
<link rel="stylesheet" href="css/styles.css">
<link rel="shortcut icon" href="images/favicon.ico">

<script src="js/inputCheck.js"></script>

<script src="js/check.js"></script>

<script src="js/updateY.js"></script>

<script src="js/fields.js"></script>

<script src="js/drawAxes.js"></script>

<script src="js/chart.js"></script>

<script src="js/drawPoint.js"></script>



<html>
<head>
  <title>Lab №2</title>
</head>
<body>
<h4 style="text-align:center">Pastukhov Kirill P3218 Var. 1803</h4>
<div class="row">
  <jsp:include page="canvas.jsp"/>
  <div class="col-sm">
    <form action="MainServlter" method="GET" onsubmit="return false;" id="form">
      <div class="row disable-selection">
        <div class="form-group col-sm" style="text-align: center">
          <label>X</label>
          <select class="form-control" id="inputX" name="inputX"></select>
        </div>
        <div class="form-group col-sm" style="text-align: center">
          <label>Y</label>
          <input type="text" value="0" maxlength="10" class="form-control is-invalid" id="inputY" name="inputY"
                 placeholder="(-3, 3)"
                 oninput="updateY()" onchange="updateY()">
        </div>
        <div class="form-group col-sm" style="text-align: center">
          <label> R</label>
          <select name="inputR" class="form-control" id="inputR"></select>
        </div>
      </div>
      <div style="text-align: center" class="disable-selection">
        <a href="javascript:void(0)" class="btn-submit sharp" style="border:1px solid #dddddd;" id="checkpoint">
          Check the point
        </a>
          <%--<a href="mypage" class="btn-submit sharp" style="border:1px solid #dddddd;" id="checkall">--%>
          <%--Check all graph</a>--%>
      </div>
    </form>
    <table class="table table-sm table-hover">
      <thead>
      <tr>
        <th scope="col" id="time">Execution time</th>
          <th scope="col">Result</th>
          <th scope="col">X</th>
          <th scope="col">Y</th>
          <th scope="col">R</th>
      </tr>
      </thead>
      <tbody id="results">
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
