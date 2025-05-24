package com.zosh.salon.services.services.imp;

import com.zosh.salon.services.modal.Saloon;
import com.zosh.salon.services.payloadDTO.SaloonDTO;
import com.zosh.salon.services.payloadDTO.UserDTO;
import com.zosh.salon.services.repo.SaloonRepo;
import com.zosh.salon.services.services.SaloonService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.descriptor.web.WebXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SaloonServiceImpl implements SaloonService {
    @Autowired
    private final SaloonRepo saloonRepo;

    @Override
    public Saloon createSaloon(SaloonDTO saloon_Dto, UserDTO user_Dto) {
        Saloon s_obj = new Saloon();
        s_obj.setName(saloon_Dto.getName());
        s_obj.setCity(saloon_Dto.getCity());
        s_obj.setEmail(saloon_Dto.getEmail());
        s_obj.setAddress(saloon_Dto.getAddress());
        s_obj.setPhoneNumber(saloon_Dto.getPhoneNumber());
        s_obj.setImages(saloon_Dto.getImages());
        s_obj.setOpenTime(saloon_Dto.getOpenTime());
        s_obj.setCloseTime(saloon_Dto.getCloseTime());
        s_obj.setOwnerId(user_Dto.getId());         //as i want owner user ID
return saloonRepo.save(s_obj);

    }

    @Override
    public Saloon updateSaloon(SaloonDTO saloon_Dto, UserDTO user_Dto, Long saloonId) throws Exception {
        Saloon exsisting_Saloon = saloonRepo.findById(saloonId).orElse(null);
        if(!saloon_Dto.getOwnerId().equals(user_Dto.getId())){
            throw new Exception("You are not allowed to update the sallon");
        }
        if (exsisting_Saloon != null) {
            exsisting_Saloon.setName(saloon_Dto.getName());
            exsisting_Saloon.setCity(saloon_Dto.getCity());
            exsisting_Saloon.setAddress(saloon_Dto.getAddress());
            exsisting_Saloon.setImages(saloon_Dto.getImages());
            exsisting_Saloon.setEmail(saloon_Dto.getEmail());
            exsisting_Saloon.setOpenTime(saloon_Dto.getOpenTime());
            exsisting_Saloon.setCloseTime(saloon_Dto.getCloseTime());
            exsisting_Saloon.setPhoneNumber(saloon_Dto.getPhoneNumber());
            exsisting_Saloon.setOwnerId(user_Dto.getId());
            return saloonRepo.save(exsisting_Saloon);
        }
        throw new Exception("Saloon Not Found");
    }

    @Override
    public List<Saloon> getAllSaloon() throws Exception {
        return saloonRepo.findAll();
    }

    @Override
    public Saloon getSaloonById(Long saloonId) throws Exception {
        Saloon exsisting_Saloon =  saloonRepo.findById(saloonId).orElse(null);
        if(exsisting_Saloon!=null){
            return exsisting_Saloon;
        }
        throw new Exception("Saloon Not found with id: "+saloonId);
    }



    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return saloonRepo.findByOwnerId(ownerId);
    }

    @Override
    public List<Saloon> searchSaloonBYCity(String city) {
        return saloonRepo.searchSaloons(city);
    }
}
