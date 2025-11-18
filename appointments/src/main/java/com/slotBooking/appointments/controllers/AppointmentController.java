package com.slotBooking.appointments.controllers;

import com.slotBooking.appointments.entity.Appointment;
import com.slotBooking.appointments.service.AppointmentService;
import com.slotBooking.appointments.service.SlotService;
import com.slotBooking.appointments.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final UserService userService;
    private final SlotService slotService;

    public AppointmentController(AppointmentService appointmentService,
                                 UserService userService,
                                 SlotService slotService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
        this.slotService = slotService;
    }

    // Show booking form
    @GetMapping("/book")
    public String showBookForm(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("slots", slotService.getAvailableSlots());
        model.addAttribute("appointment", new Appointment());
        return "book_appointment";
    }

    // Handle booking submission
    @PostMapping("/book")
    public String bookAppointment(@RequestParam Long userId,
                                  @RequestParam Long slotId,
                                  Model model) {
        try {
            appointmentService.bookAppointment(userId, slotId);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "book_appointment"; // Stay on booking page with error
        }
        return "redirect:/appointments/view";
    }

    // View all appointments
    @GetMapping("/view")
    public String viewAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "view_appointments";
    }

    // Cancel appointment
    @PostMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable Long id, Model model) {
        try {
            appointmentService.cancelAppointment(id);
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/appointments/view";
    }

    // Optional: view a single appointment
    @GetMapping("/view/{id}")
    public String getAppointmentById(@PathVariable Long id, Model model) {
        model.addAttribute("appointment", appointmentService.getAppointmentById(id));
        return "view_appointment";
    }
}