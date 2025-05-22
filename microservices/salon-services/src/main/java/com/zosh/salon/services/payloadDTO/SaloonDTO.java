package com.zosh.salon.services.payloadDTO;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;
@Data
public class SaloonDTO {
    private Long Id;
    private String name;
    private List<String> images;
    private String address;
    private String phoneNumber;
    private String email;
    private String city;
    private Long ownerId;
    private LocalTime openTime;
    private LocalTime closeTime;
//    private UserDTO saloonOwner;
}
