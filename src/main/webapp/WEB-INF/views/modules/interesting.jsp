<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="fullwidth-block">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2 class="section-title">Zalety PogoApp</h2>
				<ul class="arrow-feature">
					<li>
						<h3>Aktualne dane</h3>
						<p>Pokazujemy zawsze najnowsze, zaktualizowane dane, które są pobierane z róznych serwisów internetowych.</p>
					</li>
					<li>
						<h3>Nowoczesne technologie</h3>
						<p>Nasz projekt został napisany z użyciem takich technologii jak: Java, Spring MVC, JSP, HTML5, CSS, Javascript.</p>
					</li>
					<li>
						<h3>Nowoczesny design</h3>
						<p>Strona została zaprojektowana z użyciem najnowszych trendów webdesignu w technologii RWD.</p>
					</li>
				</ul>
			</div>
			<div class="col-md-4">
				<h2 class="section-title">Ciekawe linki</h2>
				<ul class="arrow-list">
					<li><a href="https://meteo.pl/">meteo.pl</a></li>
					<li><a href="http://lowcyburz.pl">Łowcy burz</a></li>
					<li><a href="http://www.lightningmaps.org/?lang=pl">Wyładowania na żywo</a></li>
					<li><a href="https://www.flightradar24.com">FlightRadar24</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<h2 class="section-title">Zdjęcia</h2>
				<div class="photo-grid">
					<a href="<c:url value="/resources/images/photos/1.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/1_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/2.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/2_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/3.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/3_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/4.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/4_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/5.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/5_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/6.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/6_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/7.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/7_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/8.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/8_thumb.jpg" />" alt="#"></a>
					<a href="<c:url value="/resources/images/photos/9.jpg" />" data-lightbox="weather"><img src="<c:url value="/resources/images/photos/9_thumb.jpg" />" alt="#"></a>
				</div>
			</div>
		</div>
	</div>
</div>