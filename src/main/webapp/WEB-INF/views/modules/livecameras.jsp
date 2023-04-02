<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="fullwidth-block">
	<div class="container">
		<h2 class="section-title">Kamery na żywo</h2>
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="live-camera">
					<figure class="live-camera-cover">
						<a href="http://krakow4.webcamera.pl">
							<img src="<c:url value="/resources/images/camera-krakow.jpg" />" alt="">
						</a>
					</figure>
					<h3 class="location">Kraków</h3>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="live-camera">
					<figure class="live-camera-cover">
						<a href="http://krupowkidolne.webcamera.pl">
							<img src="<c:url value="/resources/images/camera-zakopane.jpg" />" alt="">
						</a>
					</figure>
					<h3 class="location">Krupówki</h3>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="live-camera">
					<figure class="live-camera-cover">
						<a href="http://wadowice.webcamera.pl">
							<img src="<c:url value="/resources/images/camera-wadowice.jpg" />" alt="">
						</a>
					</figure>
					<h3 class="location">Wadowice</h3>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="live-camera">
					<figure class="live-camera-cover">
						<a href="https://www.worldcam.pl/liveview/4313">
							<img src="<c:url value="/resources/images/camera-warszawa.jpg" />" alt="">
						</a>
					</figure>
					<h3 class="location">Warszawa</h3>
				</div>
			</div>
		</div>
	</div>
</div>