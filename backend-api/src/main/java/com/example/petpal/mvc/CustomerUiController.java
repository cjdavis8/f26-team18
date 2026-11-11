package com.example.petpal.mvc;


import com.example.petpal.dto.*;
import com.example.petpal.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerUiController {

    private final CustomerService customerService;
    private final BookingService bookingService;

    public CustomerUiController(
            CustomerService customerService,
            BookingService bookingService) {
        this.customerService = customerService;
        this.bookingService = bookingService;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        Long customerId = UiSession.requireId(session, "customer");
        model.addAttribute("customer", customerService.getProfile(customerId));
        model.addAttribute("bookings", bookingService.listForCustomer(customerId));
        return "customer/dashboard";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        model.addAttribute("customer",
                customerService.getProfile(UiSession.requireId(session, "customer")));
        return "customer/profile";
    }

}