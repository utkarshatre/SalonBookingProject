package com.zosh.service_offering.service;

import com.zosh.service_offering.ServiceOfferingApplication;
import com.zosh.service_offering.dto.CategoryDTO;
import com.zosh.service_offering.dto.SaloonDTO;
import com.zosh.service_offering.dto.ServiceDTO;
import com.zosh.service_offering.modal.ServiceOffering;

import java.util.Set;

public interface ServiceOfferingService {
    ServiceOffering serviceOffering(ServiceDTO serivceDto, CategoryDTO categoryDto, SaloonDTO saloonDtO);
    ServiceOffering updateService(Long serviceid, ServiceOffering service);
    Set<ServiceOffering> getALlserviceBySaloonId(Long saloonID, Long CategoryId);
    Set<ServiceOffering> getServiceBYIDs(Set<Long> ids);
    ServiceOffering getServiceByID(Long id) throws Exception;
}
