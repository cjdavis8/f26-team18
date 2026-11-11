
<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Customer Profile">
  
  <div class="container">
    <!-- Navigation -->
    <nav>
      <div class="navbar">
        <a href="../index.html" class="navbar-brand"> <img src="../images/user-blank.jpg" width="120" height="120"></a>

      </div>
    </nav>

    <!-- Header -->
    <section class="section" style="background: var(--light-gray);">
      <div class="container">
        <h1 style="font-size: 2rem; font-weight: 700;">${customer.name()}'s Profile</h1>
        <p class="text-muted">View and update your personal information and pets.</p>
      </div>
    </section>

    <!-- Profile Content -->
    <section class="section">
      <div class="container" style="max-width: 800px;">

        <!-- Personal Info Card -->
        <div class="card" style="margin-bottom: 2rem;">
          <div class="card-header">
            <h2 style="margin: 1; font-size: 1.3rem; font-weight: 700;">Personal Information</h2>
          </div>
          <div class="card-content" style="margin:2rem">
            <div class="grid grid-2">
              <div>
                <p class="text-muted" style="margin-bottom: 0.25rem;">Name</p>
                <p style="font-weight: 600;">${customer.name()}</p>
              </div>
              <div>
                <p class="text-muted" style="margin-bottom: 0.25rem;">Email</p>
                <p style="font-weight: 600;">${customer.email()}</p>
              </div>

            </div>
            <button class="btn btn-success" style="margin-top: 1rem;" onclick="window.location.href='/edit-details'">Edit Personal Info</button>
          </div>
        </div>

        <!-- Pets Card -->
        <div class="card" style="margin-bottom: 2rem; padding:2rem;">
          <div class="card-header">
            <h2 style="margin: 0; font-size: 1.3rem; font-weight: 700;">${customer.name()}'s Pets</h2>
          </div>

          <#list pets as pet>
            <div class="card-content">
            <div class="form-group">

                <div class = "pets-container" style="padding:1rem;">
                    <div class="pets-block" onclick="location.href='/customer/pets/${pet.id()}/profile';" style="cursor: pointer;">
                        <h3>Tachanka</h3>
                        <img src="../images/tachanka.jpg" alt="${pet.name}" class="pet-image" style="margin-bottom:.5rem"><br>
                    </div>
                    
                    </div>
                </div>
          </div>
        </div>
          </#if>
        </#list>

        <!-- Account Settings Card -->
        <div class="card" style="margin-bottom: 2rem;">
          <div class="card-header">
            <h2 style="margin: 0; font-size: 1.3rem; font-weight: 700;">Account Settings</h2>
          </div>
          <div class="card-content">
            <button class="btn btn-danger" onclick="alert('Delete account - account will be deleted')" style="width: 100%; text-align: left; padding: 0.75rem 1rem; color: white; border-color: var(--danger-color);">Delete
              Account</button>
          </div>
        </div>

      </div>
    </section>

  </div>