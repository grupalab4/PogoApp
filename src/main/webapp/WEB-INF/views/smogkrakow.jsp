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

<title>PogoApp - Smog w mieście</title>

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
		<div class="site-header">
			<div class="container">
				<a href="<c:url value="/" />" class="branding"> <img
					src="<c:url value="/resources/images/logo.png" />" alt="" class="logo">
					<div class="logo-type">
						<h1 class="site-title">PogoApp</h1>
						<small class="site-description">...</small>
					</div>
				</a>

				<!-- Default snippet for navigation -->
				<div class="main-navigation">
					<button type="button" class="menu-toggle">
						<i class="fa fa-bars"></i>
					</button>
					<ul class="menu">
						<li class="menu-item"><a href="<c:url value="/" />">Strona główna</a></li>
						<li class="menu-item"><a href="<c:url value="/peaks" />">Szczyty</a></li>
						<li class="menu-item"><a href="<c:url value="/weekendWeather"/>">Pogoda na weekend</a></li>
						<li class="menu-item current-menu-item"><a href="<c:url value="/smogkrakow" />">Smog w mieście</a></li>
						<li class="menu-item"><a href="<c:url value="/authors" />">Autorzy</a></li>
					</ul>
					<!-- .menu -->
				</div>
				<!-- .main-navigation -->

				<div class="mobile-navigation"></div>

			</div>
		</div>
		<!-- .site-header -->
		
		<div class="hero" data-bg-image="<c:url value="/resources/images/banner2.jpg" />">

		</div>

		
		<main class="main-content">
		<div class="fullwidth-block">
			<div class="container">
				<h2 class="section-title">Smog w Krakowie</h2>
					<div class="col-12">
						Al. Krasinskiego ${Sensor1} g/m3<br>  
						ul. Bulwarowa ${Sensor2} g/m3<br>
						ul. Bujaka ${Sensor3} g/m3<br>				      
						ul. Dietla ${Sensor4} g/m3<br>
						os. Piastow ${Sensor5} g/m3<br>
						ul. Zloty Rog ${Sensor6} g/m3<br><br>
						
						Obowiązująca norma dobowa to maksymalnie 50 µg/m3, i nie może być przekraczana częściej niż przez 35 dni w roku.
						      
					</div>
			</div>
		</div>

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
