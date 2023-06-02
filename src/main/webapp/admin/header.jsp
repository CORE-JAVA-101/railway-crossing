<%
String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<h1>Admin Home Page</h1>
<div class="row">
    <a class="btn btn-primary" href="railway-crossing">Home</a>
    <a class="btn btn-primary" href="railwayCrossing.jsp">Add Railway Crossing</a>
    <a class="btn btn-primary">Search Crossing</a>
</div>