<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Edit Customer Profile">

<section class="section" style="background: #4c824c; padding:1rem; margin:2rem;">
      <div class="container">
        <h1 style="font-size: 2rem; font-weight: 700;">Edit Personal Information</h1>
        <p class="text-muted">Update your personal details below</p>
      </div>
    </section>

    <section class="section" style="padding: 1rem;">
        <div class="container" style="max-width: 800px; max-height:fit-content;">
        <div class="card" style="padding:1rem">
            <form action="/customer/edit-details" method="post">
            <label for="name">Full Name</label><input id="name" name="name" value="${customer.name()}" required
              maxlength="100">
            <label for="email">Email</label><input id="email" name="email" type="email" value="${customer.email()}"
              required maxlength="254">
                <!-- Submit Button -->
                <button type="button" class="btn btn-success btn-large" onclick="confirmChanges()" style="width: 100%; margin-top: 1.5rem;">
                Confirm Changes
                </button>

            </form>
            </div>
        </div>
        </div>
    </section>

</@l>