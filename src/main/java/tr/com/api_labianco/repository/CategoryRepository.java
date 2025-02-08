package tr.com.api_labianco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.com.api_labianco.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String > {
    List<Category> findByParentCatIdNull();
    List<Category> findByParentCatIdNotNull();
}
