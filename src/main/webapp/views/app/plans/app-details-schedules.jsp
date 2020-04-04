<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../../Templates/head.jsp">
    <jsp:param name="title" value="Dodaj Plan"/>
</jsp:include>


<body>
<jsp:include page="../../../Templates/header.jsp"></jsp:include>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="../../../Templates/NavBar.jsp"></jsp:include>

        <div class="m-4 p-3 width-medium ">
            <div class="dashboard-content border-dashed p-3 m-4">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding">
                        <h3 class="color-header text-uppercase">SZCZEGÓŁY PLANU</h3>
                    </div>
                    <div class="col d-flex justify-content-end mb-2 noPadding">
                        <a href="/app/plan/list" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Powrót</a>
                    </div>
                </div>
                <input type="hidden" name="id" value="${plan.getId()}">
                <div class="schedules-content">
                    <div class="schedules-content-header">
                        <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Nazwa planu
                                </span>
                            <div class="col-sm-10">
                                <p class="schedules-text">${planName}</p>
                            </div>
                        </div>
                        <div class="form-group row">
                                <span class="col-sm-2 label-size col-form-label">
                                    Opis planu
                                </span>
                            <div class="col-sm-10">
                                <p class="schedules-text">
                                    ${description}
                            </div>
                        </div>
                    </div>

                    <table class="table">
                        <c:forEach items="${planDetails}" var="planDetails">
                            <thead>
                            <tr class="d-flex">
                                <th class="col-2">
                                        ${planDetails.day_name}
                                </th>
                                <th class="col-7"></th>
                                <th class="col-1"></th>
                                <th class="col-2"></th>
                            </tr>
                            </thead>
                            <tbody class="text-color-lighter">

                            <tr class="d-flex">

                                <td class="col-2">${planDetails.meal_name}</td>
                                <td class="col-7">${planDetails.recipe_name}</td>
                                <td class="col-1 center">
                                    <a href="/app/plan/details/confirm?id=${planDetails.recipe_id}" class="btn btn-danger rounded-0 text-light m-1">Usuń</a>
                                </td>
                                <td class="col-2 center">

                                    <a href="/app/recipe/details?id=${planDetails.recipe_id}"
                                       class="btn btn-info rounded-0 text-light m-1">Szczegóły</a>
                                </td>
                            </tr>
                            </th>
                            </tbody>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../../../Templates/scripts.jsp"></jsp:include>
</body>
</html>