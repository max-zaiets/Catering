<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pl-PL">

<jsp:include page="../Templates/head.jsp">
    <jsp:param name="title" value="Logowanie"/>
</jsp:include>

<body>
<jsp:include page="../Templates/header.jsp"></jsp:include>

    <section class="dashboard-section">
        <div class="container pt-4 pb-4">
            <div class="border-dashed view-height">
                <div class="container w-25">
                    <form action="/login" method="POST" class="padding-small text-center">
                        <h1 class="text-color-darker">Logowanie</h1>
                        <div class="form-group">
                            <input type="text" class="form-control" id="email" name="email" placeholder="podaj adres email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło">
                        </div>
                        <p> ${requestScope.message}</p>
                        <button class="btn btn-color rounded-0" type="submit">Zaloguj</button>
                    </form>
                 </div>
            </div>
        </div>
    </section>

<jsp:include page="../Templates/scripts.jsp"></jsp:include>
</body>
</html>