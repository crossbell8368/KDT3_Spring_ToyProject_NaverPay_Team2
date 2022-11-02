<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.example.overview.utils.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>JSP</title>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <jsp:include page="../../layout/header.jsp"/>
</header>

<%@include file="../../messages/showMessage.jsp"%>
<%
    showMessage(request, response, "survey", Status.FAIL);
%>

<main>
    <h1>SURVEY</h1>
    <div>Hello! ${uId}</div>
    <div>Please complete the survey below 👇🏻</div>
    <div>
        <form method="post" action="/members/survey/res/${uId}">
            <fieldset>
                <legend>1. Favorite Season ?</legend>

                <div>
                    <input type="radio" name="season" value="spring" checked>
                    <label>spring 🍀</label>
                </div>
                <div>
                    <input type="radio" name="season" value="summer">
                    <label>summer 🌊</label>
                </div>

                <div>
                    <input type="radio" name="season" value="autumn">
                    <label>autumn 🍂</label>
                </div>

                <div>
                    <input type="radio" name="season" value="winter">
                    <label>winter ❄️</label>
                </div>
            </fieldset>

            <fieldset>
                <legend>2. Favorite Fruit ?</legend>

                <div>
                    <input type="radio" name="fruit" value="watermelon" checked>
                    <label>watermelon 🍉</label>
                </div>

                <div>
                    <input type="radio" name="fruit" value="melon">
                    <label>melon 🍈</label>
                </div>

                <div>
                    <input type="radio" name="fruit" value="apple">
                    <label>apple 🍎</label>
                </div>

                <div>
                    <input type="radio" name="fruit" value="orange">
                    <label>orange 🍊</label>
                </div>
            </fieldset>
            <div>
                <input type="submit" value="result">
            </div>
        </form>
    </div>
</main>

<footer class="main__nav__next">
    <jsp:include page="../../layout/footer.jsp"/>
</footer>
</body>
</html>
