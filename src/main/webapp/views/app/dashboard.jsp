<%@ page import="pl.coderslab.web.HomeServlet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl-PL">

<jsp:include page="../../Templates/head.jsp">
    <jsp:param name="title" value="Dashboard"/>
</jsp:include>

<body>
<jsp:include page="../../Templates/header.jsp"></jsp:include>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="../../Templates/NavBar.jsp"></jsp:include>

        <div class="m-4 p-4 width-medium">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <a href="/app/recipe/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj przepis</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj plan</span>
                        </a>
                    </div>
                    <div class="menu-item border-dashed">
                        <a href="/app/recipe/plan/add">
                            <i class="far fa-plus-square icon-plus-square"></i>
                            <span class="title">dodaj przepis do planu</span>
                        </a>
                    </div>
                </div>

                <div class="dashboard-alerts">
                    <div class="alert-item alert-info">
                        <i class="fas icon-circle fa-info-circle"></i>
                        <span class="font-weight-bold">Liczba przepisów: ${requestScope.countRecipe}</span>
                    </div>
                    <div class="alert-item alert-light">
                        <i class="far icon-calendar fa-calendar-alt"></i>
                        <span class="font-weight-bold">Liczba planów: ${requestScope.countPlans}</span>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>Ostatnio dodany plan:</span> Plan jak u mamy
                </h2>

                <table class="table">


                    
                    <thead>
                    <tr class="d-flex">
                        <th class="col-2">${day_name}</th>
                        <th class="col-8"></th>
                        <th class="col-2"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="d-flex">
                        <td class="col-2">${meal_name}</td>
                        <td class="col-8">${recipe_name}</td>
                        <td class="col-2"><button type="button" class="btn btn-primary rounded-0">Szczegóły</button></td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</section>
<jsp:include page="../../Templates/scripts.jsp"></jsp:include>

</body>
</html>
