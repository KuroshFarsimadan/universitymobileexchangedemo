<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../resources/css/foundation.css" />
    <link rel="stylesheet" href="../resources/css/app.css" />
	<!-- Javascript positioning just before the </body> ends -->
	<script src="../resources/js/vendor/jquery.min.js"></script>
    <script src="../resources/js/vendor/what-input.min.js"></script>
    <script src="../resources/js/foundation.min.js"></script>
    <script src="../resources/js/app.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <title>Get all mobile</title>
  </head>
  <body>
	<header>
		<div class="top-bar">
		  <div class="top-bar-left">
			<ul class="dropdown menu" data-dropdown-menu>
			  <li class="menu-text"><div id="whiteText">MobileTraders Inc.</div></li>
			  <li class="has-submenu">
			  <li><a href="index"><div id="whiteText">Home</div></a></li>
			  <li><a href="about"><div id="whiteText">About</div></a></li>
			  <!--  <li><a href="register"><div id="whiteText">Register</div></a></li>-->
			</ul>
		  </div>
		  <div class="top-bar-right">
			<ul class="menu">
		     	<sec:authorize access="hasRole('ROLE_USER')">
			  		<li><a href="<c:url value="../j_spring_security_logout"/>"><button type="button" class="button">Logout</button></a></li>
			    </sec:authorize>
			    <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
			    	<li><a href="login"><button type="button" class="button">Login</button></a></li>	
			    </sec:authorize> 
			</ul>
		  </div>
		</div>
	</header>
<h3>All of the mobiles</h3>

<h3>Welcome: <sec:authentication property="principal.username"/></h3>


<div class="panel panel-default">
  <div class="panel-heading">
  	<sec:authorize access="hasRole('ROLE_USER')">
	    <ul class="nav nav-tabs">
		  <li role="presentation"><a href="userPanel">User Panel</a></li>
		  <li role="presentation"><a href="userProfile">User Profile</a></li>
		  <li role="presentation"><a href="createMobile">Create a mobile</a></li> 
		  <li role="presentation" class="active"><a href="getAllMobile">Get all mobiles</a></li>
		</ul>
   	</sec:authorize> 

  </div>
  <div class="panel-body">

	  	<table>
	        <thead>
		    	<tr>
					<th width="150">Person ID</th>
			        <th width="150">Row ID</th>
			        <th width="600">Mobile manufacturer</th>
					<th width="400">Mobile model</th>
					<th width="600">Mobile specifications</th>
					<th width="600">Free description</th>
		    	</tr>
	        </thead>	  	
	        <tbody>
	        <c:forEach items="${mobileList}" var="mobiles">
		 		<tr>
			        <td width="150"><c:out value="${mobiles.personId}"/></td>
			        <td width="150"><c:out value="${mobiles.rowId}"/></td>
			        <td width="600"><c:out value="${mobiles.mobileManufacturer}"/></td>
			        <td width="400"><c:out value="${mobiles.mobileModel}"/></td>
			        <td width="600"><c:out value="${mobiles.mobileSpecs}"/></td>
			        <td width="600"><c:out value="${mobiles.mobileFreedescription}"/></td>
		        </tr>
		    </c:forEach>
			</tbody>
		</table>

  </div>
  <div class="panel-footer">
	 
	Footer	
  </div>
</div>  
  
</body>
</html>