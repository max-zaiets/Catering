<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../../Templates/head.jsp">
    <jsp:param name="title" value="Zmiana hasła"/>
</jsp:include>

<body>
<jsp:include page="../../../Templates/header.jsp"></jsp:include>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <jsp:include page="../../../Templates/NavBar.jsp"></jsp:include>

        <div class="m-4 p-3 width-medium text-color-darker">
            <div class="m-4 border-dashed view-height">
                <div class="mt-4 ml-4 mr-4">
                    <!-- fix action, method -->
                    <!-- add name attribute for all inputs -->
                    <form action="/app/edit/password" method="POST">
                        <div class="row border-bottom border-3">
                            <div class="col"><h3 class="color-header text-uppercase">Zmień hasło</h3></div>
                            <div class="col d-flex justify-content-end mb-2">
                                <button type="submit" class="btn btn-color rounded-0 pt-0 pb-0 pr-4 pl-4">Zapisz
                                </button>
                            </div>
                        </div>

                        <table class="table borderless">
                            <tbody>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Nowe hasło</h4></th>
                                <td class="col-7">
                                    <input type="password" class="w-100 p-1" name="newPassword" value="">
                                </td>
                            </tr>
                            <tr class="d-flex">
                                <th scope="row" class="col-2"><h4>Powtórz hasło</h4></th>
                                <td class="col-7">
                                    <input type="password" class="w-100 p-1" name="repeatPassword" value="">
                                </td>
                            </tr>
                            <p>${requestScope.message}</p>
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