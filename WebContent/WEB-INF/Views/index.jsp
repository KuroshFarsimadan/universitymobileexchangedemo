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
    <title>Index</title>
    <link rel="stylesheet" href="resources/css/foundation.css" />
    <link rel="stylesheet" href="resources/css/app.css" />
	<!-- Javascript positioning just before the </body> ends -->
	<script src="resources/js/vendor/jquery.min.js"></script>
    <script src="resources/js/vendor/what-input.min.js"></script>
    <script src="resources/js/foundation.min.js"></script>
    <script src="resources/js/app.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
	<title>Index</title>
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

	
	<div class="panel panel-default">
	  <div class="panel-heading">
	    <h3 class="panel-title">Index</h3>
	  </div>
	  <div class="panel-body">
		More than 1.8bn mobile phones were bought in 2013, but within just a few years, 44% of 
		them could end up hibernating in drawers. Estimation is that the same share will be resold and 
		passed on, 4% will end up in landfills and only 3% will be recycled.<br></br>
		This site was created as a part of course project to tackle the issue at hand by providing 
		a set of reusable web services that provide the web service user/client to GET all the mobile phones,
		PUT (update mobile phone listing), DELETE mobile phones, or POST a new mobile phone with all the additional
		information regarding the location and price of the mobile phone. 
		<br></br>
		Also, this project uses REST or Representational State Transfer, which is an architectural style for
		designing distributed systems. REST is not a standard, but has a set of constraints like
		in the client or server side, stateless, uniform interface, and so on. 
		<br></br>
	  </div>
	</div>
   </body>
</html>


