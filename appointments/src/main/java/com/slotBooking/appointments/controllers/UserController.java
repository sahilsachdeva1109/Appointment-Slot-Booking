package com.slotBooking.appointments.controllers;

import com.slotBooking.appointments.entity.User;
import com.slotBooking.appointments.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Show user registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register_user";
    }

    // Handle form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/"; // Go back to home
    }

    // Optional: List all users
    @GetMapping("/view")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "view_users"; // You can create a view_users.html if needed
    }
}