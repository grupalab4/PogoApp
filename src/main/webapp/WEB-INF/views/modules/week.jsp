<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

		<div class="forecast-table">
			<div class="container">
				<div class="forecast-container" style="margin-top: -50px;">
					<div class="today forecast">
						<div class="forecast-header">
							<div class="day">${dayOfWeek[0]}</div>
							<div class="date">${calendar[0]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="location">${city}</div>
							<div class="degree">
								<div class="num">
									${temperature[0]}<sup>o</sup>C
								</div>
								<div class="forecast-icon">
									<c:if
									test="${fn:contains(prediction[0], 'Zachmurzenie całkowite')}">
									<img src="<c:url value="/resources/images/icons/icon-6.svg" />"
										alt="" width=90>
								    </c:if>
								    <c:if
								    	test="${fn:contains(prediction[0], 'Pochmurno, słabe opady deszczu')}">
								    	<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
								    		alt="" width=90>
								    </c:if>

								    <c:choose>
								    	<c:when test="${fn:contains(prediction[0], 'Pogodnie')}">

								    		<c:choose>
								    			<c:when
								    				test="${fn:contains(prediction[0], 'Pogodnie, okresami wzrost zachmurzenia do umiarkowanego')}">

								    				<img
								    					src="<c:url value="/resources/images/icons/icon-3.svg" />"
								    					alt="" width=90>
								    			</c:when>
								    			<c:otherwise>

								    				<img
								    					src="<c:url value="/resources/images/icons/icon-2.svg" />"
								    					alt="" width=90>

								    			</c:otherwise>

								    		</c:choose>

								    	</c:when>

								    </c:choose>


								    <c:if
								    	test="${fn:contains(prediction[0], 'Zachmurzenie małe, możliwe słabe opady deszczu')}">
								    	<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
								    		alt="" width=90>
								    </c:if>
								    <c:if
								    	test="${fn:contains(prediction[0], 'Pochmurno z przejaśnieniami, słabe opady deszczu')}">
								    	<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
								    		alt="" width=90>
								    </c:if>
								    <c:if
								    	test="${fn:contains(prediction[0], 'Pochmurno, okresami przejaśnienia')}">
								    	<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
								    		alt="" width=90>
								    </c:if>
								</div>
							</div>
							<span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt="">${wind[0]}</span>
							<span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="">${pressure[0]}</span>
						</div>
					</div>

					<%!int i;%>

					<%
						for (i = 1; i <= 6; i++) {
					%>

					<c:set var="i" value="<%=i%>" />

					<div class="forecast">
						<div class="forecast-header">
							<div class="day">${dayOfWeek[i]}</div>
						</div>
						<!-- .forecast-header -->
						<div class="forecast-content">
							<div class="forecast-icon">
								<c:if
									test="${fn:contains(prediction[i], 'Zachmurzenie całkowite')}">
									<img src="<c:url value="/resources/images/icons/icon-6.svg" />"
										alt="Zachmurzenie całkowite" width=48>
								</c:if>
								<c:if
									test="${fn:contains(prediction[i], 'Pochmurno, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="Pochmurno, słabe opady deszczu" width=48>
								</c:if>

								<c:choose>
									<c:when test="${fn:contains(prediction[i], 'Pogodnie')}">

										<c:choose>
											<c:when
												test="${fn:contains(prediction[i], 'Pogodnie, okresami wzrost zachmurzenia do umiarkowanego')}">

												<img
													src="<c:url value="/resources/images/icons/icon-3.svg" />"
													alt="Pogodnie, okresami wzrost zachmurzenia do umiarkowanego" width=48>
											</c:when>
											<c:otherwise>

												<img
													src="<c:url value="/resources/images/icons/icon-2.svg" />"
													alt="Pogodnie" width=48>

											</c:otherwise>

										</c:choose>

									</c:when>

								</c:choose>


								<c:if
									test="${fn:contains(prediction[i], 'Zachmurzenie małe, możliwe słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="Zachmurzenie małe, możliwe słabe opady deszczu" width=48>
								</c:if>
								<c:if
									test="${fn:contains(prediction[i], 'Pochmurno z przejaśnieniami, słabe opady deszczu')}">
									<img src="<c:url value="/resources/images/icons/icon-4.svg" />"
										alt="Pochmurno z przejaśnieniami, słabe opady deszczu" width=48>
								</c:if>
								<c:if
									test="${fn:contains(prediction[i], 'Pochmurno, okresami przejaśnienia')}">
									<img src="<c:url value="/resources/images/icons/icon-3.svg" />"
										alt="Pochmurno, okresami przejaśnienia" width=48>
								</c:if>

							</div>
							<div class="degree">
								${temperature[i]}<sup>o</sup>C
							</div>
							<br> <span><img
								src="<c:url value="/resources/images/icon-wind.png" />" alt=""
								style="float: left;">${wind[i]} km/h</span> <br> <span><img
								src="<c:url value="/resources/images/icon-compass.png" />"
								alt="" style="float: left;">${pressure[i]} hPa</span>
						</div>
					</div>

					<%
						}
					%>

				</div>
			</div>
		</div>
