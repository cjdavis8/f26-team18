<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Customer Dashboard">


<!-- BEGINNING OF BODY -->
<!--body style="background-color:#cfe8cf"-->
    <div class="container" >

        <div class = "black-box">
            <h2> Welcome, ${customer.name()}!</h2>
        </div>


        <h2>Upcoming Bookings</h2>
        <#list bookings as booking>
          <#if booking.status()=="BOOKED">
            <div class="booking-item">
                <div class="session-header">
                    <div>
                        <div class="booking-provider"><b>Provider</b> ${booking.providerName()}</div>
                            <div class="booking-service"><b>Service</b> ${booking.serviceName()}</div>
                                <div class="booking-pet"><b>Pet</b> ${booking.petName()}</div>
                                    </div>
                                </div>
                                <div class="session-details">
                                    <div class="detail-item"><span class="detail-label"><b>Start Date &amp; Time:</b></span> ${booking.startTime()}</div>
                                    <div class="detail-item"><span class="detail-label"><b>End Date &amp; Time:</b></span> ${booking.endTime()}</div>
                                    <div class="detail-item"><span class="detail-label"><b>Price</b></span> ${booking.servicePrice()}</div>
                                </div>
                                <div style="display: flex; gap: 1rem; margin-top: 1rem;">
                                    <button class="btn btn-success" onclick="window.location.href='session-details.html'">View Details</button>
                                    <button class="btn btn-light" onclick="alert('Rescheduled')">Reschedule</button>
                                    <button class="btn btn-danger" onclick="alert('Session cancelled')" style="color: white; border-color: var(--danger-color);">Cancel</button>
                                </div>
                            </div>
          </#if>
        </#list>
        <p style="font-size: xx-large; text-align: center; font-weight: bold;">Find Services</p>


        <!-- BEGINNING OF AD BLOCKS-->
        <div class = "ad-container">
            <div class="ad-block" onclick="location.href='browse-providers.html'">
                <img src="https://i.imgur.com/BL3Dilp.png" alt="Petpal Walking Ad" class="ad-image-1">
                <h3>Walking</h3>
                <p> Want your animal walked on certain days? Find the right person!</p>
            </div>

            <div class="ad-block" onclick="location.href='browse-providers.html'">
                <img src="https://i.imgur.com/r3zpJkH.png" alt="Petpal Grooming Ad" class="ad-image-2" >
                <h3>Grooming</h3>
                <p> Keep your pet looking their best with our professional grooming services!</p>
            </div>

            <div class="ad-block" onclick="location.href='browse-providers.html'">
                <img src="https://i.imgur.com/npqK2tT.png" alt="Petpal Training Ad" class="ad-image-2" >
                <h3>Training</h3>
                <p> Help your pet learn new tricks and behaviors with our professional training services!</p>
            </div>
        </div>
<!--/body-->
<!-- END OF BODY -->

<!-- SET BACKGROUND COLOR -->
<style>
    body {
        background-color: #C2E5D3;
        margin: 0;
    }
</style>
</@l.layout>