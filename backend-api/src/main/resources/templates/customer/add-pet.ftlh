    <#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Customer Dashboard">
    
    <section>
      <div class="container">
        <h1 style="font-size: 2rem; font-weight: 700;">Add Pet Information</h1>
        <p class="text-muted">Add your pet details below</p>
      </div>
    </section>

    <section class="section" style="padding: 1rem;">
        <div class="container" style="max-width: 1000px; max-height:fit-content;">
        <div class="card" style="padding:1rem">
                <!-- Profile Content -->
    <section class="section">
      <div class="container" style="max-width: 800px;">

        <!-- Personal Info Card -->
          
          <div class="card-content" style="margin:2rem">
            <div class="row">
              <div class = "col-sm">
                <div class="pet-portrait">
                <img src="../images/tachanka.jpg" style="width: 300px; height:fit-content; align-self: center;"></img>
                </div>
                <button class="btn btn-light" style="width: 50%; outline-width:2px; outline-color:black; margin-top: 1rem; margin-left:4rem">Edit photo</button>
              </div>
              <div class = "col-sm">
                <div class="card" style="padding:2rem;">
                    <form action="/customer/add-pet" method="post">
                    <input type="hidden" name="customerId" value=${customer.id()}>
                    <div class="form-group">
                        <label for="name">Pet's Name</label><br>
                        <input type="text" id="name" name="name" placeholder="Tachanka" required="">
                    </div>
                        <!-- Pet Breed-->
                    <div class="form-group">
                        <label for="breed">Pet's breed</label><br>
                        <input type="text" id="breed" name="breed" placeholder="Newfoundland" required="">
                    </div>
                        <!-- Age -->
                    <div class="form-group">
                        <label for="age">Age</label><br>
                        <input type="text" id="age" name="age" placeholder="7" required="">
                    </div>
                    <div class="form-group">
                            <!--Weight-->
                        <label for="weight">Weight</label><br>
                        <input type="text" id="weight" name="weight" placeholder="150" required="">
                    </div>

                    <div class="row">
                        <!-- Submit / cancel Buttons -->
                        <div class="mb-3">
                            <button class="btn btn-primary" type="submit">Submit Pet</button>
                            <a class="btn btn-outline" href="/customer/profile">Cancel</a>
                        </div>
                    </form>
                </div>
                </div>
            
          </div>
          </div>
        </div>
        </div>

      </div>
    </section>

  </div>
            
            </div>
        </div>
        </div>
    </section>

    </@l.layout>