package com.zosh.service_offering.service.imp;
import com.zosh.service_offering.dto.CategoryDTO;
import com.zosh.service_offering.dto.SaloonDTO;
import com.zosh.service_offering.dto.ServiceDTO;
import com.zosh.service_offering.modal.ServiceOffering;
import com.zosh.service_offering.repo.ServiceOfferingRepo;
import com.zosh.service_offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServiceOfferingImp  implements ServiceOfferingService {

    private final ServiceOfferingRepo serviceOfferingRepo;
    @Override
    public ServiceOffering serviceOffering(ServiceDTO serivceDto, CategoryDTO categoryDto, SaloonDTO saloonDtO) {
        ServiceOffering serOff = new ServiceOffering();
        serOff.setName(serivceDto.getName());
        serOff.setImage(serivceDto.getImage());
        serOff.setPrice(serivceDto.getPrice());
        serOff.setDescription(serivceDto.getDescription());
        serOff.setDuration(serivceDto.getDuration());
        serOff.setCategoryId(categoryDto.getId());
        serOff.setSaloonId(saloonDtO.getId());
        return serviceOfferingRepo.save(serOff);
    }

    @Override
    public ServiceOffering updateService(Long serviceid, ServiceOffering service) {
        ServiceOffering updateSer = new ServiceOffering();
        ServiceOffering serBasedOnId= serviceOfferingRepo.findById(serviceid).orElse(null);
        if(serBasedOnId!=null){
            serBasedOnId.setName(service.getName());
            serBasedOnId.setImage(service.getImage());
            serBasedOnId.setDuration(service.getDuration());
            serBasedOnId.setDescription(service.getDescription());
            return serviceOfferingRepo.save(serBasedOnId);
        }
      throw new RuntimeException("Please Check the Serive selection");

    }

    @Override
    public Set<ServiceOffering> getALlserviceBySaloonId(Long saloonID, Long categoryId) {
        Set<ServiceOffering> services= serviceOfferingRepo.findBySaloonIdJPA(saloonID);
            if(categoryId!=null){
                services = services.stream().filter((service)->service.getCategoryId()!=null && service.getCategoryId().equals(categoryId)).collect(Collectors.toSet());
            }
    return services;
    }

    @Override
    public Set<ServiceOffering> getServiceBYIDs(Set<Long> ids) {
      List<ServiceOffering> serviceOfferingList= serviceOfferingRepo.findAllById(ids);
        return new HashSet<>(serviceOfferingList);
    }

    @Override
    public ServiceOffering getServiceByID(Long id) throws Exception {
        ServiceOffering serviceOfferingVar = serviceOfferingRepo.findById(id).orElse(null);
        if(serviceOfferingVar!=null) return serviceOfferingVar;
        else throw new Exception("Service Not Exist");
    }

}

