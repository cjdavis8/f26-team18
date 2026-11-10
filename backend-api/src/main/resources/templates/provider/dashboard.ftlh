<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Provider Dashboard">
    <section class="section" style="padding: 2rem;">
        <div class="container" style="max-width: 800px; max-height: fit-content;">
            <div class="card">
                <div class="card-content">
                    <h2 class="text-center mb-4" style="font-weight: 700; font-size: 1.8rem; margin-top: 1rem">Provider Dashboard</h2>
                    <p class="text-center text-muted mb-4">View and update your professional profile and availability</p>

                    <form id="dashboardForm" style="margin-left: 5rem; margin-right: 5rem">
                        <input type="hidden" id="providerId" value="${provider.id! ''}">
                        
                        <!-- Personal & Business Information -->
                        <h3>Personal & Business Information</h3>
                        <div class="form-group">
                            <label for="pfp">Profile Picture URL</label><br>
                            <input type="text" id="pfp" value="${provider.pfpImageUrl! '/images/pfp-placeholder.png'}">
                        </div>

                        <div class="form-group">
                            <label for="firstName">First Name</label><br>
                            <input type="text" id="firstName" value="${provider.firstName! ''}" required>
                        </div>

                        <div class="form-group">
                            <label for="lastName">Last Name</label><br>
                            <input type="text" id="lastName" value="${provider.lastName! ''}" required>
                        </div>

                        <div class="form-group">
                            <label for="location">Location</label><br>
                            <input type="text" id="location" value="${provider.location! ''}">
                        </div>

                        <div class="form-group">
                            <label for="businessName">Business or Display Name</label><br>
                            <input type="text" id="businessName" value="${provider.businessName! ''}">
                        </div>

                        <div class="form-group">
                            <label for="email">Email Address</label><br>
                            <input type="email" id="email" value="${provider.email! ''}" required>
                        </div>

                        <div class="form-group">
                            <label for="phone">Phone Number</label><br>
                            <input type="tel" id="phone" value="${(provider.phoneNumber)! (provider.phone)! ''}">
                        </div>

                        <!-- Profile Bio & Details -->
                        <h3 class="mt-4">Profile Information & Bio</h3>
                        <p class="text-muted" style="font-size: 0.9rem;">This information will be publicly displayed on your provider profile page:</p>

                        <div class="form-group mb-3">
                            <label for="aboutMe">About Me</label>
                            <textarea id="aboutMe" class="form-control" rows="5">${(provider.aboutMe)! ''}</textarea>
                        </div>

                        <div class="form-group mb-3">
                            <label for="specialties">Specialties & Skills (one per line)</label>
                            <textarea id="specialties" class="form-control" rows="5"><#if provider.specialties??><#list provider.specialties as spec>${spec}<#if spec_has_next>&#10;</#if></#list></#if></textarea>
                        </div>

                    <!-- Services Offered -->
<h3 class="mt-4">Services Offered</h3>
<p class="text-muted" style="font-size: 0.9rem;">Select all services you provide:</p>

<h3 class="mt-4">Services Offered & Pricing</h3>
<p class="text-muted" style="font-size: 0.9rem;">Select your services and set your rates ($):</p>

<div class="form-group">
    <!-- Grooming -->
    <div class="d-flex align-items-center mb-2">
        <div class="form-check" style="width: 250px;">
            <input class="form-check-input" type="checkbox" id="serviceGrooming" value="grooming" 
                <#if (provider.servicesOffered!{})['grooming']!false>checked</#if>>
            <label class="form-check-label" for="serviceGrooming">Pet Grooming</label>
        </div>
        <input type="number" id="priceGrooming" class="form-control" placeholder="Price ($)" style="width: 150px;" 
            value="${((provider.servicePrices!{})['grooming'])! ''}">
    </div>

    <!-- Dog Walking -->
    <div class="d-flex align-items-center mb-2">
        <div class="form-check" style="width: 250px;">
            <input class="form-check-input" type="checkbox" id="serviceWalking" value="dog_walking" 
                <#if (provider.servicesOffered!{})['dog_walking']!false>checked</#if>>
            <label class="form-check-label" for="serviceWalking">Dog Walking</label>
        </div>
        <input type="number" id="priceWalking" class="form-control" placeholder="Price ($)" style="width: 150px;" 
            value="${((provider.servicePrices!{})['dog_walking'])! ''}">
    </div>

    <!-- Pet Sitting & Boarding -->
    <div class="d-flex align-items-center mb-2">
        <div class="form-check" style="width: 250px;">
            <input class="form-check-input" type="checkbox" id="serviceSitting" value="pet_sitting" 
                <#if (provider.servicesOffered!{})['pet_sitting']!false>checked</#if>>
            <label class="form-check-label" for="serviceSitting">Pet Sitting & Boarding</label>
        </div>
        <input type="number" id="priceSitting" class="form-control" placeholder="Price ($)" style="width: 150px;" 
            value="${((provider.servicePrices!{})['pet_sitting'])! ''}">
    </div>

    <!-- Pet Training -->
    <div class="d-flex align-items-center mb-2">
        <div class="form-check" style="width: 250px;">
            <input class="form-check-input" type="checkbox" id="serviceTraining" value="pet_training" 
                <#if (provider.servicesOffered!{})['pet_training']!false>checked</#if>>
            <label class="form-check-label" for="serviceTraining">Pet Training</label>
        </div>
        <input type="number" id="priceTraining" class="form-control" placeholder="Price ($)" style="width: 150px;" 
            value="${((provider.servicePrices!{})['pet_training'])! ''}">
    </div>

    <!-- Doggy Daycare -->
    <div class="d-flex align-items-center mb-2">
        <div class="form-check" style="width: 250px;">
            <input class="form-check-input" type="checkbox" id="serviceDaycare" value="doggy_daycare" 
                <#if (provider.servicesOffered!{})['doggy_daycare']!false>checked</#if>>
            <label class="form-check-label" for="serviceDaycare">Doggy Daycare</label>
        </div>
        <input type="number" id="priceDaycare" class="form-control" placeholder="Price ($)" style="width: 150px;" 
            value="${((provider.servicePrices!{})['doggy_daycare'])! ''}">
    </div>
