<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true" %>

<c:choose>
    <c:when test="${empty sessionScope.adminId}">
        <header class="page-header">
            <nav class="navbar navbar-expand-lg justify-content-around">
                <a href="/" class="navbar-brand main-logo">
                    Zaplanuj <span>Jedzonko</span>
                </a>
                <ul class="nav nounderline text-uppercase">
                    <li class="nav-item ml-4">
                        <a class="nav-link color-header" href="/login">logowanie</a>
                    </li>
                    <li class="nav-item ml-4">
                        <a class="nav-link color-header" href="/register">rejestracja</a>
                    </li>
                    <li class="nav-item ml-4">
                        <a class="nav-link" href="/about">o aplikacji</a>
                    </li>
                    <li class="nav-item ml-4">
                        <a class="nav-link disabled" href="/recipes/list">Przepisy</a>
                    </li>
                    <li class="nav-item ml-4">
                        <a class="nav-link disabled" href="/contact">Kontakt</a>
                    </li>
                </ul>
            </nav>
        </header>
    </c:when>
    <c:otherwise>
        <header class="page-header">
            <nav class="navbar navbar-expand-lg justify-content-between">
                <a href="/" class="navbar-brand main-logo main-logo-smaller">
                    Zaplanuj <span>Jedzonko</span>
                </a>
                <div class="d-flex justify-content-around">
                    <a class="nav-link disabled" href="/app/dashboard">Pulpit</a>
                    <h4 class="text-light mr-3">${sessionScope.adminFirstName}</h4>
                    <div class="circle-div text-center"><i class="fas fa-user icon-user"></i></div>
                </div>
            </nav>
        </header>
    </c:otherwise>
</c:choose>