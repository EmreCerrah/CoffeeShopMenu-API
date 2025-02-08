package tr.com.api_coffee_shop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import tr.com.api_coffee_shop.model.Category;
import tr.com.api_coffee_shop.repository.CategoryRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        categoryRepository.save(new Category());
        categoryRepository.save(new Category());
        categoryRepository.save(new Category());
    }

    @Test
    void getAllCategories_ShouldReturnCorrectCount() {
        ResponseEntity<Category[]> response = restTemplate.getForEntity("/api/v1/categories", Category[].class);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().length).isEqualTo(3);
    }
}