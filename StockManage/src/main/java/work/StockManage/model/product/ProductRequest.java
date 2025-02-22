package work.StockManage.model.product;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class ProductRequest {
    private String productName;
    private String productImage;
    private Float price;
    private Integer quantity;
}
