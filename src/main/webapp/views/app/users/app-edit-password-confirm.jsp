<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../../Templates/head.jsp">
    <jsp:param name="title" value="Dodaj Plan"/>
</jsp:include>

<body>
<jsp:include page="/Templates/header.jsp"></jsp:include>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="../../../Templates/NavBar.jsp"></jsp:include>

        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <div class="schedules-content">
                    ${requestScope.message}
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="/Templates/scripts.jsp"></jsp:include>
</body>
</html>