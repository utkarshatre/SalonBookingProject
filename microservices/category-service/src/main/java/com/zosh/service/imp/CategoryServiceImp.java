package com.zosh.service.imp;

import com.zosh.modal.Category;
import com.zosh.repository.CategoryRepo;
import com.zosh.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
//    @Autowired  //use any of that autowired or 14th RequiedArgsConstructor
    private final CategoryRepo categoryRepo ;
    @Override
    public Category createCategory(Category category, long saloonDTO) {
        Category category1 = new Category();
        category1.setName(category.getName());
        category1.setImage(category.getImage());
        category1.setSaloonid(saloonDTO);
        return categoryRepo.save(category1);
    }

    @Override
    public Set<Category> getAllCategoryBySaloon(Long id) throws Exception{
        Set<Category> categorySet= categoryRepo.findBySaloonId(id);
        if(categorySet!=null){
            return categorySet;
        }
        else{
            throw new Exception("Sallon ID not found to give you category");
        }
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category cat = categoryRepo.findById(id).orElse(null);
        if(cat==null){
            throw new Exception("Not Present of this Categry you are searching for");
        }
        else return cat;
    }

    @Override
    public void deleteCategoryById(Long id, Long saloonId) throws Exception {
Category category= getCategoryById(id);
if(category.getSaloonid().equals(saloonId)){
     categoryRepo.deleteById(id);
}
else{
    throw new Exception("please check your saloonId");
}
    }
}
