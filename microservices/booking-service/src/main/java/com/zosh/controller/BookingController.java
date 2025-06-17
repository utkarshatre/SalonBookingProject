package com.zosh.controller;

import com.zosh.domain.BookingStatus;
import com.zosh.dto.*;
import com.zosh.mapper.BookingMapper;
import com.zosh.modal.Booking;
import com.zosh.modal.SaloonReport;
import com.zosh.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
@PostMapping("/")
    public ResponseEntity<Booking> createBooking(@RequestParam Long saloonId, @RequestBody BookingRequest bookingRequest) throws Exception{
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(saloonId);
        UserDTO user= new UserDTO();
        user.setId(1l);
        Set<ServiceDTO> serviceDTOSet = new HashSet<>();
        ServiceDTO serviceDTO= new ServiceDTO();
        serviceDTO.setName("Hair Cut For Men");
        serviceDTO.setId(1l);
        serviceDTO.setPrice(300);
        serviceDTO.setDuration(45);
        serviceDTOSet.add(serviceDTO);
        Booking booking = bookingService.createBookingr(bookingRequest,user,saloonDTO,serviceDTOSet);
        return ResponseEntity.ok(booking);
    }
    @GetMapping("/customer")
    public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer(){
        List<Booking> bookings = bookingService.getBookingByCustomerId(1l);

        return ResponseEntity.ok(getBookingDTOs(bookings));
    }
    private Set<BookingDTO> getBookingDTOs(List<Booking> bookings){
        return bookings.stream().map(booking-> {
            return BookingMapper.toDTO(booking);
        }).collect(Collectors.toSet());
    }

    @GetMapping("/saloon")
    public ResponseEntity<Set<BookingDTO>> getBookingBySalon(){
        List <Booking> bookings = bookingService.getBookingByCustomerId(1l);
        return ResponseEntity.ok(getBookingDTOs(bookings));
    }

    @GetMapping("/bookingId")
    public ResponseEntity<BookingDTO> getBookingBYID(@PathVariable Long id) throws  Exception{
        Booking booking = bookingService.getBookingById(id);
        return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<BookingDTO> updateBookingStatus(@PathVariable Long id, @RequestParam BookingStatus status)throws Exception{
Booking booking = bookingService.updateBooking(id, status);
return ResponseEntity.ok(BookingMapper.toDTO(booking));
    }

    @GetMapping("/slots/salon/{saloonid}/date/{date}")
    public ResponseEntity<List<BookingSlotDTO>> getBookingSlot (@PathVariable Long saloonid, @RequestParam LocalDateTime date){
List<Booking>bookings=bookingService.getBookingByDate(date, saloonid);
List <BookingSlotDTO> slotDTOS = bookings.stream().map(booking->{
    BookingSlotDTO slots = new BookingSlotDTO();
    slots.setStartTime(booking.getStartTime());
    slots.setEndTime(booking.getEndTime());
    return slots;
}).collect(Collectors.toList());
return ResponseEntity.ok(slotDTOS);
    }

    @GetMapping("/report")
    public ResponseEntity<SaloonReport> getSaloonReport() throws Exception{
        SaloonReport saloonReport = bookingService.getSaloonReport(1l);
        return ResponseEntity.ok(saloonReport);
    }

}


