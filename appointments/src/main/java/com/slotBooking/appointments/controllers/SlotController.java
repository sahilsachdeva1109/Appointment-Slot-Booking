package com.slotBooking.appointments.controllers;

import com.slotBooking.appointments.entity.Slot;
import com.slotBooking.appointments.service.SlotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    private final SlotService slotService;


    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping("/create")
    public Slot createSlot(@RequestBody Slot slot){
        return slotService.createSlot(slot);
    }

    @GetMapping("/available")
    public List<Slot> getAvailableSlots(){
        return slotService.getAvailableSlots();
    }

    @GetMapping
    public List<Slot> getAllSlots(){
        return slotService.getAllSlots();
    }

    @GetMapping("/{id}")
    public Slot getSlotById(@PathVariable Long id) {
        return slotService.getSlotById(id);
    }

}
