package work.StockManage.model.product;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductResponse {
    private String productName;
    private String productImage;
    private Integer quantity;
    private Integer price;
    private String id;
}
