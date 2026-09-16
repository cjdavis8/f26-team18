## Requirements
**Project Name:** PetPal

**Team:** Shaun Sampson (Provider)

**Course:** CSC 340

**Version:** 1.0

**Date** Due 2026-09-18

---

## 1. Overview

**Vision:** The vision is to provide a service for customers that require services such as grooming, care, or similar for their pets and for providers to be able to offer those services.

**Glossary**

- **Customer:** The term for those that require service for a pet
- **Provider:** A groomer, walker, or similar person offer the service to a Customer's pet
- **Profile:** A collection of details about the user or prodiver.
- **Services:** Pet care services that are offered by the provider.

**Primary Users and Roles:**

- **Customer:**
- **Provider:** Offer a service to a client that they are capable of.

**Scope:**

- User profiles
- Browsing services provided
- Reviews
- Updating profiles

**Out of scope**

- Repeatable appointments
- Updating appointment schedulings

---

## 2. Functional Requirements

## 2.1 Customer Stories
- US-1
- US-2

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
- **Performance:**
- **Availability/Reliability:**
- **Security/Privacy:**
- **Usability:**

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