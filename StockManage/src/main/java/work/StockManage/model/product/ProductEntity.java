package work.StockManage.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    private String id;
    private String productName;
    private String productImage;
    private Integer quantity;
    private Float price;
    private LocalDateTime updateAt;
    private LocalDateTime createAt;
}
