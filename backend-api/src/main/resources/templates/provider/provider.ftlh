<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - ${(provider.firstName)! 'Provider'} Profile">
<!-- BODY -->
<div class="container my-4">
  <main class="profile-body row">
    
    <!-- LEFT SIDE: PERSONAL DETAILS -->
    <aside class="profile-sidebar col-md-4">
      <img src="${provider.pfpImageUrl! 'https://i.imgur.com/WQewwZe.png'}" alt="Provider Picture" class="profile-img img-fluid rounded mb-3" style="width: 100%; height: 250px; object-fit: cover;">
      
      <div class="personal-details mb-4">
        <h3>${provider.name! ((provider.firstName! '') + ' ' + (provider.lastName! ''))}</h3>
        <ul class="list-unstyled">
          <#if provider.businessName?? && provider.businessName?has_content>
            <li><strong>Business:</strong> ${provider.businessName}</li>
          </#if>
          <li><strong>Location:</strong> ${provider.location! 'Location unavailable'}</li>
          <li><strong>Email:</strong> ${provider.email! ''}</li>
          <li><strong>Phone:</strong> ${provider.phoneNumber! provider.phone! 'Not provided'}</li>
        </ul>
      </div>

      <div class="services-offered-section mb-4">
        <h5>Services & Pricing</h5>
        <div class="d-flex flex-column gap-2 mt-2">
          <#if provider.servicesOffered?? && provider.servicesOffered?has_content>
            <#list provider.servicesOffered as serviceKey, isOffered>
              <#if isOffered>
                <div class="d-flex justify-content-between align-items-center p-2 bg-light rounded border">
                  <span class="fw-semibold">
                    <#if serviceKey == "grooming">Pet Grooming
                    <#elseif serviceKey == "dog_walking">Dog Walking
                    <#elseif serviceKey == "pet_sitting">Pet Sitting & Boarding
                    <#elseif serviceKey == "pet_training">Pet Training
                    <#elseif serviceKey == "doggy_daycare">Doggy Daycare
                    <#else>${serviceKey?replace('_', ' ')?capitalize}
                    </#if>
                  </span>
                  <span class="badge bg-success fs-6">
                    $<#assign prices = provider.servicePrices!{}>
                    ${(prices[serviceKey])! '0.00'}
                  </span>
                </div>
              </#if>
            </#list>
          <#else>
            <span class="text-muted small">No specific services listed.</span>
          </#if>
        </div>
      </div>

      <!-- GENERAL AVAILABILITY -->
      <div class="availability-section card p-3 mb-4">
        <h5 class="card-title">General Availability</h5>
        <ul class="list-unstyled mb-0" style="font-size: 0.95rem;">
          <#assign avail = provider.availability!{}>
          <li class="d-flex justify-content-between py-1 border-bottom">
            <span>Monday</span><strong>${(avail['monStart'])! '9:00 AM'} - ${(avail['monEnd'])! '5:00 PM'}</strong>
          </li>
          <li class="d-flex justify-content-between py-1 border-bottom">
            <span>Tuesday</span><strong>${(avail['tueStart'])! '9:00 AM'} - ${(avail['tueEnd'])! '5:00 PM'}</strong>
          </li>
          <li class="d-flex justify-content-between py-1 border-bottom">
            <span>Wednesday</span><strong>${(avail['wedStart'])! '9:00 AM'} - ${(avail['wedEnd'])! '5:00 PM'}</strong>
          </li>
          <li class="d-flex justify-content-between py-1 border-bottom">
            <span>Thursday</span><strong>${(avail['thuStart'])! '9:00 AM'} - ${(avail['thuEnd'])! '5:00 PM'}</strong>
          </li>
          <li class="d-flex justify-content-between py-1 border-bottom">
            <span>Friday</span><strong>${(avail['friStart'])! '9:00 AM'} - ${(avail['friEnd'])! '5:00 PM'}</strong>
          </li>
          <li class="d-flex justify-content-between py-1 border-bottom">
            <span>Saturday</span><strong>${(avail['satStart']?has_content)?string(avail['satStart'] + ' - ' + (avail['satEnd']! ''), 'Closed')}</strong>
          </li>
          <li class="d-flex justify-content-between py-1">
            <span>Sunday</span><strong>${(avail['sunStart']?has_content)?string(avail['sunStart'] + ' - ' + (avail['sunEnd']! ''), 'Closed')}</strong>
          </li>
        </ul>
      </div>
      
      <section id="schedule-section" class="profile-content card p-3">
        <h2>Schedule Appointment</h2>
        <form id="appointmentForm">
          <!-- Client Details -->
          <div class="mb-3">
            <label for="name" class="form-label">Your Name:</label>
            <input type="text" id="name" name="name" class="form-control" placeholder="Jane Doe" required>
          </div>
          
          <div class="mb-3">
            <label for="email" class="form-label">Email Address:</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="jane@example.com" required>
          </div>

          <!-- Service Selection -->
          <div class="mb-3">
            <label for="service" class="form-label">Select Service:</label>
            <select id="service" name="service" class="form-select" required>
              <option value="" disabled selected>Choose a service...</option>
              <#if provider.servicesOffered??>
                <#list provider.servicesOffered as serviceKey, isOffered>
                  <#if isOffered>
                    <option value="${serviceKey}">${serviceKey?replace('_', ' ')?capitalize}</option>
                  </#if>
                </#list>
              </#if>
            </select>
          </div>

          <!-- Preferred Date & Time -->
          <div class="mb-3">
            <label for="date" class="form-label">Preferred Date:</label>
            <input type="date" id="date" name="date" class="form-control" required>
          </div>

          <div class="mb-3">
            <label for="time" class="form-label">Preferred Time:</label>
            <input type="time" id="time" name="time" class="form-control" required>
          </div>

          <!-- Additional Pet Details -->
          <div class="mb-3">
            <label for="notes" class="form-label">Pet Name & Special Instructions:</label>
            <textarea id="notes" name="notes" class="form-control" rows="2" placeholder="e.g., Max (Golden Retriever), needs gentle shampoo"></textarea>
          </div>

          <button type="submit" class="btn btn-success w-100">Submit Request</button>
        </form>
      </section>
    </aside>

    <!-- Right Side: DESCRIPTIONS -->
    <section class="profile-content col-md-8">
      <h2>About Me</h2>
      <p>${provider.aboutMe! 'No bio available yet.'}</p>
      
      <hr style="margin: 20px 0; border: 0; border-top: 1px solid #eee;">

      <h2>Specialties & Skills</h2>
      <#if provider.specialties?? && provider.specialties?has_content>
        <ul class="list-unstyled">
          <#list provider.specialties as spec>
            <li class="mb-2">• ${spec}</li>
          </#list>
        </ul>
      <#else>
        <p class="text-muted">No specific specialties listed yet.</p>
      </#if>
      
      <h2>Professional History</h2>
      <p>${provider.history! 'Professional background details coming soon.'}</p>
    </section>

  </main>

  <section class="profile-reviews mt-5">
    <h2>Reviews</h2>
    <#if reviews?? && reviews?has_content>
      <div class="d-flex flex-column gap-3 mt-3">
        <#list reviews as review>
          <div class="review-card card p-3 shadow-sm">
            <div class="review-header d-flex justify-content-between align-items-center">
              <strong>
                <#if review.customer??>
                  ${review.customer.firstName! 'Valued'} ${review.customer.lastName! 'Client'}
                <#else>
                  Anonymous Client
                </#if>
              </strong>
              <span class="stars text-warning">
                <#list 1..(review.rating!5) as _>★</#list>
              </span>
            </div>
            
            <p class="review-text mt-2 mb-1">"${review.comment! ''}"</p>
            
            <#if review.reviewDate??>
              <span class="review-date text-muted small">Reviewed on ${review.reviewDate!''}</span>
            </#if>

            <!-- Display Provider Replies -->
            <#if review.replies?? && review.replies?has_content>
              <div class="mt-3 ps-3 border-start border-success bg-light p-2 rounded">
                <#list review.replies as reply>
                  <div class="small">
                    <strong class="text-success">Response from Provider:</strong> 
                    <p class="mb-0 text-muted">${reply.comment! ''}</p>
                  </div>
                </#list>
              </div>
            </#if>
          </div>
        </#list>
      </div>
    <#else>
      <div class="card p-3 text-muted">
        <p class="mb-0">No reviews yet for this provider. Book an appointment to leave the first review!</p>
      </div>
    </#if>
  </section>

</div>
</@l.layout>