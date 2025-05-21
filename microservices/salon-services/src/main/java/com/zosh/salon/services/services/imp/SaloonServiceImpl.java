package com.zosh.salon.services.services.imp;

import com.zosh.salon.services.modal.Saloon;
import com.zosh.salon.services.payloadDTO.UserDTO;
import com.zosh.salon.services.repo.SaloonRepo;
import com.zosh.salon.services.services.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SaloonServiceImpl implements SaloonService {
    @Autowired
    private final SaloonRepo saloonRepo;
    @Override
    public Saloon createSaloon(SaloonService saloon_Dto, UserDTO user_Dto) {
        return null;
    }

    @Override
    public Saloon updateSaloon(SaloonService saloon_Dto, UserDTO user_Dto, Long saloonId) {
        return null;
    }

    @Override
    public List<Saloon> getAllSaloon() {
        return List.of();
    }

    @Override
    public Saloon getSaloonById(Long SaloonId) {
        return null;
    }

    @Override
    public Saloon getSaloonByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<Saloon> searchSaloonBYCity(String city) {
        return List.of();
    }
}
