<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<jsp:include page="../../../Templates/head.jsp">
    <jsp:param name="title" value="Receipes"/>
</jsp:include>

<body>
<jsp:include page="../../../Templates/header.jsp"></jsp:include>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="../../../Templates/NavBar.jsp"></jsp:include>
        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="row border-bottom border-3 p-1 m-1">
                    <div class="col noPadding"><h3 class="color-header text-uppercase">Lista Przepisów</h3></div>
                </div>

                <div class="schedules-content">
                    <table class="table border-bottom">
                        <thead>

                        </thead>
                        <tbody class="text-color-lighter">
                        Czy na peno chcesz usunąć?

                        <a href="/app/plan/recipes/delete?id=${id}" class="btn btn-info rounded-0 text-light m-1">USUN</a>
                        <a href="/app/plan/details" class="btn btn-warning rounded-0 text-light m-1">ANULUJ</a>
                        </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</section>
<jsp:include page="../../../Templates/scripts.jsp"></jsp:include>
</body>
</html>
