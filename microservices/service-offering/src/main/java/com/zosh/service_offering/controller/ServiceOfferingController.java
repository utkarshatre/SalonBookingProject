package com.zosh.service_offering.controller;

import com.zosh.service_offering.modal.ServiceOffering;
import com.zosh.service_offering.service.ServiceOfferingService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/service-offering/saloon-owner")
public class ServiceOfferingController {

    private final ServiceOfferingService serviceOfferingServiceG;

    public ServiceOfferingController(ServiceOfferingService serviceOfferingService){
        this.serviceOfferingServiceG = serviceOfferingService;
    }
@GetMapping("/saloon/{saloonId}")
    public ResponseEntity<Set<ServiceOffering>> getALlServiceBySaloonId(@PathVariable("saloonId") Long id, @RequestParam(required = false) Long categoryId){
Set<ServiceOffering> serviceOfferings = serviceOfferingServiceG.getALlserviceBySaloonId(id, categoryId);
return ResponseEntity.ok(serviceOfferings);
    }

    @GetMapping("/{id}")
public ResponseEntity<ServiceOffering> getServiceByID(@PathVariable Long id) throws Exception{
        ServiceOffering serviceOfferings = serviceOfferingServiceG.getServiceByID(id) ;
return ResponseEntity.ok(serviceOfferings);
    }
}
