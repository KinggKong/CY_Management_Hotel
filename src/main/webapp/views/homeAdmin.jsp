<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/admin.css">
</head>
<body>
<!-- Sidebar -->
<nav class="sidebar">
    <a href="#" class="active" onclick="getCategory(event, 1)"><i class="fas fa-tachometer-alt me-2"></i> Dashboard</a>
    <a href="#" onclick="getCategory(event, 2)"><i class="fas fa-bed me-2"></i> Rooms</a>
    <a href="#" onclick="getCategory(event, 3)"><i class="fas fa-book me-2"></i> Bookings</a>
</nav>


<!-- Navbar -->
<nav class="navbar navbar-expand-lg fixed-top">
    <div class="container-fluid">
        <!-- Brand -->
        <a class="navbar-brand" href="#">
            <img style="border-radius: 10px;"
                 src="https://genk.mediacdn.vn/2018/10/19/photo-1-15399266837281100315834-15399271585711710441111.png"
                 alt="Logo"/>
        </a>

        <!-- Right side -->
        <ul class="navbar-nav ms-auto d-flex align-items-center">
            <!-- Notification icon -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <i class="fas fa-bell"></i>
                    <span class="badge bg-danger rounded-pill">1</span>
                </a>
            </li>
            <!-- User avatar dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                   aria-expanded="false">
                    <img src="https://mdbootstrap.com/img/Photos/Avatars/img (31).jpg" class="rounded-circle"
                         height="30" alt="User"/>
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="#">Profile</a></li>
                    <li><a class="dropdown-item" href="#">Settings</a></li>
                    <li><a class="dropdown-item" href="#">Logout</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<!-- Main layout -->
<main>
    <div class="container" id="main_container">
        <div style="display: flex; align-items: center; justify-content: space-between; margin: 20px 0;">
            <form id="searchForm" method="get" action="/admin/product">
                <select name="productLine" id="productLine">
                    <option value=""></option>

                </select>
                <input type="text" name="productCode" id="productCode" placeholder="Mã sản phẩm">
                <input type="text" name="key" placeholder="Search........">
                <button type="submit">Search</button>
            </form>

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Add product
            </button>
        </div>


        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>Hotel</th>
                <th>Name</th>
                <th>Price</th>
                <th>Type Room</th>
                <th>Number of Bed</th>
                <th>Rate</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>


        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Add new product</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/admin/product/add" method="post" enctype="multipart/form-data">
                            <div class="mb-3">
                                <label class="form-label">Product Code</label>
                                <input class="form-control" type="text" name="productCode" required>
                            </div>
                            <div class="mb-3" v>
                                <label class="form-label">Product Name</label>
                                <input class="form-control" type="text" name="productName" min="0" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">QuantityInStock</label>
                                <input class="form-control" type="number" name="quantityInStock" min="1" required>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Buy Price</label>
                                <input class="form-control" type="text" name="buyPrice" required>
                            </div>
                            <div class="mb-3">
                                <select class="form-select" name="productLine">
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Chọn ảnh sản phẩm</label>
                                <input class="form-control" type="file" name="productImage" name="productImage"
                                       accept="image/*" required>
                            </div>
                            <div style="display: flex; justify-content: end">
                                <button class="btn btn-success">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="/resources/js/admin.js">

</script>
</body>
</html>
