package com.zosh.salon.services.controller;

import com.zosh.salon.services.mapper.SaloonMapper;
import com.zosh.salon.services.modal.Saloon;
import com.zosh.salon.services.payloadDTO.SaloonDTO;
import com.zosh.salon.services.payloadDTO.UserDTO;
import com.zosh.salon.services.services.SaloonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor //because we are using service as private or we can use autowired
@RequestMapping("/api/saloons")
public class SaloonController {

    private final SaloonService saloonService ;
    @PostMapping("/")
    public ResponseEntity<SaloonDTO> createSaloonApi(@RequestBody @Valid SaloonDTO sDto){
    UserDTO uDto = new UserDTO();
    uDto.setId(1L);
      Saloon createdSaloon=  saloonService.createSaloon(sDto,uDto);
      SaloonDTO saloonDTO1 = SaloonMapper.mapToSaloon(createdSaloon);
      return ResponseEntity.ok(saloonDTO1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SaloonDTO> updateSaloonApi(@RequestBody @Valid SaloonDTO sDto,
                                                  @PathVariable("id") Long saloonId) throws Exception{
    UserDTO uDto = new UserDTO();
    uDto.setId(1L);
    Saloon saloonUpdate =saloonService.updateSaloon(sDto,uDto,saloonId);
    SaloonDTO saloonDTO1 = SaloonMapper.mapToSaloon(saloonUpdate);
    return ResponseEntity.ok(saloonDTO1);
    }
@GetMapping("/")
    public ResponseEntity<List<SaloonDTO>> getSaloons(){
        List<Saloon> allSaloons = saloonService.getAllSaloon();
//        line 43 to 44 for cenversion of sallon to saloonDto,as its a list
//        SaloonDTO saloonDTO1 = SaloonMapper.mapToSaloon((Saloon) allSaloons);
//        return ResponseEntity.ok(saloonDTO1);
//        line 46 to end for convertion of same using stream, as its a list
    List<SaloonDTO> saloonDTOLists = allSaloons.stream().map((item)->{
        SaloonDTO mappedSaloonDto= SaloonMapper.mapToSaloon(item);
        return  mappedSaloonDto;
    }
    ).toList();
    return ResponseEntity.ok(saloonDTOLists);
    }
}
