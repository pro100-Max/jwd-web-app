<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../subsidiary/language.jsp" %>

<html>
<head>
    <title><fmt:message key="user.confirmDelete.title"/></title>
    <style><%@include file="/WEB-INF/css/user-cabinet.css" %></style>
    <%@include file="../subsidiary/bootstrap.jsp" %>

</head>
<body>
<c:if test="${sessionScope.User == null}">
    ${sessionScope.isLogout = true}
    <c:redirect url="home?command=HOME_PAGE" />
</c:if>
<header>
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-between">
            <a href="home?command=USER_CABINET" class="navbar-brand d-flex align-items-center">
                <img class="mb-4" src="<c:url value="/img/mortarboard.png"/>" width="64" height="64">
                <strong><fmt:message key="user.name"/></strong>
            </a>
        </div>
        <%@include file="../subsidiary/form-select-language.jsp" %>
</header>
<section class="jumbotron text-center">
    <div class="container">
        <h1><fmt:message key="user.confirmDelete.question"/></h1>
        <p class="lead text-muted"><fmt:message key="user.confirmDelete.description"/></p>
        <p>
        <div class="form-signin">
            <form action="home?command=REMOVE_USER_BY_CLIENT" method="post">
                <label><input type="number" hidden name="id" value="${sessionScope.User.id}"></label>
                <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn_signin">
                    <fmt:message key="user.confirmDelete.yes"/></button>
            </form>
            <a href="home?command=USER_CABINET" style="text-decoration: none">
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        id="btn_signup"><fmt:message key="user.confirmDelete.no"/>
                </button>
            </a>
            <br>
        </div>
        </p>
    </div>
</section>
</body>
</html>