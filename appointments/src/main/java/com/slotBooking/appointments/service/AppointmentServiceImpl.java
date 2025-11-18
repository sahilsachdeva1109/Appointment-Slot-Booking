package com.slotBooking.appointments.service;

import com.slotBooking.appointments.entity.Appointment;
import com.slotBooking.appointments.entity.Slot;
import com.slotBooking.appointments.entity.User;
import com.slotBooking.appointments.repository.AppointmentRepository;
import com.slotBooking.appointments.repository.SlotRepository;
import com.slotBooking.appointments.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final SlotRepository slotRepository;

    private final AppointmentRepository appointmentRepository;

    private final UserRepository userRepository;

    public AppointmentServiceImpl(SlotRepository slotRepository, AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.slotRepository = slotRepository;
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Appointment bookAppointment(Long userId, Long slotId) {
        // if user exists or not
        User user  = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new RuntimeException("User not Found");
        }

        // check if slot exists
        Slot slot = slotRepository.findById(slotId).orElse(null);
        if(slot == null){
            throw new RuntimeException("Slot not found");
        }

        // check if slot is already booked
        if(slot.isBooked()){
            throw new RuntimeException("Slot already booked !!");
        }

        // mark the slot as booked

        slot.setBooked(true);
        slotRepository.save(slot);


        // create appointment
        Appointment appointment = new Appointment(user,slot);
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public String cancelAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
        if(appointment == null){
            return "Appointment not Found";
        }

        // mark slot as available again
        Slot slot = appointment.getSlot();
        slot.setBooked(false);
        slotRepository.save(slot);

        // update as cancelled
        appointment.setStatus("CANCELLED");
        appointmentRepository.save(appointment);

        return "Appointment cancelled Successfully! ";
    }
}
