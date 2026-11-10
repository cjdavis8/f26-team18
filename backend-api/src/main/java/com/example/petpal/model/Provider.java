package com.example.petpal.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pfp_image_url")
    private String pfpImageUrl;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "business_name", length = 100)
    private String businessName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String location;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "history")
    private String history;

    @Column(name = "about_me", columnDefinition = "TEXT")
    private String aboutMe;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "service_prices", columnDefinition = "jsonb")
    private Map<String, Double> servicePrices;

    // Maps to PostgreSQL text[] array
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "specialties", columnDefinition = "text[]")
    private List<String> specialties;

    // Maps to PostgreSQL JSONB for service checkboxes
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "services_offered", columnDefinition = "jsonb")
    private Map<String, Boolean> servicesOffered;

    // Maps to PostgreSQL JSONB for daily schedules
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "availability", columnDefinition = "jsonb")
    private Map<String, Object> availability;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    // --- Constructors ---

    public Provider() {
    }

    public Provider(Long userId, String firstName, String lastName, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password; // --- ADDED ---
    }

    public String getName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return firstName != null ? firstName : "";
    }

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getPfpImageUrl() { return pfpImageUrl; }
    public void setPfpImageUrl(String pfpImageUrl) { this.pfpImageUrl = pfpImageUrl; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getHistory() { return history; }
    public void setHistory(String history) { this.history = history; }

    public String getAboutMe() { return aboutMe; }
    public void setAboutMe(String aboutMe) { this.aboutMe = aboutMe; }

    public Map<String, Double> getServicePrices() { return servicePrices; }
    public void setServicePrices(Map<String, Double> servicePrices) { this.servicePrices = servicePrices; }

    public List<String> getSpecialties() { return specialties; }
    public void setSpecialties(List<String> specialties) { this.specialties = specialties; }

    public Map<String, Boolean> getServicesOffered() { return servicesOffered; }
    public void setServicesOffered(Map<String, Boolean> servicesOffered) { this.servicesOffered = servicesOffered; }

    public Map<String, Object> getAvailability() { return availability; }
    public void setAvailability(Map<String, Object> availability) { this.availability = availability; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "reviews", columnDefinition = "jsonb")
    private List<Map<String, Object>> reviews;

    public List<Map<String, Object>> getReviews() { return reviews; }
    public void setReviews(List<Map<String, Object>> reviews) { this.reviews = reviews; }

}
