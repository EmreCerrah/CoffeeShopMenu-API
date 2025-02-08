package tr.com.api_labianco.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.api_labianco.exception.ResourceNotFoundException_404;
import tr.com.api_labianco.model.Category;
import tr.com.api_labianco.repository.CategoryRepository;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional (readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    @Transactional (readOnly = true)
    public List<Category> getAllParentCategories() {
        return  categoryRepository.findByParentCatIdNull();
    }
    @Transactional ()
    public List<Category> getAllSubCategories() {
        return categoryRepository.findByParentCatIdNotNull();
    }

    @Transactional (readOnly = true)
    public Category getCategory(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException_404("Category not exist!"));
    }

    @Transactional
    public Category saveCategory(Category category) {
        if (category == null || category.getName() == null || Objects.requireNonNull(category.getName().getTr()).isBlank() || Objects.requireNonNull(category.getName().getEn()).isBlank()) {
            throw new IllegalArgumentException("Category or category name cannot be null or empty");
        }
        categoryRepository.save(category);
        return category;
    }

    @Transactional
    public boolean deleteCategory(String id) {
        return categoryRepository.findById(id).map(cate -> {
            categoryRepository.delete(cate);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException_404("Category not exist!"));
    }
}
