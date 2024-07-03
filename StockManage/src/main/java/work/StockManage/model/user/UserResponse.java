package work.StockManage.model.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserResponse {
    private String id;
    private String userName;
}
