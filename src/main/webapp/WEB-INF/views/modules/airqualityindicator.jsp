<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:choose>
    <c:when test="${param.quality == 'Bardzo dobry'}">
        <p class="air-great"> Bardzo dobry </p>
    </c:when>
    <c:when test="${param.quality == 'Dobry'}">
        <p class="air-good"> Dobry </p>
    </c:when>
    <c:when test="${param.quality == 'Akceptowalny'}">
        <p class="air-acceptable"> Akceptowalny </p>
    </c:when>
    <c:when test="${param.quality == 'Szkodliwy'}">
        <p class="air-harmful"> Szkodliwy </p>
    </c:when>
    <c:when test="${param.quality == 'Niebezpieczny'}">
        <p class="air-dangerous"> Niebezpieczny </p>
    </c:when>
</c:choose>