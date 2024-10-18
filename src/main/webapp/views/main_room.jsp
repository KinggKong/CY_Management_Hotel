<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<%@ include file="include/_navbar.jsp" %>

<div class="main_container">
    <c:forEach items="${rooms}" var="item">
        <div class="card">
            <div class="image">
                <img src="${item.image}" alt="">
            </div>
            <div class="content">
                <h2>${item.hotel.name}</h2>
                <div class="address">${item.hotel.specificAddress}</div>
                <div class="rating">★★★★★ ${item.rate} (195 reviews)</div>
                <div class="amenities">
                    <div class="amenity">✓ Room Service</div>
                    <div class="amenity">✓ Restaurant</div>
                    <div class="amenity">✓ Spa</div>
                    <div class="amenity">✓ Parking</div>
                </div>
                <div class="price">
                    $ ${item.price} <span class="original-price">$ ${item.price}</span>
                    <span class="discount">93% Off</span>
                </div>
                <div class="per-night">per room/night</div>
                <div class="button-container" style="display: flex; justify-content: flex-end;">
                    <a href="/room_detail?id=${item.id}" class="button">View More Details</a>
                </div>
            </div>
        </div>
    </c:forEach>

    <div class="pagination" id="pagination">
        <a href="#">&laquo;</a>
        <a href="#">1</a>
        <a class="active" href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#">&raquo;</a>
    </div>
</div>

<%@ include file="include/_footer.jsp" %>

<script src="/resources/js/index.js">
</script>

</body>
</html>
