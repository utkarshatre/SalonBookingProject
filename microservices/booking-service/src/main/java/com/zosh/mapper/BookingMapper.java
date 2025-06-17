package com.zosh.mapper;

import com.zosh.dto.BookingDTO;
import com.zosh.modal.Booking;

public class BookingMapper {
    public static BookingDTO toDTO (Booking booking){
        BookingDTO bookingDto = new BookingDTO();
        bookingDto.setId(booking.getId());
        bookingDto.setBookingStatus(booking.getBookingStatus());
        bookingDto.setCustomerId(booking.getCustomerId());
        bookingDto.setSaloonId(bookingDto.getCustomerId());
        bookingDto.setEndTime(booking.getEndTime());
        bookingDto.setServiceIds(booking.getServiceIds());
        bookingDto.setStartTime(booking.getStartTime());
        return bookingDto;
    }
}

