package tr.com.api_coffee_shop.controller;

import org.springframework.web.bind.annotation.*;
import tr.com.api_coffee_shop.exception.ResourceNotFoundException_404;
import tr.com.api_coffee_shop.model.Category;
import tr.com.api_coffee_shop.service.CategoryService;
import tr.com.api_coffee_shop.util.PathConstant;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(PathConstant.BASE_ENDPOINT_PROD)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping({"/categories"})
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping({"/categories/parent"})
    public List<Category> getAllParentCategories() {
        return categoryService.getAllParentCategories();
    }

    @GetMapping({"/categories/sub"})
    public List<Category> getAllSubCategories() {
        return categoryService.getAllSubCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable(name = "id") String id) throws ResourceNotFoundException_404 {
        return categoryService.getCategory(id);
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public Boolean deletCategory(@PathVariable(name = "id") String id) throws ResourceNotFoundException_404 {
        return categoryService.deleteCategory(id);
    }

}
