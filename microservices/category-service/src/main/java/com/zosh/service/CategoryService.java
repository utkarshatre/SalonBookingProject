package com.zosh.service;

import com.zosh.modal.Category;

import java.util.Set;

public interface CategoryService {
    Category createCategory(Category category, long saloonDTO);
    Set<Category> getAllCategoryBySaloon(Long id) throws Exception;
    Category getCategoryById(Long id) throws Exception;
    void deleteCategoryById(Long id, Long SaloonId) throws Exception;
}
