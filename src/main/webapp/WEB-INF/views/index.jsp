<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="pl">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0,maximum-scale=1">

	<title>PogoApp</title>

	<!-- Loading third party fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
		  rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/fonts/font-awesome.min.css" />" rel="stylesheet" type="text/css">


	<!-- Loading main css file -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/lightbox.css" />" rel="stylesheet">

</head>


<body>

<div class="site-content">
	<jsp:include page="modules/header.jsp" />

	<div class="hero" data-bg-image="<c:url value="/resources/images/banner.jpg" />">
		<div class="container">
			<form:form model-attribute="city" class="find-location" action="/weather" method="get">
				<form:input id="name" path="name" type="text" placeholder="Wpisz miejscowość"/>
				<input type="submit" id="btnAdd" value ="Szukaj"/>
			</form:form>
		</div>
	</div>

	<main class="main-content">

	<div class="container">
	
		<jsp:include page="modules/week.jsp" />

			<h2 class="hourly_forecast">Pogoda godzinowa dla: ${city}</h2>

		<jsp:include page="modules/day.jsp" />

		<jsp:include page="modules/news.jsp" />

		<jsp:include page="modules/interesting.jsp" />

	</main>
	<!-- .main-content -->

	<jsp:include page="modules/footer.jsp" />

	<!-- .site-footer -->
</div>

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/lightbox.js" />"></script>
<script src="<c:url value="/resources/js/plugins.js" />"></script>
<script src="<c:url value="/resources/js/app.js" />"></script>

</body>

</html>
