package com.example.petpal.mvc;


import com.example.petpal.dto.*;
import com.example.petpal.repository.*;
import com.example.petpal.entity.Customer;
import com.example.petpal.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerUiController {

    private final CustomerService customerService;
    private final BookingService bookingService;
    private final CustomerRepository customerRepository;

    public CustomerUiController(
            CustomerService customerService,
            BookingService bookingService,
            CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.bookingService = bookingService;
        this.customerRepository = customerRepository;
    }


    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long customerId = UiSession.requireId(session, "customer");
        model.addAttribute("customer", customerService.getProfile(customerId));
        //model.addAttribute("bookings", bookingService.listForCustomer(customerId));
        return "customer/dashboard";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        model.addAttribute("customer",
                customerService.getProfile(UiSession.requireId(session, "customer")));
        return "customer/profile";
    }

}