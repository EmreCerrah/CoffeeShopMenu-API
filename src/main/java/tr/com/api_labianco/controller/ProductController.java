package tr.com.api_labianco.controller;

import org.springframework.web.bind.annotation.*;
import tr.com.api_labianco.exception.ResourceNotFoundException_404;
import tr.com.api_labianco.model.Product;
import tr.com.api_labianco.dto.ProductTierDTO;
import tr.com.api_labianco.service.ProductService;
import tr.com.api_labianco.util.PathConstant;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping (PathConstant.BASE_ENDPOINT_PROD)
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping( { "/products" ,  "/product/all"})
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable (name = "id") String id) throws ResourceNotFoundException_404 {
        return productService.getProductById(id);
    }

    @GetMapping("/product/orderTear/{id}")
    public List<Product> getProductByCategoryId(@PathVariable (name = "id") String categoryId) throws ResourceNotFoundException_404 {
        return productService.getProductsByCategoriesId(categoryId);
    }

    @GetMapping("/product/IdAndTier/{id}")
    public List<ProductTierDTO> getProductIdAndTierByCategoryId(@PathVariable (name = "id") String categoryId) throws ResourceNotFoundException_404 {
        return productService.getProductsIdAndTearByCategoriesId(categoryId);
    }

    @PutMapping("/tiers")
    public List<ProductTierDTO> updateProductTiers(@RequestBody List<ProductTierDTO> updates) {
        return productService.updateProductTiers(updates);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public Optional<Product> updateProduct(@PathVariable (name = "id") String  id,
                                           @RequestBody Product product) throws ResourceNotFoundException_404{
        return Optional.ofNullable(productService.updateProductById(id, product));
    }

    @DeleteMapping("/product/{id}")
    public boolean deleteProduct(@PathVariable (name = "id") String  id)  throws ResourceNotFoundException_404 {
        return productService.deleteProduct(id);
    }
}
