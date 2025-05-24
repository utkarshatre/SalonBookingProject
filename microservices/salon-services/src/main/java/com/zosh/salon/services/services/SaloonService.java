package com.zosh.salon.services.services;

import com.zosh.salon.services.modal.Saloon;
import com.zosh.salon.services.payloadDTO.SaloonDTO;
import com.zosh.salon.services.payloadDTO.UserDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

public interface SaloonService {
    Saloon createSaloon(SaloonDTO saloon_Dto, UserDTO user_Dto);
    Saloon updateSaloon(SaloonDTO saloon_Dto, UserDTO user_Dto, Long saloonId) throws Exception;
    List<Saloon> getAllSaloon() throws Exception;
    Saloon getSaloonById(Long SaloonId)  throws Exception;
    Saloon getSaloonByOwnerId(Long ownerId);
    List<Saloon> searchSaloonBYCity(String city);

}
