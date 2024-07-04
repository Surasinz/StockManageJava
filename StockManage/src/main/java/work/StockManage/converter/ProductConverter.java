package work.StockManage.converter;

import org.springframework.stereotype.Component;
import work.StockManage.model.product.ProductEntity;
import work.StockManage.model.product.ProductRequest;
import work.StockManage.model.product.ProductResponse;

import java.util.Optional;

@Component
public class ProductConverter {
    public ProductEntity requestToEntity (ProductRequest productRequest){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productRequest.getProductName());
        productEntity.setProductImage(productRequest.getProductImage());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setQuantity(productRequest.getQuantity());
        return productEntity;
    }
    public ProductResponse entityToResponse (ProductEntity productEntity){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(productEntity.getProductName());
        productResponse.setProductImage(productEntity.getProductImage());
        productResponse.setQuantity(productEntity.getQuantity());
        productResponse.setPrice(productEntity.getPrice());
        productResponse.setId(productEntity.getId());
        return productResponse;
    }
    public ProductEntity requestToExistingEntity(ProductRequest productRequest, ProductEntity existingEntity) {
        existingEntity.setProductName(productRequest.getProductName());
        existingEntity.setProductImage(productRequest.getProductImage());
        existingEntity.setQuantity(productRequest.getQuantity());
        existingEntity.setPrice(productRequest.getPrice());
        return existingEntity;
    }
    public ProductResponse optionalEntityToResponse(Optional<ProductEntity> productEntityOptional) {
        if (productEntityOptional.isPresent()) {
            ProductEntity productEntity = productEntityOptional.get();
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductName(productEntity.getProductName());
            productResponse.setProductImage(productEntity.getProductImage());
            productResponse.setQuantity(productEntity.getQuantity());
            productResponse.setPrice(productEntity.getPrice());
            productResponse.setId(productEntity.getId());
            return productResponse;
        }
        return null;
    }

}
