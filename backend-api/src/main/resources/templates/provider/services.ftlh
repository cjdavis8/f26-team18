<#import "../layout.ftlh" as l>

<@l.layout title="PetPal - Services & Providers">
    <!-- BODY CONTENT -->
    <div class="container my-5">
        <div class="text-center mb-5">
            <h1 style="font-weight: 700; color: #2c5e3b;">Our Services & Trusted Providers</h1>
            <p class="text-muted">Browse through our specialized pet care services and find the right professional for your furry friend.</p>
        </div>

        <!-- SERVICES OVERVIEW CARDS -->
        <div class="row g-4 mb-5">
            <div class="col-md-4">
                <div class="card h-100 p-3 shadow-sm">
                    <div class="card-body">
                        <h3 class="h5 card-title text-success">Pet Grooming</h3>
                        <p class="card-text">Breed-standard styling, gentle baths, de-shedding treatments, nail trimming, and ear cleaning in a stress-free environment.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100 p-3 shadow-sm">
                    <div class="card-body">
                        <h3 class="h5 card-title text-success">Dog Walking</h3>
                        <p class="card-text">Structured, positive-reinforcement neighborhood walks and energetic midday treks to keep your pets happy and healthy.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100 p-3 shadow-sm">
                    <div class="card-body">
                        <h3 class="h5 card-title text-success">Pet Sitting & Training</h3>
                        <p class="card-text">In-home sitting, boarding, and behavior training tailored to rescue dogs, senior pets, and growing puppies.</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- FEATURED PROVIDERS SECTION -->
        <section>
            <h2 class="mb-4" style="font-weight: 600;">Featured Providers</h2>
            <div class="row g-4">
                
                <#if providers?? && providers?has_content>
                    <#list providers as provider>
                        <div class="col-md-6">
                            <div class="card p-3 shadow-sm d-flex flex-row align-items-center">
                                <img src="${provider.pfpImageUrl! 'https://i.imgur.com/WQewwZe.png'}" alt="${provider.name! 'Provider'}" class="rounded-circle me-3" style="width: 80px; height: 80px; object-fit: cover;">
                                <div>
                                    <h3 class="h5 mb-1">${provider.name! ((provider.firstName! '') + ' ' + (provider.lastName! ''))}</h3>
                                    <p class="text-muted small mb-2">
                                        <#if provider.businessName?? && provider.businessName?has_content>
                                            ${provider.businessName} • 
                                        </#if>
                                        ${provider.location! 'Location unavailable'}
                                    </p>
                                    <p class="small mb-3">
                                        ${provider.aboutMe! 'Professional pet care provider ready to help your furry friend!'}
                                    </p>
                                    <a href="/providers/${provider.id! ''}" class="btn btn-sm btn-success">View Profile</a>
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <div class="col-12 text-center text-muted py-4">
                        <p>No providers are currently registered. Check back soon!</p>
                    </div>
                </#if>

            </div>
        </section>

    </div>
</@l.layout>