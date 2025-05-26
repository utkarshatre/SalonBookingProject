package com.zosh.repository;

import com.zosh.modal.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query("select s from Category s where "+"(s.saloonid = :saloonid)")
    Set<Category>  findBySaloonId(@Param("saloonid") Long saloonid);
}
