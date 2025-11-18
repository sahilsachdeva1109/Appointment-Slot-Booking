package com.slotBooking.appointments.service;

import com.slotBooking.appointments.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment bookAppointment(Long userId, Long slotId);

    Appointment getAppointmentbyId(Long id);

    List<Appointment> getAllAppointments();

    String cancelAppointment(Long appointmentId);


}
