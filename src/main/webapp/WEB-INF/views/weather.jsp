<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="pl">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1">

<title>PogoApp - Pogoda</title>

<!-- Loading third party fonts -->
<link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/fonts/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">


<!-- Loading main css file -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/lightbox.css" />"
	rel="stylesheet">

</head>


<body>

	<div class="site-content">
	    <jsp:include page="modules/header.jsp" />

		<div class="hero"
			data-bg-image="<c:url value="/resources/images/${banner_picture}" />">

		</div>


		<main class="main-content">
		<div class="fullwidth-block">
			<div class="container">
				<h2 class="section-title">Pogoda ${city}</h2>
			</div>
		</div>

		<div style="clear: both"></div>

		<jsp:include page="modules/week.jsp" />

		<jsp:include page="modules/day.jsp" />

		<jsp:include page="modules/news.jsp" /> <jsp:include
			page="modules/interesting.jsp" /> </main>
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

