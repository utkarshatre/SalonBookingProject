package com.zosh.controller;

import com.zosh.modal.Category;
import com.zosh.payloadDTO.SaloonDTO;
import com.zosh.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories/salon-owner")
public class SaloonCategoryController {
//    @Autowired
    private final CategoryService categoryService;
    @PostMapping("/")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        SaloonDTO saloonDTO= new SaloonDTO();
        saloonDTO.setId(1L);
        return ResponseEntity.ok(categoryService.createCategory(category,saloonDTO.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long catId ) throws Exception {
    SaloonDTO saloonDTO = new SaloonDTO();
    saloonDTO.setId(1L);
     categoryService.deleteCategoryById(catId, saloonDTO.getId());
        return ResponseEntity.ok("deleted");
    }
}
