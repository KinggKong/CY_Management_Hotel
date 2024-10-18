<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login/Signup Form</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
        }

        .main_login {
            width: 100%;
            height: 100%;
            background-image: url("https://nhagoviet.vn//upload/images/nha-go/go-homestay-tai-da-lat.jpg");
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-container {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .toggle-container {
            display: flex;
            margin-bottom: 1rem;
        }

        .toggle-btn {
            flex: 1;
            padding: 0.5rem;
            border: none;
            background-color: #f0f0f0;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .toggle-btn.active {
            background-color: #333;
            color: white;
        }

        form {
            display: none;
        }

        form.active {
            display: flex;
            flex-direction: column;
        }

        input {
            width: 100%;
            padding: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            width: 100%;
            padding: 0.5rem;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .form-link {
            text-align: center;
            margin-top: 1rem;
            font-size: 0.9rem;
        }

        .form-link a {
            color: #333;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="main_login">
    <div class="form-container">
        <div class="toggle-container">
            <button class="toggle-btn active" id="loginBtn">Login</button>
            <button class="toggle-btn" id="signupBtn">SignUp</button>
        </div>
        <form id="loginForm" action="/login" method="post" class="active">
            <input type="text" id="loginEmail" name="email" placeholder="Email" required>
            <input type="password" name="password" id="loginPassword" placeholder="Password" required>
            <button type="submit">Login</button>
            <p class="form-link">Don't have an account? <a href="#" id="showSignup">Sign Up</a></p>
        </form>
        <form id="signupForm">
            <input type="text" id="signupUsername" placeholder="Username" required>
            <input type="email" id="signupEmail" placeholder="Email" required>
            <input type="password" id="signupPassword" placeholder="Password" required>
            <input type="password" id="signupConfirmPassword" placeholder="Confirm Password" required>
            <button type="submit">Sign Up</button>
            <p class="form-link">Already have an account? <a href="#" id="showLogin">Login</a></p>
        </form>
    </div>
</div>
<script>
    const loginBtn = document.getElementById('loginBtn');
    const signupBtn = document.getElementById('signupBtn');
    const loginForm = document.getElementById('loginForm');
    const signupForm = document.getElementById('signupForm');
    const showSignup = document.getElementById('showSignup');
    const showLogin = document.getElementById('showLogin');

    function toggleMode(mode) {
        if (mode === 'signup') {
            loginBtn.classList.remove('active');
            signupBtn.classList.add('active');
            loginForm.classList.remove('active');
            signupForm.classList.add('active');
        } else {
            signupBtn.classList.remove('active');
            loginBtn.classList.add('active');
            signupForm.classList.remove('active');
            loginForm.classList.add('active');
        }
    }

    loginBtn.addEventListener('click', () => toggleMode('login'));
    signupBtn.addEventListener('click', () => toggleMode('signup'));
    showSignup.addEventListener('click', (e) => {
        e.preventDefault();
        toggleMode('signup');
    });
    showLogin.addEventListener('click', (e) => {
        e.preventDefault();
        toggleMode('login');
    });
</script>
</body>
</html>