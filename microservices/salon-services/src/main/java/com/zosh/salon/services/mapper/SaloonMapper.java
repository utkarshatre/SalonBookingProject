package com.zosh.salon.services.mapper;

import com.zosh.salon.services.modal.Saloon;
import com.zosh.salon.services.payloadDTO.SaloonDTO;

public class SaloonMapper {
    public static SaloonDTO mapToSaloon(Saloon saloon){

SaloonDTO saloonDto = new SaloonDTO();
saloonDto.setId(saloon.getId());
saloonDto.setName(saloon.getName());
saloonDto.setCity(saloon.getCity());
saloonDto.setEmail(saloon.getEmail());
saloonDto.setAddress(saloon.getAddress());
saloonDto.setPhoneNumber(saloon.getPhoneNumber());
saloonDto.setImages(saloon.getImages());
saloonDto.setCloseTime(saloon.getCloseTime());
saloonDto.setOpenTime(saloon.getOpenTime());
saloonDto.setOwnerId(saloon.getOwnerId());

return saloonDto;
    }
}

