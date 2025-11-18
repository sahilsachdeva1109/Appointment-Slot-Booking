package com.slotBooking.appointments.controllers;

import com.slotBooking.appointments.entity.Appointment;
import com.slotBooking.appointments.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    // Book appointment
    @PostMapping("/book")
    public Appointment bookAppointment(@RequestParam long userId , @RequestParam long slotId){
        return appointmentService.bookAppointment(userId , slotId);
    }



    // get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentbyId(id);
    }


    // get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }


    // cancel appointment
    @DeleteMapping("/cancel/{id}")
    public String cancelAppointment(@PathVariable long id){
        return appointmentService.cancelAppointment(id);
    }

}
