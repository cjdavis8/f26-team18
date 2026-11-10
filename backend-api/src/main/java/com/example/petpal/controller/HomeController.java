package com.example.petpal.controller;

import com.example.petpal.model.Provider;
import com.example.petpal.model.Review;
import com.example.petpal.repository.CustomerRepository;
import com.example.petpal.repository.ProviderRepository;
import com.example.petpal.repository.ReviewRepository;
import com.example.petpal.service.ProviderService;

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

    // Repository and service injections
    
    @Autowired
    private ProviderRepository ProviderRepository;

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

    // Logout button mapping
@PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/";
    }

    // Backend Endpoints for database

    @PostMapping("/provider/login")
public String loginProvider(@RequestParam String email, 
                            @RequestParam String password, 
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {
    Optional<Provider> providerOpt = ProviderRepository.findByEmail(email);

    if (providerOpt.isPresent()) {
        Provider provider = providerOpt.get();
        if (provider.getPassword().equals(password)) {
            // Save provider in session upon successful login
            session.setAttribute("loggedInProvider", provider);
            return "redirect:/provider/dashboard";
        }
    }

    // Login Error
    redirectAttributes.addFlashAttribute("error", "Invalid email or password for service provider account.");
    return "redirect:/login";
}

    // Shows Services of Provider
    public HomeController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // Mappings for services and providers

    @GetMapping("/services")
    public String viewServicesAndProviders(Model model) {
        List<Provider> providers = providerService.getAllProviders();
        model.addAttribute("providers", providers);
        return "provider/services"; 
    }

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/providers/{id}")
    public String viewProviderProfile(@PathVariable Long id, Model model) {
        Provider provider = providerService.getProviderById(id);
        
        // Fetch reviews for the provider
        List<Review> reviews = reviewRepository.findByProviderIdWithReplies(id);
        
        model.addAttribute("provider", provider);
        model.addAttribute("reviews", reviews);
        return "provider/provider";
    }

}
