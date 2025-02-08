package tr.com.api_coffee_shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.api_coffee_shop.dto.ProductTierDTO;
import tr.com.api_coffee_shop.exception.ResourceNotFoundException_404;
import tr.com.api_coffee_shop.model.Product;
import tr.com.api_coffee_shop.repository.ProductRepository;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException_404("Product not exist!"));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public Product saveProduct(Product product) {
        if (product.getDetail() != null) {
            if (Objects.requireNonNull(product.getDetail().getTr()).isEmpty() && Objects.requireNonNull(product.getDetail().getEn()).isEmpty()) {
                product.setDetail(null);
            }
        }
        product.setTier(Math.toIntExact(productRepository.countByCategoriesId(product.getCategoriesId())));
        return productRepository.save(product);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public Product updateProductById(String id, Product product) {
        if (product == null || product.getName() == null) {
            throw new IllegalArgumentException("Product or product name cannot be null");
        }
        if (product.getDetail() != null) {
            if (Objects.requireNonNull(product.getDetail().getTr()).isEmpty() && Objects.requireNonNull(product.getDetail().getEn()).isEmpty()) {
                product.setDetail(null);
            }
        }
        if (!productRepository.existsProductByCategoriesIdAndTierAndId(product.getCategoriesId(), product.getTier(), product.getId())) {
            product.setTier(Math.toIntExact(productRepository.countByCategoriesId(product.getCategoriesId())));
        }
        product.setId(id);
        return productRepository.save(product);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = {RuntimeException.class})
    public boolean deleteProduct(String id) {
        return productRepository.findById(id).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException_404("Product already gone!"));
    }

    @Transactional(readOnly = true)
    public List<Product> getProductsByCategoriesId(String categoriesId) {
        return productRepository.findProductsByCategoriesIdOrderByTier(categoriesId);
    }

    @Transactional(readOnly = true)
    public List<ProductTierDTO> getProductsIdAndTearByCategoriesId(String categoriesId) {
        return productRepository.findProductsByCategoriesIdOrderByTierAsc(categoriesId);
    }

    public List<ProductTierDTO> updateProductTiers(List<ProductTierDTO> updates) {
        for (ProductTierDTO update : updates) {
            productRepository.updateTier(update.getId(), update.getTier());
        }
        return updates;
    }
}
