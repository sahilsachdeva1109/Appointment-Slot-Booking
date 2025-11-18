package com.slotBooking.appointments.repository;

import com.slotBooking.appointments.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot,Long> {
}
