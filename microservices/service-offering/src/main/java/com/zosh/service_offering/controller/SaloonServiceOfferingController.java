package com.zosh.service_offering.controller;

import com.zosh.service_offering.dto.CategoryDTO;
import com.zosh.service_offering.dto.SaloonDTO;
import com.zosh.service_offering.dto.ServiceDTO;
import com.zosh.service_offering.modal.ServiceOffering;
import com.zosh.service_offering.service.ServiceOfferingService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering/saloon-owner")
public class SaloonServiceOfferingController {

    public final ServiceOfferingService serviceOfferingservice;

    public SaloonServiceOfferingController(ServiceOfferingService serviceOffering1){
        this.serviceOfferingservice = serviceOffering1;
    }
@PostMapping("/")
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDTO serviceDTO) throws Exception {
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);
    CategoryDTO categoryDTO = new CategoryDTO();
    categoryDTO.setId(1l);
//        ServiceOffering cratedSet = serviceOfferingservice.updateService("id",serviceOfferingservice);
ServiceOffering create = serviceOfferingservice.getServiceByID(saloonDTO.getId());
    return ResponseEntity.ok(create);
    }


    @PostMapping("/")
    public ResponseEntity<ServiceOffering> updateService(
            @PathVariable Long id,
            @RequestBody ServiceOffering serviceOffering){
        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1L);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1l);
        ServiceOffering cratedSet = serviceOfferingservice.updateService(id,serviceOffering );
        return ResponseEntity.ok(cratedSet);
    }
}
