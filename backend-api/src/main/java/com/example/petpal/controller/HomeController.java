package com.example.petpal.controller;

import com.example.petpal.model.Provider;
import com.example.petpal.model.Review;
import com.example.petpal.repository.CustomerRepository;
import com.example.petpal.repository.ProviderRepository;
import com.example.petpal.repository.ReviewRepository;
import com.example.petpal.service.ProviderService;

import com.example.petpal.entity.*;

import jakarta.servlet.http.HttpSession; // Use javax.servlet.http.HttpSession if on Spring Boot 2.x

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProviderRepository ProviderRepository;
    private CustomerRepository CustomerRepository;

    @Autowired
    private ProviderService providerService;

    @GetMapping("/")
    public String home() {
        return "homepage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/customer/register")
    public String showCustomerRegister() {
        return "customer/register";
    }

    @GetMapping("/provider/register")
    public String showProviderRegister() {
        return "provider/register";
    }

    @GetMapping("/provider/dashboard")
    public String showProviderDashboard(HttpSession session, Model model) {
    Provider provider = (Provider) session.getAttribute("loggedInProvider");
    
    if (provider == null) {
        return "redirect:/login";
    }

    model.addAttribute("provider", provider);
    model.addAttribute("isLoggedIn", true); // <--- Add this flag
    return "provider/dashboard";
}

@PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clears all session attributes (including loggedInProvider)
        return "redirect:/";
    }

    // --- Database-Backed Authentication Endpoints ---

    @PostMapping("/provider/login")
public String loginProvider(@RequestParam String email, 
                            @RequestParam String password, 
                            HttpSession session,
                            RedirectAttributes redirectAttributes) { // Switch Model to RedirectAttributes
    Optional<Provider> providerOpt = ProviderRepository.findByEmail(email);

    if (providerOpt.isPresent()) {
        Provider provider = providerOpt.get();
        if (provider.getPassword().equals(password)) {
            // Save provider in session upon successful login
            session.setAttribute("loggedInProvider", provider);
            return "redirect:/provider/dashboard";
        }
    }

    // If login fails, redirect back to /login with an error flag
    redirectAttributes.addFlashAttribute("error", "Invalid email or password for service provider account.");
    return "redirect:/login";
}
    @PostMapping("/customer/login")
public String loginCustomer(@RequestParam String email, 
                            @RequestParam String password, 
                            HttpSession session,
                            RedirectAttributes redirectAttributes) { // Switch Model to RedirectAttributes

    Optional<Customer> customerOpt = CustomerRepository.findByEmail(email);

    if (customerOpt.isPresent()) {
        Customer customer = customerOpt.get();
        if (customer.getPassword().equals(password)) {
            // Save provider in session upon successful login
            session.setAttribute("loggedInCustomer", customer);
            return "redirect:/customer/dashboard";
        }
    }

    // If login fails, redirect back to /login with an error flag
    redirectAttributes.addFlashAttribute("error", "Invalid email or password for customer account.");
    return "redirect:/login";
}

    // Inject ProviderService via constructor
    public HomeController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // Existing login/homepage mappings...

    @GetMapping("/services")
    public String viewServicesAndProviders(Model model) {
        List<Provider> providers = providerService.getAllProviders();
        model.addAttribute("providers", providers);
        return "provider/services"; // Matches templates/provider/services.ftlh
    }

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/providers/{id}")
    public String viewProviderProfile(@PathVariable Long id, Model model) {
        Provider provider = providerService.getProviderById(id);
        
        List<Review> reviews = reviewRepository.findByProviderIdWithReplies(id);
        
        model.addAttribute("provider", provider);
        model.addAttribute("reviews", reviews);
        return "provider/provider";
    }

}
