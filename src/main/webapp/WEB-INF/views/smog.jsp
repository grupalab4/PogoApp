<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
    <jsp:include page="modules/header.jsp"/>

    <div class="hero" data-bg-image="<c:url value="/resources/images/banner2.jpg" />">
        <div class="container">
            <form class="find-location" action="/smog" method="get">
                <input name="name" type="text" placeholder="Wpisz miejscowość"/>
                <input type="submit" id="btnAdd" value="Szukaj"/>
            </form>
        </div>
    </div>


    <main class="main-content">
        <c:if test="${smog_data.size() == 0}">
            <div class="fullwidth-block container">
                <h2> Nie znaleziono żadnej stacji. </h2>
            </div>
        </c:if>
        <c:forEach items="${smog_data}" var="smog">
            <div class="fullwidth-block">
                <div class="container">
                    <h2 class="section-title">Stacja: ${smog.stationName}</h2>
                    <div class="container colored-rows">
                        <c:if test="${smog.so2IndexLevel != null}">
                            <div class="row p-1">
                                <p class="col-xs-6 col-sm-2">Dwutlenek siarki</p>
                                <p class="col-xs-6 col-sm-2">${smog.so2IndexLevel}</p>
                                <p class="col-sm-8 hidden-xs">
                                    Ekspozycja na dwutlenek siarki może prowadzić do podrażnienia gardła i oczu oraz
                                    zaostrzenia astmy, a także przewlekłego zapalenia oskrzeli.
                                </p>
                            </div>
                        </c:if>
                        <c:if test="${smog.no2IndexLevel != null}">
                            <div class="row">
                                <p class="col-xs-6 col-sm-2">Dwutlenek azotu</p>
                                <p class="col-xs-6 col-sm-2">${smog.no2IndexLevel}</p>
                                <p class="col-sm-8 hidden-xs">
                                    Wdychanie wysokich poziomów dwutlenku azotu zwiększa ryzyko wystąpienia problemów z
                                    oddychaniem. Kaszel i trudności w oddychaniu są częste, a po dłuższej ekspozycji
                                    mogą wystąpić poważniejsze problemy zdrowotne, np. infekcje dróg oddechowych.
                                </p>
                            </div>
                        </c:if>
                        <c:if test="${smog.o3IndexLevel != null}">
                            <div class="row">
                                <p class="col-xs-6 col-sm-2">Ozon</p>
                                <p class="col-xs-6 col-sm-2">${smog.o3IndexLevel}</p>
                                <p class="col-sm-8 hidden-xs">
                                    Ozon przygruntowy może nasilać objawy chorób układu oddechowego, a także prowadzić
                                    do podrażnień gardła oraz bólów głowy i klatki piersiowej.
                                </p>
                            </div>
                        </c:if>
                        <c:if test="${smog.pm10IndexLevel != null}">
                            <div class="row">
                                <p class="col-xs-6 col-sm-2">Cząstki PM<sub>10</sub></p>
                                <p class="col-xs-6 col-sm-2">${smog.pm10IndexLevel}</p>
                                <p class="col-sm-8 hidden-xs">
                                    Cząstki stałe to wdychane zanieczyszczenia o średnicy mniejszej niż 10 mikrometrów.
                                    Cząstki o średnicy przekraczającej 2,5 mikrometra mogą zalegać w drogach
                                    oddechowych, powodując problemy ze zdrowiem.
                                </p>
                            </div>
                        </c:if>
                        <c:if test="${smog.pm25IndexLevel != null}">
                            <div class="row">
                                <p class="col-xs-6 col-sm-2">Cząstki PM<sub>2,5</sub></p>
                                <p class="col-xs-6 col-sm-2">${smog.pm25IndexLevel}</p>
                                <p class="col-sm-8 hidden-xs">
                                    Drobne cząstki stałe to wdychane zanieczyszczenia o średnicy mniejszej niż 2,5
                                    mikrometra, które mogą dostać się do płuc i krwioobiegu, powodując poważne problemy
                                    zdrowotne.
                                </p>
                            </div>
                        </c:if>
                    </div>
                    <h3>${station.stCalcDate.toString()}</h3>
                </div>
            </div>
        </c:forEach>

        <jsp:include page="modules/news.jsp"/>

        <jsp:include page="modules/interesting.jsp"/>

    </main>
    <!-- .main-content -->

    <jsp:include page="modules/footer.jsp"/>

    <!-- .site-footer -->
</div>

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/lightbox.js" />"></script>
<script src="<c:url value="/resources/js/plugins.js" />"></script>
<script src="<c:url value="/resources/js/app.js" />"></script>

</body>

</html>
