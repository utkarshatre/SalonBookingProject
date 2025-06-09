package com.zosh.repi;

import com.zosh.modal.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Long> {
    List<Booking> findByCustomerId(Long customerId);
    List<Booking> findBySaloonId(Long saloonId);

}
