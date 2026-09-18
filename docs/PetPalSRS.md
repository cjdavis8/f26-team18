## Requirements
**Project Name:** PetPal

**Team:** Shaun Sampson (Provider)
Christopher Davis(Customer)

**Course:** CSC 340

**Version:** 1.0

**Date** Due 2026-09-18

---

## 1. Overview

**Vision:** The vision is to provide a service for customers that require services such as grooming, care, or similar for their pets and for providers to be able to offer those services.

**Glossary**

- **Customer:** The term for those that require service for a pet
- **Pet:** The term for a cat or a dog 
- **Provider:** A groomer, walker, or similar person offer the service to a Customer's pet
- **Profile:** A collection of details about the user or prodiver.
- **Services:** Pet care services that are offered by the provider.

**Primary Users and Roles:**

- **Customer:** Find providers to provide services for their pets.
- **Provider:** Offer a service to a client that they are capable of.

**Scope:**

- User profiles
- Browsing services provided
- Reviews
- Updating profiles

**Out of scope**

- Recurring appointments
- Updating appointment schedulings
- Support for profiles for more exotic pets (eg, ferrets)

---

## 2. Functional Requirements

## 2.1 Customer Stories
- **US-1**: Create and update the user's profile 

*Story:* As a customer, I want to create and edit my user profile

*Acceptance:*
```gherkin
Scenario: Create and update my profile and personal information
Given: I do not have a profile
When: I provide my details and submit the form
Then: My profile is created and/or my information edited
And: The profile should be visible to providers with my up to date information
```
- **US-2**: Create, delete or change a pet profile.

*Story:* As a customer, I want to add, remove or edit a pet profile attached to my account.

*Acceptance:*
```gherkin
Scenario: Create and update my pet's profile and attached information
Given: I need to add or remove a pet attached to my profile, or change information about a pet
When: I provide my pet's details and submit the form
Then: A pet profile attached to my account is created or changed
And: The profile should be visible to providers with my pet's up to date information
```

- **US-3**: Find and book services for a pet.

*Story:* As a customer, I want to browse, search for and book services.

*Acceptance:*
```gherkin
Scenario: Search for and book services
Given: I need to book a service for a pet
When: I select an appointment opening and fill out a booking request form
Then: A booking request is submitted to the provider for review
And: The request should be visible and available for response by the provider
```

- **US-4**: Leave a review for a service provider.

*Story:* As a customer, I want to leave a review for a provider I have received services from.

*Acceptance:*
```gherkin
Scenario: Leave a review for services rendered.
Given: I have received a service and would like to leave a review.
When: I select a provider and fill out a review form.
Then: A review is posted on the provider's page
And: The review should be visible and available for response by the provider
```

## 2.2 Provider Stories:
- **US-5**: Create and update the care provider's profile 

*Story:* As a trainer, I want to create, update, and modify the services I provide.

*Acceptance:*
```gherkin
Scenario: Create and update my profile and services
Given: I do not have a profile
When: I provide my details and submit the form
Then: My profile is created and/or my services updated
And: The profile should be visible to customers with my up to date services
```
- **US-6**: Change the prices of my servives on demand and without affecting existing appointments.

*Story:* As a trainer, I want to create, update, and modify the services I provide.

*Acceptance:*
```gherkin
Scenario: Change the prices for future appointments
Given: I believe the price of my service must change
When: I want to change the prices of my service
Then: The price is updated
And: My profile and services provided should reflect the change price and affect only future appointments.
```

- **US-7**: Respond to reviews  

*Story:* As a provider, I want to respond to reviews left by customers 

*Acceptance:*
```gherkin
Scenario: I am logged in as a provider
Given: I find a review on my services 
When: I access the dashboard
Then:  I should be able to submit a response to the review
And: My response should be visible on the review board
```

---

## Non-functional Requirements
- **Performance:** 95% of discovery responses should be returned in less than 3 seconds under typical load.
- **Availability/Reliability:** The system should be available 24/7, apart from regularly scheduled maintenance periods communicated ahead of time to users and providers.
- **Security/Privacy:** Sensitive data (eg, user passwords, bookings) should be encrypted and inaccessible to the public in general.
- **Usability:** 95% of new users should be able to register, create a pet profile and book a service within 15 minutes without assistance / guidance.

---

## 4. Assumptions, Constraints, and Policies
- Modern browsers are capable of hosting the website
- Course timeline and infrastructure restraints

---

## 5. Milestones (course-aligned)
- **M1 Requirements** - this file and related stories
- **M2 High-fidelity** - core customer and provider UI made
- **M3 Design** - architecture, schema, and API outline
- **M4 Backend API** - Key endpoints and tests
- **M5 Increment** - at least 2 use cases end-toend
- **M6 Final** - completed system with documentation

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.
- Major changes should update this SRS.