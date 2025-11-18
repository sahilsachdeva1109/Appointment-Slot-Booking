package com.slotBooking.appointments.service;

import com.slotBooking.appointments.entity.Slot;

import java.util.List;

public interface SlotService  {

    Slot createSlot( Slot slot);

    List<Slot> getAllSlots();

    List<Slot> getAvailableSlots();

    Slot getSlotById(Long id);

}
