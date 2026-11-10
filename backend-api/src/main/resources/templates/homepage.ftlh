<#import "layout.ftlh" as l>

<@l.layout title="PetPal - Home">
    <div class="container">
        <img src="/petpalmainlogo.png" alt="PetPal Homepage" class="logo-image">

        <!-- AD TO LOGIN OR REGISTER -->
        <div class="black-box">
            <h2>Find your perfect setup today!</h2>

            <div class="black-box-buttons">
                <a href="/customer/register"><button class="header-button">Register</button></a>
                <a href="/login"><button class="header-button">Login</button></a>
            </div>
        </div>

        <p style="font-size: xx-large; text-align: center; font-weight: bold;">Join our community of pet lovers today!</p>

        <!-- AD BLOCKS -->
        <div class="ad-container">
            <div class="ad-block">
                <img src="https://i.imgur.com/BL3Dilp.png" alt="Petpal Walking Ad" class="ad-image-1">
                <h3>Walking</h3>
                <p>Want your animal walked on certain days? Find the right person!</p>
            </div>

            <div class="ad-block">
                <img src="https://i.imgur.com/r3zpJkH.png" alt="Petpal Grooming Ad" class="ad-image-2">
                <h3>Grooming</h3>
                <p>Keep your pet looking their best with our professional grooming services!</p>
            </div>

            <div class="ad-block">
                <img src="https://i.imgur.com/npqK2tT.png" alt="Petpal Training Ad" class="ad-image-2">
                <h3>Training</h3>
                <p>Help your pet learn new tricks and behaviors with our professional training services!</p>
            </div>
        </div>
    </div>
</@l.layout>