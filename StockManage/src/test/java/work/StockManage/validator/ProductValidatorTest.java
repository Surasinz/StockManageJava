package work.StockManage.validator;

import org.junit.jupiter.api.Test;
import work.StockManage.model.product.ProductEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class ProductValidatorTest {

    @Test
    public void testValidateIsNullProduct_whenProductExists() {
        ProductEntity mockProductEntity = mock(ProductEntity.class);
        Optional<ProductEntity> optionalProductEntity = Optional.of(mockProductEntity);
        assertDoesNotThrow(() -> {
            new ProductValidator().validateIsNullProduct(optionalProductEntity);
        });
    }

    @Test
    public void testValidateIsNullProduct_whenProductNotExists() {
        Optional<ProductEntity> optionalProductEntity = Optional.empty();
        assertThrows(RuntimeException.class, () -> {
            new ProductValidator().validateIsNullProduct(optionalProductEntity);
        });
    }
}