</div>

                        <!-- Time Availability -->
                        <h3 class="mt-4">Availability</h3>
                        <p class="text-muted" style="font-size: 0.9rem;">Update your general working days and hours:</p>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Monday</label>
                            <input type="time" id="monStart" value="${((provider.availability!{})['monStart'])! '09:00'}" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="monEnd" value="${((provider.availability!{})['monEnd'])! '17:00'}" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Tuesday</label>
                            <input type="time" id="tueStart" value="${((provider.availability!{})['tueStart'])! '09:00'}" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="tueEnd" value="${((provider.availability!{})['tueEnd'])! '17:00'}" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Wednesday</label>
                            <input type="time" id="wedStart" value="${((provider.availability!{})['wedStart'])! '09:00'}" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="wedEnd" value="${((provider.availability!{})['wedEnd'])! '17:00'}" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Thursday</label>
                            <input type="time" id="thuStart" value="${((provider.availability!{})['thuStart'])! '09:00'}" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="thuEnd" value="${((provider.availability!{})['thuEnd'])! '17:00'}" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Friday</label>
                            <input type="time" id="friStart" value="${((provider.availability!{})['friStart'])! '09:00'}" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="friEnd" value="${((provider.availability!{})['friEnd'])! '17:00'}" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Saturday</label>
                            <input type="time" id="satStart" value="${((provider.availability!{})['satStart'])! ''}" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="satEnd" value="${((provider.availability!{})['satEnd'])! ''}" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Sunday</label>
                            <input type="time" id="sunStart" value="${((provider.availability!{})['sunStart'])! ''}" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="sunEnd" value="${((provider.availability!{})['sunEnd'])! ''}" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <!-- Save Button -->
                        <button type="button" class="btn btn-success btn-large" onclick="saveChanges()" style="width: 100%; margin-top: 1.5rem;">
                            Save Changes
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </section>
</@l.layout>

<script>
    async function saveChanges() {
        const providerId = document.getElementById('providerId').value;
        if (!providerId) {
            alert('Error: Provider ID is missing.');
            return;
        }

        // Convert specialties textarea lines into List<String>
        const specialtiesText = document.getElementById('specialties').value;
        const specialtiesList = specialtiesText ? specialtiesText.split('\n').filter(s => s.trim() !== '') : [];

        // Build availability JSON map
        const availabilityMap = {
            monStart: document.getElementById('monStart').value,
            monEnd: document.getElementById('monEnd').value,
            tueStart: document.getElementById('tueStart').value,
            tueEnd: document.getElementById('tueEnd').value,
            wedStart: document.getElementById('wedStart').value,
            wedEnd: document.getElementById('wedEnd').value,
            thuStart: document.getElementById('thuStart').value,
            thuEnd: document.getElementById('thuEnd').value,
            friStart: document.getElementById('friStart').value,
            friEnd: document.getElementById('friEnd').value,
            satStart: document.getElementById('satStart').value,
            satEnd: document.getElementById('satEnd').value,
            sunStart: document.getElementById('sunStart').value,
            sunEnd: document.getElementById('sunEnd').value
        };

        const servicesMap = {
            grooming: document.getElementById('serviceGrooming').checked,
            dog_walking: document.getElementById('serviceWalking').checked,
            pet_sitting: document.getElementById('serviceSitting').checked,
            pet_training: document.getElementById('serviceTraining').checked,
            doggy_daycare: document.getElementById('serviceDaycare').checked
        };

        const pricesMap = {
            grooming: parseFloat(document.getElementById('priceGrooming').value) || 0.0,
            dog_walking: parseFloat(document.getElementById('priceWalking').value) || 0.0,
            pet_sitting: parseFloat(document.getElementById('priceSitting').value) || 0.0,
            pet_training: parseFloat(document.getElementById('priceTraining').value) || 0.0,
            doggy_daycare: parseFloat(document.getElementById('priceDaycare').value) || 0.0
        };

        const providerData = {
            pfpImageUrl: document.getElementById('pfp').value,
            firstName: document.getElementById('firstName').value,
            lastName: document.getElementById('lastName').value,
            location: document.getElementById('location').value,
            businessName: document.getElementById('businessName').value,
            email: document.getElementById('email').value,
            phoneNumber: document.getElementById('phone').value,
            aboutMe: document.getElementById('aboutMe').value,
            specialties: specialtiesList,
            availability: availabilityMap,
            servicePrices: pricesMap,
            servicesOffered: servicesMap
        };

        try {
            const response = await fetch('/api/providers/' + providerId, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(providerData)
            });

            if (response.ok) {
                alert('Changes saved successfully!');
            } else {
                alert('Failed to save changes. Please try again.');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('An unexpected error occurred while saving.');
        }
    }
</script>