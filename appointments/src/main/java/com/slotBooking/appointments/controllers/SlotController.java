package com.slotBooking.appointments.controllers;

import com.slotBooking.appointments.entity.Slot;
import com.slotBooking.appointments.service.SlotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    // Show create slot form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("slot", new Slot());
        return "create_slot";
    }

    // Handle create slot submission
    @PostMapping("/create")
    public String createSlot(@ModelAttribute("slot") Slot slot) {
        slotService.createSlot(slot);
        return "redirect:/"; // Go back to home
    }

    // View all slots
    @GetMapping("/view")
    public String viewSlots(Model model) {
        model.addAttribute("slots", slotService.getAllSlots());
        return "view_slots"; // Optional view_slots.html
    }
}