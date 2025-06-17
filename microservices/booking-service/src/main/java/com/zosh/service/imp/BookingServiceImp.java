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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingServiceImp implements BookingService {

    @Autowired
private final BookingRepo bookingRepo;
    public BookingServiceImp(BookingRepo bookingRepo){
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking createBookingr(BookingRequest bookingRequest, UserDTO userDTO, SaloonDTO saloonDTO, Set<ServiceDTO> serviceDTOSet) throws Exception {
      int totalDuration = serviceDTOSet.stream().mapToInt(ServiceDTO::getDuration).sum();
        LocalDateTime bookingStartTime = bookingRequest.getStartTime();
        LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totalDuration);
        Boolean isSlotAvailable= isTimeSlotAvailable(saloonDTO,bookingStartTime,bookingEndTime);
        int totalPrice  = serviceDTOSet.stream().mapToInt(ServiceDTO::getPrice).sum();
        Set<Long> idList = serviceDTOSet.stream().map(ServiceDTO::getId).collect(Collectors.toSet());
        Booking newBooking  = new Booking();
//       //set all the values as custoemrID = userId, sloongID = salonid,seviceIDs = idList,tatus = BookingStatus.Pending,start/End= bookingStartEnd, totalPRove = totalPrice
//        bookingRepo.save(new Booking());
        return null;
    }

    public Boolean isTimeAvailable(SaloonDTO saloonDTO, LocalDateTime bookingStartTime, LocalDateTime bookingEndTime) throws  Exception {
        LocalDateTime saloonOpenDate = saloonDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
        LocalDateTime saloonCloseDate = saloonDTO.getCloseTime().atDate(bookingEndTime.toLocalDate());

        List<Booking> existingBooking = getBookingBySaloonId(saloonDTO.getId());
        if (bookingStartTime.isBefore(saloonOpenDate) || bookingEndTime.isAfter(saloonCloseDate)) {
            throw new Exception("Booking time is only done in saloon timing");
        }

        return null;
    }

    public Boolean isTimeSlotAvailable(SaloonDTO saloonDTO, LocalDateTime bookingStartTime, LocalDateTime bookingEndTime) throws Exception{
        List<Booking> existingBooking= getBookingBySaloonId(saloonDTO.getId());
        LocalDateTime saloonOpenDate = saloonDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
        LocalDateTime saloonCloseDate = saloonDTO.getCloseTime().atDate(bookingEndTime.toLocalDate());
        if (bookingStartTime.isBefore(saloonOpenDate) || bookingEndTime.isAfter(saloonCloseDate)) {
            throw new Exception("Booking time is only done in saloon timing");
        }
        for(Booking existingBookings:existingBooking){
            LocalDateTime existBookingStartTIme= existingBookings.getStartTime();
            LocalDateTime existBookingEndTime = existingBookings.getEndTime();
            if(bookingStartTime.isBefore(existBookingEndTime) && bookingEndTime.isBefore(existBookingStartTIme)){
                throw new Exception("SlotNot Available");
            }
            if(bookingStartTime.isEqual(existBookingStartTIme)|| bookingEndTime.isEqual((existBookingStartTIme))){
                throw new Exception("Slot should be in between Saloon Opening anda closed time");
            }
        }
        return true;
    }

    @Override
    public List<Booking> getBookingByCustomerId(Long customerId) {
        return bookingRepo.findByCustomerId(customerId);
    }

    @Override
    public List<Booking> getBookingBySaloonId(Long saloonId) {
        return bookingRepo.findBySaloonId(saloonId);
    }

    @Override
    public Booking getBookingById(Long id) throws Exception {
        Booking bokking = bookingRepo.findById(id).orElse(null);
        if(bokking == null)
        {
            throw new Exception("booking not found");
        }
        return bokking;
    }

    @Override
    public Booking updateBooking(Long bookingID, BookingStatus status) {
        Booking booking = bookingRepo.findById(bookingID).orElse(null);
        if(booking!=null){
            booking.setBookingStatus(status);
            return bookingRepo.save(booking);
        }
        return null;
    }

    @Override
    public List<Booking> getBookingByDate(LocalDate localDate, Long sallonID) {
List<Booking> allBookings = getBookingBySaloonId(sallonID);
if(localDate!=null){
   allBookings.stream().filter(booking->booking.getStartTime().toLocalDate().equals(localDate)||booking.getEndTime().toLocalDate().equals(localDate)).collect(Collectors.toList());
}

        return allBookings;
    }

    @Override
    public SaloonReport getSaloonReport(Long saloonID) {
        List<Booking> booking = bookingRepo.findBySaloonId(saloonID);
        int totalEarning = booking.stream().mapToInt(Booking::getTotalPrice).sum();
        Integer totalBokking = booking.size();
        List<Booking> cancelledBooking = booking.stream().filter(bookingProp->bookingProp.getBookingStatus().equals(BookingStatus.CANCEL)).collect(Collectors.toList());
             Double totalRefund= cancelledBooking.stream().mapToDouble(Booking::getTotalPrice).sum();
        SaloonReport saloonReport = new SaloonReport();
        saloonReport.setSaloonID(saloonID);
        saloonReport.setCancelledBooking(cancelledBooking.size());
        saloonReport.setTotalBooking(totalBokking);
        saloonReport.setTotalEarning(totalEarning);
        saloonReport.setTotalRefund(totalRefund);
        return saloonReport;
    }
}
