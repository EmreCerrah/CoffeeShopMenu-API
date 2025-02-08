package tr.com.api_labianco.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import tr.com.api_labianco.model.Product;
import tr.com.api_labianco.dto.ProductTierDTO;

import java.util.List;
@Repository
public interface ProductRepository extends MongoRepository<Product, String > {
    List<Product> findProductsByCategoriesIdOrderByTier(String categoriesId);
    List<ProductTierDTO> findProductsByCategoriesIdOrderByTierAsc(String categoriesId);
    int countByCategoriesId(String categoriesId);
    boolean existsProductByCategoriesIdAndTierAndId(String categoriesId, int tier, String id);
    @Query("{ 'id' : ?0 }")
    @Update("{ '$set' : { 'tier' : ?1 }}")
    void updateTier(String id, int tier);
}


