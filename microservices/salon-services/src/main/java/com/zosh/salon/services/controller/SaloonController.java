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

//http:'//localhost:8081/api.saloons/
    @PostMapping("/")
    public ResponseEntity<SaloonDTO> createSaloonApi(@RequestBody @Valid SaloonDTO sDto){
    UserDTO uDto = new UserDTO();
    uDto.setId(1L);
      Saloon createdSaloon=  saloonService.createSaloon(sDto,uDto);
      SaloonDTO saloonDTO1 = SaloonMapper.mapToSaloon(createdSaloon);
      return ResponseEntity.ok(saloonDTO1);
    }

//    http:'//localhost:8081/api.saloons/2
    @PatchMapping("/{id}")
    public ResponseEntity<SaloonDTO> updateSaloonApi(@RequestBody @Valid SaloonDTO sDto,
                                                  @PathVariable("id") Long saloonId) throws Exception{
    UserDTO uDto = new UserDTO();
    uDto.setId(1L);
    Saloon saloonUpdate =saloonService.updateSaloon(sDto,uDto,saloonId);
    SaloonDTO saloonDTO1 = SaloonMapper.mapToSaloon(saloonUpdate);
    return ResponseEntity.ok(saloonDTO1);
    }

//http:'//localhost:8081/api.saloons
    @GetMapping()
    public ResponseEntity<List<SaloonDTO>> getSaloons() throws Exception{
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

    ///http:'//localhost:8081/api.saloons/2
    @GetMapping("/{id}")
    public ResponseEntity<SaloonDTO> getSaloonsById(@PathVariable("id") Long saloonId) throws  Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloonData  = saloonService.getSaloonById(saloonId) ;
        SaloonDTO saloonDTO = SaloonMapper.mapToSaloon(saloonData);
        return ResponseEntity.ok(saloonDTO);
    }

//    search?city=mumbai
//    http://localhost:8081/api.saloons/search?city=mumbai
    @GetMapping("/search") //we ont provide owner ID becuase it will comes from jwt token
    public ResponseEntity<List<SaloonDTO>> getSaloonListByCity(@RequestParam("city") String city) throws Exception{
        List<Saloon> saloons = saloonService.searchSaloonBYCity(city);
        List<SaloonDTO> saloonDTO = saloons.stream().map((item)->{
            SaloonDTO saloonDTO1 = SaloonMapper.mapToSaloon(item);
            return saloonDTO1;
        }).toList();
        return ResponseEntity.ok(saloonDTO);
    }

    ///http:'//localhost:8081/api.saloons/owner/2
    @GetMapping("/owner/{owner}")
    public ResponseEntity<SaloonDTO> getSaloonsByOwnerId(@PathVariable("owner") Long saloonId) throws  Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Saloon saloonData  = saloonService.getSaloonByOwnerId(saloonId) ;
        SaloonDTO saloonDTO = SaloonMapper.mapToSaloon(saloonData);
        return ResponseEntity.ok(saloonDTO);
    }
}
