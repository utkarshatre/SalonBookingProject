package com.zosh.salon.services.repo;

import com.zosh.salon.services.modal.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaloonRepo extends JpaRepository<Saloon,Long> {
    Saloon findByOwnerID(Long Id);  //Here findBy is static and ownerID ismy parameter, its strick way as its means to the JPA
    @Query("select s from Saloon s where"+"(lower(s.name) like lower(concat('%',:keyword,'%')) OR" +
            "(lower(s.city) like lower(concat('%',:keyword,'%')) OR "+
            "(lower(s.name) like lower(concat('%',:keyword,'%') ))))"
    )
    List<Saloon> searchSaloons(@Param("keyword") String keyword);
}
