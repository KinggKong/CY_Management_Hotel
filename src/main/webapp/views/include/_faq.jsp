<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .containerFAQ {
            width: 100%;
            max-width: 1200px;
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .faq-item {
            background-color: #1a1a1a;
            border-radius: 10px;
            margin-bottom: 10px;
            overflow: hidden;
        }
        .faq-question {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px 20px;
            cursor: pointer;
            color: white;
        }
    </style>
</head>
<body>
<div class="containerFAQ">
    <h1>FAQ's</h1>
    <div class="faq-item">
        <div class="faq-question">What is your policy regarding cancellations?</div>
    </div>
    <div class="faq-item">
        <div class="faq-question">How do I know that my reservation is confirmed?</div>
    </div>
    <div class="faq-item">
        <div class="faq-question">Top Destinations</div>
    </div>
    <div class="faq-item">
        <div class="faq-question">Our Company</div>
    </div>
</div>
</body>
</html>
