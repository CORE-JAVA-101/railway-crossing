<%
String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<h1>Public Home Page</h1>
<div class="row">
    <a class="btn btn-primary" href="<%= baseUrl %>/public">Home</a>
    <a class="btn btn-primary" href="<%= baseUrl %>/public?type=favorite">Favorite</a>
    <a class="btn btn-primary">Search Crossing</a>
</div>