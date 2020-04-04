<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pl">

<jsp:include page="../../../Templates/head.jsp"></jsp:include>

<body>
<jsp:include page="../../../Templates/header.jsp"></jsp:include>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="../../../Templates/NavBar.jsp"></jsp:include>
        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="mt-4 ml-4 mr-4">
                    <form action="/app/plan/edit" method="POST">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Edycja planu</h3></div>
                            <div class="col d-flex justify-content-end mb-2"><button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz</button></div>
                        </div>
                        <input type="hidden" name="id" value="${plan.getId()}">
                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Nazwa planu</th>
                                <td class="col-7">
                                    <input class="w-100 p-1" name="name" value="${plan.getName()}">
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2">Opis planu</th>
                                <td class="col-7"> <textarea class="w-100 p-1" rows="5" name="description">${plan.getDescription()}</textarea></td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>

            </div>
        </div>
    </div>
</section>

<jsp:include page="../../../Templates/scripts.jsp"></jsp:include>
</body>
</html>
