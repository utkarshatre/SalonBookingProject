package com.zosh.service;

import com.zosh.dto.BookingRequest;
import com.zosh.dto.SaloonDTO;
import com.zosh.dto.ServiceDTO;
import com.zosh.dto.UserDTO;
import com.zosh.modal.Booking;

import java.util.List;
import java.util.Set;

public interface BookingService {
    Booking createBookingr(BookingRequest bookingRequest, UserDTO userDTO, SaloonDTO saloonDTO, Set<ServiceDTO> serviceDTOS);
    List<Booking> getBookingByCustomerId(Long customerId);
    List<Booking> getBookingBySaloonId(Long saloonId);
    List<Booking> getBookingById(Long id);

}
