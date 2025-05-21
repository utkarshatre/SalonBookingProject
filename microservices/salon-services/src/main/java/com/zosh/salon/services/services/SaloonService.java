package com.zosh.salon.services.services;

import com.zosh.salon.services.modal.Saloon;
import com.zosh.salon.services.payloadDTO.UserDTO;

import java.util.List;

public interface SaloonService {
    Saloon createSaloon(SaloonService saloon_Dto, UserDTO user_Dto);
    Saloon updateSaloon(SaloonService saloon_Dto, UserDTO user_Dto, Long saloonId);
    List<Saloon> getAllSaloon();
    Saloon getSaloonById(Long SaloonId);
    Saloon getSaloonByOwnerId(Long ownerId);
    List<Saloon> searchSaloonBYCity(String city);


}
