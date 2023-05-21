<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="forecast-table">
    <div class="container">
        <div class="forecast-container-day" style="margin-top: -50px;">

            <%!int i;%>

            <%
                for (i = 0; i < 24; i++) {
            %>

            <c:set var="i" value="<%=i%>" />

            <div class="forecast-day">

                <!-- .forecast-header -->
                <div class="forecast-content-day">
                    <div class="forecast-header">
                        <div class="day">${hours[i]}</div>
                    </div>
                    <div class="forecast-icon">
                        <c:choose>
                            <c:when test="${(hourly_prediction[i] == 'sunrise')}">
                                <img src="<c:url value="/resources/images/icons/icon-1.svg" />"
                                     alt="Wschód słońca" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'sun')}">
                                <img src="<c:url value="/resources/images/icons/icon-2.svg" />"
                                     alt="Pogodnie" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'sun_clouds')}">
                                <img src="<c:url value="/resources/images/icons/icon-3.svg" />"
                                     alt="Pogodnie, okresami wzrost zachmurzenia do umiarkowanego" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'sun_rain')}">
                                <img src="<c:url value="/resources/images/icons/icon-4.svg" />"
                                     alt="Zachmurzenie małe, możliwe słabe opady deszczu" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'cloud')}">
                                <img src="<c:url value="/resources/images/icons/icon-5.svg" />"
                                     alt="Zachmurzenie małe" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'clouds_full')}">
                                <img src="<c:url value="/resources/images/icons/icon-6.svg" />"
                                     alt="Zachmurzenie całkowite" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'fog')}">
                                <img src="<c:url value="/resources/images/icons/icon-7.svg" />"
                                     alt="Pochmurno oraz mgliście" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'tornado')}">
                                <img src="<c:url value="/resources/images/icons/icon-8.svg" />"
                                     alt="Trąba powietrzna" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'rain_small')}">
                                <img src="<c:url value="/resources/images/icons/icon-9.svg" />"
                                     alt="Zachmurzenie małe, możliwe słabe opady deszczu" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'rain')}">
                                <img src="<c:url value="/resources/images/icons/icon-10.svg" />"
                                     alt="Zachmurzenie całkowite, możliwe duże opady deszczu" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'rain_thunder')}">
                                <img src="<c:url value="/resources/images/icons/icon-11.svg" />"
                                     alt="Zachmurzenie całkowite, możliwa burza z piorunami" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'thunder')}">
                                <img src="<c:url value="/resources/images/icons/icon-12.svg" />"
                                     alt="Zachmurzenie z przebłyskami" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'snow_small')}">
                                <img src="<c:url value="/resources/images/icons/icon-13.svg" />"
                                     alt="Zachmurzenie, małe opady śniegu" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'snow')}">
                                <img src="<c:url value="/resources/images/icons/icon-14.svg" />"
                                     alt="Zachmurzenie, duże opady śniegu" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'moon')}">
                                <img src="<c:url value="/resources/images/icons/icon-15.svg" />"
                                     alt="Noc" width=48>
                            </c:when>
                            <c:when test="${(hourly_prediction[i] == 'cloud_moon')}">
                                <img src="<c:url value="/resources/images/icons/icon-16.svg" />"
                                     alt="Zachmurzenie, noc" width=48>
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value="/resources/images/icons/icon-2.svg" />"
                                     alt="Pogodnie" width=48>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="degree">
                        ${hourly_temperature[i]}<sup>o</sup>C
                    </div>
                    <br> <span><img
                        src="<c:url value="/resources/images/icon-wind.png" />" alt=""
                        style="float: left;">${hourly_wind[i]} km/h</span>
                </div>
            </div>

            <%
                }
            %>

        </div>
    </div>
</div>
