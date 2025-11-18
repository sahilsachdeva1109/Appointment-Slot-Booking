package com.slotBooking.appointments.service;

import com.slotBooking.appointments.entity.Slot;
import com.slotBooking.appointments.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotServiceImpl implements SlotService{

    private final SlotRepository slotRepository;

    public SlotServiceImpl(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @Override
    public List<Slot> getAvailableSlots() {
        return slotRepository.findAll().stream().filter(slot -> !slot.isBooked()).collect(Collectors.toList());
    }

    @Override
    public Slot getSlotById(Long id) {
        return slotRepository.findById(id).orElse(null);
    }
}
