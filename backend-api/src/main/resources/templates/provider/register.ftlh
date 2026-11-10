<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Register as a Provider">
    <section class="section" style="padding: 2rem;">
        <div class="container" style="max-width: 800px; max-height: fit-content;">
            <div class="card">
                <div class="card-content">
                    <h2 class="text-center mb-4" style="font-weight: 700; font-size: 1.8rem; margin-top: 1rem">Join PetPal as a Service Provider</h2>
                    <p class="text-center text-muted mb-4">Create your provider profile and grow your pet care business</p>

                    <form id="providerForm" style="margin-left: 5rem; margin-right: 5rem">
                        
                        <!-- Personal & Business Information -->
                        <h3>Personal & Business Information</h3>

                        <div class="form-group">
                            <label for="firstName">First Name</label><br>
                            <input type="text" id="firstName" placeholder="Alex" required>
                        </div>

                        <div class="form-group">
                            <label for="lastName">Last Name</label><br>
                            <input type="text" id="lastName" placeholder="Smith" required>
                        </div>

                        <div class="form-group">
                            <label for="location">Location</label><br>
                            <input type="text" id="location" placeholder="Greensboro, NC">
                        </div>

                        <div class="form-group">
                            <label for="businessName">Business or Display Name (Optional)</label><br>
                            <input type="text" id="businessName" placeholder="Paws & Claws Grooming">
                        </div>

                        <div class="form-group">
                            <label for="email">Email Address</label><br>
                            <input type="email" id="email" placeholder="alex@example.com" required>
                        </div>

                        <div class="form-group">
                            <label for="phone">Phone Number</label><br>
                            <input type="tel" id="phone" placeholder="(555) 000-0000" required>
                        </div>

                        <div class="form-group">
                            <label for="password">Password</label><br>
                            <input type="password" id="password" placeholder="••••••••" required>
                        </div>

                        <!-- Services Offered -->
                        <h3 class="mt-4">Services Offered</h3>
                        <p class="text-muted" style="font-size: 0.9rem;">Select all services you provide:</p>

                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="serviceGrooming" value="grooming">
                                <label class="form-check-label" for="serviceGrooming">Pet Grooming</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="serviceWalking" value="walking">
                                <label class="form-check-label" for="serviceWalking">Dog Walking</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="serviceSitting" value="sitting">
                                <label class="form-check-label" for="serviceSitting">Pet Sitting & Boarding</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="serviceTraining" value="training">
                                <label class="form-check-label" for="serviceTraining">Pet Training</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="serviceDaycare" value="daycare">
                                <label class="form-check-label" for="serviceDaycare">Doggy Daycare</label>
                            </div>
                        </div>

                        <!-- Time Availability -->
                        <h3 class="mt-4">Availability</h3>
                        <p class="text-muted" style="font-size: 0.9rem;">Set your general working days and hours:</p>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Monday</label>
                            <input type="time" id="monStart" value="09:00" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="monEnd" value="17:00" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Tuesday</label>
                            <input type="time" id="tueStart" value="09:00" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="tueEnd" value="17:00" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Wednesday</label>
                            <input type="time" id="wedStart" value="09:00" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="wedEnd" value="17:00" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Thursday</label>
                            <input type="time" id="thuStart" value="09:00" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="thuEnd" value="17:00" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Friday</label>
                            <input type="time" id="friStart" value="09:00" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="friEnd" value="17:00" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Saturday</label>
                            <input type="time" id="satStart" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="satEnd" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <div class="form-group mb-2" style="display: flex; align-items: center; justify-content: space-between;">
                            <label style="width: 120px;">Sunday</label>
                            <input type="time" id="sunStart" class="form-control" style="width: 130px; display: inline-block;">
                            <span>to</span>
                            <input type="time" id="sunEnd" class="form-control" style="width: 130px; display: inline-block;">
                        </div>

                        <!-- Terms -->
                        <div class="form-group" style="margin-top: 1.5rem;">
                            <label style="display: flex; align-items: flex-start; margin: 0;">
                                <input type="checkbox" id="terms" required style="width: auto; margin-right: 0.5rem; margin-top: 0.25rem;">
                                <span>I agree to the Provider Terms of Service and Privacy Policy</span>
                            </label>
                        </div>

                        <!-- Submit Button -->
                        <button type="button" class="btn btn-success btn-large" onclick="registerProvider()" style="width: 100%; margin-top: 1.5rem;">
                            Create Provider Account
                        </button>

                        <!-- Customer Link -->
                        <p class="text-center mt-4">
                            Looking for pet care? <a href="/customer/register" style="color: var(--primary-color); font-weight: 600; text-decoration: none;">Sign up as a customer</a>
                        </p>

                        <!-- Already has account -->
                        <p class="text-center">
                            Already have an account? <a href="/login" style="color: var(--primary-color); font-weight: 600; text-decoration: none;">Login here</a>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </section>
</@l.layout>

async function registerProvider() {
    const form = document.getElementById('providerForm');
    
    if (!form.checkValidity()) {
        form.reportValidity();
        return;
    }

    // Build the servicesOffered map matching Map<String, Boolean>
    const servicesMap = {
        grooming: document.getElementById('serviceGrooming').checked,
        walking: document.getElementById('serviceWalking').checked,
        sitting: document.getElementById('serviceSitting').checked,
        training: document.getElementById('serviceTraining').checked,
        daycare: document.getElementById('serviceDaycare').checked
    };

    // Build the provider data object matching Provider.java property names
    const providerData = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        location: document.getElementById('location').value,
        businessName: document.getElementById('businessName').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value,
        phoneNumber: document.getElementById('phone').value, // Matches getPhoneNumber()
        servicesOffered: servicesMap                         // Matches Map<String, Boolean>
    };

    try {
        const response = await fetch('/api/providers', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(providerData)
        });

        if (response.ok) {
            alert('Provider account created successfully!');
            window.location.href = '/login';
        } else {
            const errorText = await response.text();
            alert('Registration failed: ' + (errorText || 'Email may already be registered.'));
        }
    } catch (error) {
        console.error('Error during registration:', error);
        alert('An unexpected error occurred. Please check your connection.');
    }
}