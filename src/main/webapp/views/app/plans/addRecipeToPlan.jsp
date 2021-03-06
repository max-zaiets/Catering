<%--
  Created by IntelliJ IDEA.
  User: grzegorz
  Date: 26.02.2020
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="pl-PL">

<jsp:include page="../../../Templates/head.jsp">
    <jsp:param name="title" value="Dodaj Plan"/>
</jsp:include>


<body>
<jsp:include page="../../../Templates/header.jsp"></jsp:include>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="../../../Templates/NavBar.jsp"></jsp:include>


        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <form action="/app/recipe/plan/add" method="post">
                    <div class="row border-bottom border-3 p-1 m-1">
                        <div class="col noPadding">
                            <h3 class="color-header text-uppercase">DODAJ PRZEPIS DO PLANU</h3>
                        </div>
                        <div class="col d-flex justify-content-end mb-2 noPadding">
                            <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button>
                        </div>
                    </div>

                    <div class="schedules-content">

                        <div class="form-group row">
                            <label class="col-sm-2 label-size col-form-label">
                                Wybierz plan
                            </label>
                            <div class="col-sm-10">
                                <select name="planId">
                                    <c:forEach var="item" items="${allName}">
                                        <option value="${item.getId()}">${item.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mealName" class="col-sm-2 label-size col-form-label">
                                Nazwa posiłku
                            </label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="mealName" name="mealName"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="mealNumber" class="col-sm-2 label-size col-form-label">
                                Numer posiłku
                            </label>
                            <div class="col-sm-1">
                                <input type="text" class="form-control" id="mealNumber" name="mealNumber" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 label-size col-form-label">
                                Przepis
                            </label>
                            <div class="col-sm-10">
                                <select name="recipe_id">
                                    <c:forEach var="item" items="${recipe}">
                                        <option value="${item.id}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 label-size col-form-label">
                                Dzień
                            </label>
                            <div class="col-sm-10">
                                <select name="day">
                                    <c:forEach var="item" items="${day}">
                                        <option value="${item.id}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>