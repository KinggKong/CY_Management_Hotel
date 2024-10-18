<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel MountainView</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 95%;
            margin: 0 auto;
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
        }

        header {
            background-color: white;
            color: black;
            margin-bottom: 20px;
        }

        h1 {
            margin: 0;
            font-size: 24px;
            font-weight: bold;
        }

        .address {
            font-size: 14px;
            color: #666;
            margin-top: 5px;
        }

        .rating {
            color: #ffd700;
            margin-top: 5px;
        }

        .image-grid {
            display: grid;
            grid-template-columns: 2fr 1fr;
            grid-gap: 10px;
            padding: 10px;
        }

        .image-grid img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 4px;
        }

        .image-grid .small-images {
            display: grid;
            grid-gap: 10px;
        }

        .facilities, .booking {
            padding: 20px;
            background-color: white;
            margin-top: 10px;
            border-radius: 8px;
        }

        .facilities ul {
            list-style-type: none;
            padding: 0;
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 10px;
        }

        .facilities li::before {
            color: #4CAF50;
            margin-right: 10px;
        }

        .booking h2 {
            margin-top: 0;
        }

        .booking-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 10px;
            margin-bottom: 20px;
        }

        .booking-grid div {
            background-color: #f9f9f9;
            padding: 10px;
            border-radius: 4px;
            text-align: center;
        }

        .booking-grid div p {
            margin: 5px 0 0;
            font-weight: bold;
        }

        button {
            background-color: #000;
            color: white;
            border: none;
            padding: 15px 20px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
            font-weight: bold;
        }

        .price-breakdown {
            margin-top: 20px;
            font-size: 14px;
        }

        .price-breakdown div {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }

        .total {
            font-weight: bold;
            margin-top: 10px;
            padding-top: 10px;
            border-top: 1px solid #ddd;
        }


        .card {
            margin: 20px auto;
            display: flex;
            max-width: 90%;
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .image {
            width: 40%;
            background-image: url('https://img.freepik.com/free-photo/luxury-bedroom-suite-resort-high-rise-hotel-with-working-table_105762-1783.jpg');
            background-size: cover;
            background-position: center;
        }

        .content {
            width: 60%;
            padding: 20px;
        }

        h3 {
            margin: 0 0 10px 0;
        }

        .address {
            color: #666;
            margin-bottom: 10px;
        }

        .rating {
            color: #ffd700;
            margin-bottom: 15px;
        }

        .amenities {
            display: flex;
            gap: 15px;
            margin-bottom: 20px;
        }

        .amenity {
            display: flex;
            align-items: center;
            color: #4CAF50;
        }

        .price {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .original-price {
            text-decoration: line-through;
            color: #999;
        }

        .discount {
            background-color: #ff0000;
            color: white;
            padding: 2px 5px;
            border-radius: 3px;
            font-size: 12px;
            margin-left: 10px;
        }

        .per-night {
            color: #666;
            font-size: 14px;
        }

        .button {
            display: inline-block;
            background-color: #1a1a1a;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 15px;
        }

        .button:hover {
            background-color: #4CAF50;

        }

        /*  end card*/
    </style>
</head>
<body>
<%@ include file="include/_navbar.jsp" %>
<div class="container">
    <header>
        <h1>${room.hotel.name}</h1>
        <div class="address">${room.hotel.specificAddress}</div>
        <div class="rating"><i class="fa fa-star" aria-hidden="true"></i> ${room.rate} (95 reviews)</div>
    </header>
    <div class="image-grid">
        <img style="height: 100%;object-fit: cover"
             src="${room.image}"
             alt="Cozy Hotel Room">
        <div class="small-images">
            <img style="height: 100%;"
                 src="${room.image}"
                 alt="Books on Shelf">
            <img style="height: 100%"
                 src="${room.image}"
                 alt="Hotel Sign at Night">
        </div>
    </div>
    <div class="facilities">
        <h2>Facilities</h2>
        <ul>
            <li><i class="fa fa-check" aria-hidden="true"></i> Reception</li>
            <li><i class="fa fa-check" aria-hidden="true"></i> Restaurant</li>
            <li><i class="fa fa-check" aria-hidden="true"></i> TV & Refrigerator</li>
            <li><i class="fa fa-check" aria-hidden="true"></i> Room Service</li>
            <li><i class="fa fa-check" aria-hidden="true"></i> 24-hour front desk</li>
            <li><i class="fa fa-check" aria-hidden="true"></i> Parking</li>
        </ul>
    </div>
    <div class="booking">
        <h2>$${room.price} per night</h2>
        <div class="booking-grid">
            <div>
                <strong>CHECK-IN</strong>
                <p>01/01/2023</p>
            </div>
            <div>
                <strong>CHECK-OUT</strong>
                <p>05/01/2023</p>
            </div>
            <div>
                <strong>GUESTS</strong>
                <p>${room.numberOfPerson} guest</p>
            </div>
        </div>
        <button>Reserve</button>
        <p style="text-align: center; color: #666; margin-top: 5px;">Click above to proceed</p>
        <div class="price-breakdown">
            <div>
                <span>$${room.price} x 5 nights</span>
                <span>$${room.price * 5}</span>
            </div>
<%--            <div>--%>
<%--                <span>Tax and Hospitality fees (10%)</span>--%>
<%--                <span>$49.5</span>--%>
<%--            </div>--%>
            <div class="total">
                <strong>Total price after tax</strong>
                <strong>$${room.price * 5}</strong>
            </div>
        </div>
    </div>
</div>
<hr>
<div class="product_relate">
    <h3 style="text-align: center;font-size: 25px;margin: 20px 0;">Similar properties</h3>
    <div class="card">
        <div class="image"></div>
        <div class="content">
            <h2>Hotel Royal Palace</h2>
            <div class="address">4140 Parker Rd. Allentown, New Mexico 31134</div>
            <div class="rating">★★★★★ 4.6 (195 reviews)</div>
            <div class="amenities">
                <div class="amenity">✓ Room Service</div>
                <div class="amenity">✓ Restaurant</div>
                <div class="amenity">✓ Spa</div>
                <div class="amenity">✓ Parking</div>
            </div>
            <div class="price">
                $79 <span class="original-price">$1299</span>
                <span class="discount">93% Off</span>
            </div>
            <div class="per-night">per room/night</div>
            <div class="button-container" style="display: flex; justify-content: flex-end;">
                <a href="#" class="button">View More Details</a>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="image"></div>
        <div class="content">
            <h2>Hotel Royal Palace</h2>
            <div class="address">4140 Parker Rd. Allentown, New Mexico 31134</div>
            <div class="rating">★★★★★ 4.6 (195 reviews)</div>
            <div class="amenities">
                <div class="amenity">✓ Room Service</div>
                <div class="amenity">✓ Restaurant</div>
                <div class="amenity">✓ Spa</div>
                <div class="amenity">✓ Parking</div>
            </div>
            <div class="price">
                $79 <span class="original-price">$1299</span>
                <span class="discount">93% Off</span>
            </div>
            <div class="per-night">per room/night</div>
            <div class="button-container" style="display: flex; justify-content: flex-end;">
                <a href="#" class="button">View More Details</a>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="image"></div>
        <div class="content">
            <h2>Hotel Royal Palace</h2>
            <div class="address">4140 Parker Rd. Allentown, New Mexico 31134</div>
            <div class="rating">★★★★★ 4.6 (195 reviews)</div>
            <div class="amenities">
                <div class="amenity">✓ Room Service</div>
                <div class="amenity">✓ Restaurant</div>
                <div class="amenity">✓ Spa</div>
                <div class="amenity">✓ Parking</div>
            </div>
            <div class="price">
                $79 <span class="original-price">$1299</span>
                <span class="discount">93% Off</span>
            </div>
            <div class="per-night">per room/night</div>
            <div class="button-container" style="display: flex; justify-content: flex-end;">
                <a href="#" class="button">View More Details</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="include/_footer.jsp" %>
<script src="/resoures/js/index.js"></script>
</body>
</html>