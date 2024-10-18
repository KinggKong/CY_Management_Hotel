<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
</head>
<body>
<div class="container" style="max-width: 1200px; margin: 0 auto">
    <div class="row mt-5">
        <form action="/payment" method="post">
            <div class="row">
                <div class="col-md-8">
                    <div class="container p-4 border rounded shadow-sm">
                        <h2 class="mb-4">THÔNG TIN THANH TOÁN</h2>
                        <div class="mb-3">
                            <label class="form-label">Họ và tên *</label>
                            <input type="text" class="form-control" name="customerName" placeholder="Nhập họ và tên"
                                   required>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label class="form-label">Số điện thoại *</label>
                                <input type="tel" class="form-control" name="customerPhone"
                                       placeholder="Nhập số điện thoại" required>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ghi chú</label>
                            <textarea class="form-control" name="note" rows="3" placeholder=""></textarea>
                        </div>
                        <input name="totalPrice" hidden="hidden" value="${room.price * numberDay}">
                        <input name="price" hidden="hidden" value="${room.price}">
                        <input name="checkin" hidden="hidden" value="${checkin}">
                        <input name="checkout" hidden="hidden" value="${checkout}">
                        <input name="idRoom" hidden="hidden" value="${room.id}">
                        <input name="typeRoom" hidden="hidden" value="${room.typeRoom.name}">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card border-0 shadow-sm">
                        <div class="card-body">
                            <h4 class="card-title mb-4"><i class="fa fa-info-circle"></i> Thông tin đặt phòng</h4>
                            <h6><i class="fa fa-hotel"></i> ${room.hotel.name}</h6>
                            <p><i class="fa fa-map-marker-alt"></i> ${room.hotel.specificAddress}</p>
                            <div class="mb-3">
                                <img class="img-fluid rounded" src="${room.image}" alt="Room Image">
                            </div>
                            <div class="d-flex justify-content-between mb-3">
                                <p><i class="fa fa-calendar-check"></i> Checkin: ${checkin}</p>
                                <p><i class="fa fa-calendar-times"></i> Checkout: ${checkout}</p>
                            </div>
                            <h6>Loại Phòng: <b>(X1)</b> ${room.typeRoom.name}</h6>
                            <p><i class="fa fa-user"></i> ${room.numberOfPerson} Người</p>
                            <p><i class="fa fa-bed"></i> ${room.numberOfBed} Giường</p>
                            <p><i class="fa fa-cogs"></i> ${room.typeRoom.facility.description}</p>
                            <div>
                                <h6><i class="fa fa-money-bill-wave"></i> Tổng số tiền: $${room.price * numberDay}</h6>
                                <p>${numberDay} Day x $${room.price}</p>
                            </div>
                            <button type="submit" class="btn btn-primary w-100 mt-3"><i class="fa fa-check"></i> Đặt
                                Phòng
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
