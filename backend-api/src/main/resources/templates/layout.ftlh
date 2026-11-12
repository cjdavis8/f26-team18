<#macro layout title="">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title! "PetPal - Find Your Pet Care"}</title>
    <!-- CSS Links -->
    <link rel="stylesheet" href="/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #C2E5D3;
            margin: 0;
        }
    </style>
</head>
<body>

    <!-- HEADER -->
    <header class="site-header">
        <!-- LEFT: BUTTONS -->
        <div class="header-left">
            <a href="/"><button class="header-button">Home</button></a>
            <button class="header-button">About</button>
            <a href="/services"><button class="header-button">Services</button></a>
            <button class="header-button">Help</button>
        </div>
        <!-- CENTER: LOGO -->
        <div class="header-center">
            <a href="/"><img src="/petpallogo.png" alt="PetPal Header Logo" class="logo"></a>
        </div>
        <div class="header-right">
            <#if Session["loggedInProvider"]?? || (isLoggedIn!false)>
                <a href="/provider/dashboard"><button class="heaer-button">Dashboard</button></a>
                <form action="/logout" method="POST" style="display: inline;">
                    <button type="submit" class="header-button" style="background-color: #d9534f; color: white;">Logout</button>
                </form>
                
            <#else>
                <a href="/login"><button class="header-button">Login</button></a>
                <a href="/customer/register"><button class="header-button">Register</button></a>
            </#if>
        </div>
    </header>

    <main>
        <#nested>
    </main>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
</#macro>