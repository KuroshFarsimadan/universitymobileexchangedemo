<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html class="no-js" lang="en">
  <head>
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="resources/css/foundation.css" />
    <link rel="stylesheet" href="resources/css/app.css" />
	<!-- Javascript positioning just before the </body> ends -->
	<script src="resources/js/vendor/jquery.min.js"></script>
    <script src="resources/js/vendor/what-input.min.js"></script>
    <script src="resources/js/foundation.min.js"></script>
    <script src="resources/js/app.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Login</title>
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
			  <!--<li><input type="search" placeholder="Search"></li>-->
			  <li><a href="login"><button type="button" class="button">Login</button></a></li>
			</ul>
		  </div>
		</div>
	</header>



<center>
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Login</h3>
	  </div>
	  <div class="panel-body">
	<c:if test="${not empty loginerror}">
		<p class="Error">Failed sign in. Username or password was wrong.</p>
	</c:if>

	<c:if test="${not empty loggedout}">
		<p class="Info">Logout successful</p>
	</c:if>
	
	<form action="j_spring_security_check" method="post">
	<fieldset>
		<table>
		<tr><td>USERNAME:</td><td><div class="input-group"><input type="text" class="form-control" name='j_username' value='' aria-describedby="basic-addon1"></div></td></tr>
		<tr><td>PASSWORD:</td><td><input class="form-control" type='password' name='j_password' aria-describedby="basic-addon1"/></td></tr>
		<tr><td>&nbsp;</td><td><input type="submit" name="submitButtons" value="Sign in" class="btn btn-success"/></td></tr>
		</table>
	</fieldset>
	</form>
	  </div>
	</div>

</center>	
	
	
	

  </body>
</html>
