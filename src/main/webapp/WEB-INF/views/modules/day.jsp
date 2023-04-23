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
                        <div class="day">${"24:00"}</div>
                    </div>
                    <div class="forecast-icon">
                        <c:if
                                test="${fn:contains(hourly_prediction[i], 'Zachmurzenie całkowite')}">
                            <img src="<c:url value="/resources/images/icons/icon-6.svg" />"
                                 alt="Zachmurzenie całkowite" width=48>
                        </c:if>
                        <c:if
                                test="${fn:contains(hourly_prediction[i], 'Pochmurno, słabe opady deszczu')}">
                            <img src="<c:url value="/resources/images/icons/icon-4.svg" />"
                                 alt="Pochmurno, słabe opady deszczu" width=48>
                        </c:if>

                        <c:choose>
                            <c:when test="${fn:contains(hourly_prediction[i], 'Pogodnie')}">

                                <c:choose>
                                    <c:when
                                            test="${fn:contains(hourly_prediction[i], 'Pogodnie, okresami wzrost zachmurzenia do umiarkowanego')}">

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
                                test="${fn:contains(hourly_prediction[i], 'Zachmurzenie małe, możliwe słabe opady deszczu')}">
                            <img src="<c:url value="/resources/images/icons/icon-4.svg" />"
                                 alt="Zachmurzenie małe, możliwe słabe opady deszczu" width=48>
                        </c:if>
                        <c:if
                                test="${fn:contains(hourly_prediction[i], 'Pochmurno z przejaśnieniami, słabe opady deszczu')}">
                            <img src="<c:url value="/resources/images/icons/icon-4.svg" />"
                                 alt="Pochmurno z przejaśnieniami, słabe opady deszczu" width=48>
                        </c:if>
                        <c:if
                                test="${fn:contains(hourly_prediction[i], 'Pochmurno, okresami przejaśnienia')}">
                            <img src="<c:url value="/resources/images/icons/icon-3.svg" />"
                                 alt="Pochmurno, okresami przejaśnienia" width=48>
                        </c:if>

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
