package com.zosh.service.imp;

import com.zosh.domain.BookingStatus;
import com.zosh.dto.BookingRequest;
import com.zosh.dto.SaloonDTO;
import com.zosh.dto.ServiceDTO;
import com.zosh.dto.UserDTO;
import com.zosh.modal.Booking;
import com.zosh.modal.SaloonReport;
import com.zosh.repi.BookingRepo;
import com.zosh.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Service
public class BookingServiceImp implements BookingService {

    @Autowired
private final BookingRepo bookingRepo;
    public BookingServiceImp(BookingRepo bookingRepo){
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking createBookingr(BookingRequest bookingRequest, UserDTO userDTO, SaloonDTO saloonDTO, Set<ServiceDTO> serviceDTOS) {
        return null;
    }

    @Override
    public List<Booking> getBookingByCustomerId(Long customerId) {
        return List.of();
    }

    @Override
    public List<Booking> getBookingBySaloonId(Long saloonId) {
        return List.of();
    }

    @Override
    public Booking getBookingById(Long id) {
        return null;
    }

    @Override
    public Booking updateBooking(Long bookingID, BookingStatus status) {
        return null;
    }

    @Override
    public List<Booking> getBookingByDate(LocalDate localDate, Long sallonID) {
        return List.of();
    }

    @Override
    public SaloonReport getSaloonReport(Long saloonID) {
        return null;
    }
}
