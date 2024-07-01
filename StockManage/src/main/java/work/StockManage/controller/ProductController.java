package work.StockManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.StockManage.converter.ProductConverter;
import work.StockManage.model.product.ProductEntity;
import work.StockManage.model.product.ProductRequest;
import work.StockManage.model.product.ProductResponse;
import work.StockManage.repository.ProductRepository;
import work.StockManage.validator.ProductValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductConverter productConverter;
    @Autowired
    ProductValidator productValidator;

    @GetMapping("/all")
    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(productConverter::entityToResponse)
                .collect(Collectors.toList());
    }
    @PostMapping("/create")
    public ProductResponse newProduct(@RequestBody ProductRequest productRequest) {
        ProductEntity productEntity = productConverter.requestToEntity(productRequest);
        productRepository.save(productEntity);
        return productConverter.entityToResponse(productEntity);
    }
    @PatchMapping("/update/{id}")
    public ProductResponse updateProduct(@PathVariable String id, @RequestBody ProductRequest productRequest) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        productValidator.validateIsNullProduct(optionalProductEntity);
        ProductEntity existingProduct = optionalProductEntity.get();
        ProductEntity updatedProduct = productConverter.requestToExistingEntity(productRequest, existingProduct);
        updatedProduct = productRepository.save(updatedProduct);
        return productConverter.entityToResponse(updatedProduct);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        productValidator.validateIsNullProduct(optionalProductEntity);
        productRepository.deleteById(id);
        return "Delete Product Success";
    }
}
