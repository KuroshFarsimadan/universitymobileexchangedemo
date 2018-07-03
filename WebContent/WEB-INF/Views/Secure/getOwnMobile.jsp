<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title> Own Mobiles</title>
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
<h3>Own sellable mobiles</h3>

<h3>Welcome: <sec:authentication property="principal.username"/></h3>
<div class="panel panel-default">
  <div class="panel-heading">
  	<sec:authorize access="hasRole('ROLE_USER')">
	    <ul class="nav nav-tabs">
		  <li role="presentation"><a href="userPanel">User Panel</a></li>
		  <li role="presentation"><a href="userProfile">User Profile</a></li>
		  <li role="presentation"><a href="createMobile">Create a mobile</a></li> 
		  <li role="presentation"><a href="getAllMobile">Get all mobiles</a></li>
		  <li role="presentation" class="active"><a href="getPersonMobile">My sellable mobiles</a></li>
		  <!--  <li role="presentation"><a href="updateMobiles">Update mobiles</a></li>-->
		</ul>
   	</sec:authorize> 

  </div>
  <div class="panel-body">
	  	<table>
	        <thead>
		    	<tr>
		    		<th width="150">Row ID</th>
					<th width="150">Person ID</th>
			        <th width="600">Mobile manufacturer</th>
					<th width="400">Mobile model</th>
					<th width="600">Mobile specifications</th>
					<th width="600">Free description</th>
					<th width="600">Price</th>
					<th width="600">Action</th>
		    	</tr>
	        </thead>	  	
	        <tbody>
	        <c:forEach items="${mobileList}" var="mobiles">
		 		<tr>
		 		<form:form action="updateMobiles" method="POST" modelAttribute="mobile">
			        <td width="150"><form:input aria-describedby="basic-addon1" class="form-control" path="RowId" value="${mobiles.rowId}" readonly="readonly"/></td>
			        <td width="150"><form:input aria-describedby="basic-addon1" class="form-control" path="PersonId" value="${mobiles.personId}" readonly="readonly"/></td>
			        <td width="600"><form:input aria-describedby="basic-addon1" class="form-control" path="MobileManufacturer" value="${mobiles.mobileManufacturer}"/></td>
			        <td width="400"><form:input aria-describedby="basic-addon1" class="form-control" path="MobileModel" value="${mobiles.mobileModel}"/></td>
			        <td width="600"><form:input aria-describedby="basic-addon1" class="form-control" path="MobileSpecs" value="${mobiles.mobileSpecs}"/></td>
			        <td width="600"><form:input aria-describedby="basic-addon1" class="form-control" path="MobileFreedescription" value="${mobiles.mobileFreedescription}"/></td>
			        <td width="600"><form:input aria-describedby="basic-addon1" class="form-control" path="Price" value="${mobiles.price}"/></td>
			   		<td width="600"><input type="submit" name="submitButtons" value="Update" class="btn btn-success"/><input type="submit" value="Delete" name="submitButtons" class="btn btn-danger"/></td> 
			   	</form:form>
			    <!-- <input type="button"  onclick="location.href='updateMobiles/${mobiles.rowId}'" value="Update" >-->
		        </tr>
		     </c:forEach>
			</tbody>
		</table>

  </div>
  <div class="panel-footer">
	 
		<center>CT30A8903_11.01.2016 Software Systems as a Service: Technology and Engineering</center>	
  </div>
</div>
   
  
</body>
</html>