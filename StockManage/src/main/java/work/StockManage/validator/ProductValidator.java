package work.StockManage.validator;

import org.springframework.stereotype.Component;
import work.StockManage.model.product.ProductEntity;

import java.util.Optional;

@Component
public class ProductValidator {
    public void validateIsNullProduct(Optional<ProductEntity> productEntity){
        if(productEntity.isEmpty()){
            throw new RuntimeException("Product not found with id ");
        }

    }
}
