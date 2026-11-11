<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Register as a Customer">
    <section class="section" style="padding: 2rem;">
        <div class="container" style="max-width: 800px; max-height: fit-content;">
            <div class="card">
                <div class="card-content">
                    <h2 class="text-center mb-4" style="font-weight: 700; font-size: 1.8rem; margin-top: 1rem">Join PetPal</h2>
                    <p class="text-center text-muted mb-4">Create your customer profile and find your petcare solution</p>

                    <form action="/register" method="post" id="customerForm" style="margin-left: 5rem; margin-right: 5rem">
                        <!-- Personal Information -->
                        <h3>Personal Information</h3>

                        <div class="form-group">
                            <label for="name">Full Name</label><br>
                            <input type="text" id="name" placeholder="Corina" required>
                        </div>


                        <div class="form-group">
                            <label for="email">Email Address</label><br>
                            <input type="email" id="email" placeholder="corina@example.com" required>
                        </div>

                        <div class="form-group">
                            <label for="password">Password</label><br>
                            <input type="password" id="password" placeholder="••••••••" required>
                        </div>

                        <!-- Pet Information -->
                        <h3>Pet Information</h3>
                        
                        <div id="container">
                            <div class="form-group">
                                <label for="petName">Pet's Name</label><br>
                                <input type="text" id="petName" placeholder="Tachanka" required>
                            </div>
                            
                            
                            <div class="form-group">
                                <label for="breed">Pet's Breed</label><br>
                                <input type="text" id="breed" placeholder="Newfoundland" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="age">Age</label><br>
                                <input type="text" id="age" placeholder="7" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="weight">Weight</label><br>
                                <input type="text" id="weight" placeholder="150" required>
                            </div>

                            <div class="form-group">
                                <button type="button" class="btn btn-secondary btn-sm" style="margin-top: 1rem">Add Another Pet</button>
                            </div>
                        </div>

                        <!-- Terms -->
                        <div class="form-group" style="margin-top: 1.5rem;">
                            <label style="display: flex; align-items: flex-start; margin: 0;">
                                <input type="checkbox" id="terms" required style="width: auto; margin-right: 0.5rem; margin-top: 0.25rem;">
                                <span>I agree to the Terms of Service and Privacy Policy</span>
                            </label>
                        </div>

                        <!-- Submit Button -->
                        <button type="submit" class="btn btn-primary btn-large" style="width: 100%; margin-top: 1.5rem;">
                            Create Account
                        </button>

                        <!-- Provider Link -->
                        <p class="text-center mt-4">
                            Are you a service provider? <a href="/provider/register" style="color: var(--primary-color); font-weight: 600; text-decoration: none;">Sign up as a provider</a>
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

<script>
    function registerCustomer() {
      const form = document.getElementById('customerForm');
      if (form.checkValidity()) {
        // Navigate to customer profile route
        window.location.href = '/customer/profile';
      } else {
        alert('Please fill in all required fields');
      }
    }
</script>