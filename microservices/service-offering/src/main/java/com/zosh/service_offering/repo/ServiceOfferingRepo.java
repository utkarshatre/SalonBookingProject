package com.zosh.service_offering.repo;

import com.zosh.service_offering.modal.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ServiceOfferingRepo extends JpaRepository<ServiceOffering, Long> {
        Set<ServiceOffering> findBySaloonIdJPA(Long saloonId);
}
