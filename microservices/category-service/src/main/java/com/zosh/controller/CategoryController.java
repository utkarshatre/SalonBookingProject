package com.zosh.controller;
import com.zosh.modal.Category;
import com.zosh.repository.CategoryRepo;
import com.zosh.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController()
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

private final CategoryService categoryService;

@GetMapping("/salooncategory/{id}")
    public ResponseEntity<Set<Category>> getCategoryBySaloon (@PathVariable Long id) throws Exception {
    Set<Category> categorySet = categoryService.getAllCategoryBySaloon(id);
    if (categorySet != null) {
        return ResponseEntity.ok(categorySet);
    }
    return ResponseEntity.notFound().build();
}

@GetMapping("/saloon/{id}")
    public ResponseEntity<Category> getCategoryByIdApi(@PathVariable Long id) throws Exception{
    Category category = categoryService.getCategoryById(    id);
    if(category!=null) {
        return ResponseEntity.ok(category);
    }
    else{
        return ResponseEntity.notFound().build();
    }
}
}

