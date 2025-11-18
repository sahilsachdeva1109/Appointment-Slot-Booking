package com.slotBooking.appointments.repository;

import com.slotBooking.appointments.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
