<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sliding Carousel</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        .carousel-container {
            position: relative;
            max-width: 1400px;
            margin: auto;
            overflow: hidden;
        }
        .carousel-wrapper {
            display: flex;
            transition: transform 0.5s ease-in-out;
        }
        .carousel-slide {
            flex: 0 0 calc(20% - 10px);
            margin: 0 5px;
            height: 200px;
            position: relative;
        }
        .carousel-slide img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
        .carousel-caption {
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: rgba(0, 0, 0, 0.5);
            color: white;
            padding: 8px;
            font-size: 14px;
            text-align: center;
        }
        .carousel-button {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            background-color: rgba(0, 0, 0, 0.5);
            color: white;
            border: none;
            cursor: pointer;
            padding: 16px;
            font-size: 18px;
        }
        .carousel-button.prev {
            left: 10px;
        }
        .carousel-button.next {
            right: 10px;
        }
    </style>
</head>
<body>
<div class="carousel-container">
        <h1 style="text-align: center;">Our Location</h1>
    <div class="carousel-wrapper">
        <div class="carousel-slide">
            <img src="https://media.istockphoto.com/id/160179168/vi/anh/c%E1%BA%A3nh-quan-th%C3%A0nh-ph%E1%BB%91-h%C3%A0-n%E1%BB%99i.jpg?s=612x612&w=0&k=20&c=S_O-z36nrjV2fAzwanS4JMYnKYu_AMgfmiCWs4k00x8=" alt="Hà Nội">
            <div class="carousel-caption">Ha Noi</div>
        </div>
        <div class="carousel-slide">
            <img src="https://media-cdn.tripadvisor.com/media/photo-m/1280/1b/33/f7/12/caption.jpg" alt="French Alps">
            <div class="carousel-caption">Da Nang</div>
        </div>
        <div class="carousel-slide">
            <img src="https://vcdn1-dulich.vnecdn.net/2022/05/12/Hanoi2-1652338755-3632-1652338809.jpg?w=0&h=0&q=100&dpr=2&fit=crop&s=NxMN93PTvOTnHNryMx3xJw" alt="Hà Nội khác">
            <div class="carousel-caption">Ho Chi Minh</div>
        </div>
        <div class="carousel-slide">
            <img src="https://www.shutterstock.com/image-photo/ha-noi-vietnam-may-08-260nw-2310555161.jpg" alt="Hà Nội mới">
            <div class="carousel-caption">Vung Tau</div>
        </div>
        <div class="carousel-slide">
            <img src="https://media.istockphoto.com/id/160179168/vi/anh/c%E1%BA%A3nh-quan-th%C3%A0nh-ph%E1%BB%91-h%C3%A0-n%E1%BB%99i.jpg?s=612x612&w=0&k=20&c=S_O-z36nrjV2fAzwanS4JMYnKYu_AMgfmiCWs4k00x8=" alt="Hà Nội 2">
            <div class="carousel-caption">Phu Quoc</div>
        </div>
        <div class="carousel-slide">
            <img src="https://media-cdn.tripadvisor.com/media/photo-m/1280/1b/33/f7/12/caption.jpg" alt="French Alps 2">
            <div class="carousel-caption">Quang Ninh</div>
        </div>
    </div>
    <button class="carousel-button prev">&#10094;</button>
    <button class="carousel-button next">&#10095;</button>
</div>

<script>
    const wrapper = document.querySelector('.carousel-wrapper');
    const slides = document.querySelectorAll('.carousel-slide');
    const prevButton = document.querySelector('.carousel-button.prev');
    const nextButton = document.querySelector('.carousel-button.next');
    const totalSlides = slides.length;
    const slidesToShow = 5;
    const slidesToScroll = 2;
    let currentIndex = 0;

    function updateCarousel() {
        const offset = (currentIndex * -20) + '%';
        wrapper.style.transform = `translateX(${offset})`;
    }

    function nextSlide() {
        currentIndex = (currentIndex + slidesToScroll) % (totalSlides - slidesToShow + 1);
        if (currentIndex + slidesToShow > totalSlides) {
            currentIndex = 0;
        }
        updateCarousel();
    }

    function prevSlide() {
        currentIndex = (currentIndex - slidesToScroll + (totalSlides - slidesToShow + 1)) % (totalSlides - slidesToShow + 1);
        updateCarousel();
    }

    prevButton.addEventListener('click', prevSlide);
    nextButton.addEventListener('click', nextSlide);

    // Optional: Auto-advance slides every 5 seconds
    setInterval(nextSlide, 5000);
</script>
</body>
</html>