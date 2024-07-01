package work.StockManage.model.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserResponse {
    private Long id;
    private String userName;
}
