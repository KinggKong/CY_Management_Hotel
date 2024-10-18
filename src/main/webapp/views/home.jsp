<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body style="margin: 0;padding: 0; width: 100%">
<%@ include file="include/_navbar.jsp" %>

<div id="main_container">
    <div class="imageHeader"
         style="width: 100%; height: 600px; background-image: url('https://www.cleopatraluxuryhotels.com/wp-content/uploads/sites/55/2023/11/Cleopatra-Luxury-Resort-Sharm-Adults-Only.jpg'); display: flex; justify-content: center; align-items: center;">
        <div class="search" style="display: flex; flex-direction: column; align-items: center; text-align: center;">
            <h1 style="color: white;">Experience The Difference</h1>
            <p style="color: white; font-size: 1rem;">Plan.Book.Travel</p>
            <div class="form"
                  style="display: flex; align-items: center; justify-content: center; gap: 10px; margin-top: 10px;">
                <select id="locationSearch" name="locationSearch" style="padding: 10px 20px; border-radius: 10px; width: 200px;">
                    <option value=""></option>
                    <c:forEach items="${provinces}" var="item">
                        <option value="${item.id}">${item.name}</option>
                    </c:forEach>
                </select>
                <input id="dateSearch" type="date" name="date" style="padding: 10px 20px; border-radius: 10px; width: 200px;">
                <input onclick="searchRooms(1)" type="submit" style="padding: 10px 20px; border-radius: 10px; width: 200px;" value="Search">
            </div>
        </div>
    </div>


    <div class="joinNow" style="display: flex;justify-content: center;align-items: center;flex: 1;gap: 290px;">
        <div style="line-height: 1rem;">
            <h3>Become a Member</h3>
            <p>Exclusive offers, rate and locations</p>
            <button style="background-color: black; border-radius: 10px; padding: 5px 10px;color: white">Join Now
            </button>
        </div>
        <div>
            <img src="https://static.vecteezy.com/system/resources/previews/003/133/633/non_2x/team-and-group-member-vector.jpg"
                 style="width: 300px;height: auto;">
        </div>
    </div>
    <hr>

    <%@ include file="include/_carousel.jsp" %>

    <%@ include file="include/_faq.jsp" %>
</div>

<%@ include file="include/_footer.jsp" %>
<hr>
<script src="/resources/js/index.js">
</script>
</body>
</html>
