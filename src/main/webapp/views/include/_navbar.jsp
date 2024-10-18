<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="margin: 0; padding: 0; width: 100%">
<header>
    <div style="display: flex; background-color: black; align-items: center;justify-content: space-between; padding:1rem 2rem">
        <div>
            <a href="http://localhost:8080/" style="color: white; text-decoration: none;">Prime Hotels</a>
            <a href="#" style="color: white; margin: 0 20px;cursor: pointer;text-decoration: none;"
               onclick="paginationRoom(1)">Book Room</a>
        </div>
        <div>
            <c:if test="${authenticated != null}">
                <button style="padding: 10px 15px; border: 1px white solid; border-radius: 10px; background-color: black; color: white">
                    <a>Logout</a>
                </button>
            </c:if>
            <c:if test="${authenticated == null}">
                <button style="padding: 10px 15px; border: 1px white solid; border-radius: 10px; background-color: black; color: white">
                  <a href="/login" style="text-decoration: none;color: white">Login</a>
                </button>
            </c:if>
        </div>
    </div>
</header>
</body>
</html>
