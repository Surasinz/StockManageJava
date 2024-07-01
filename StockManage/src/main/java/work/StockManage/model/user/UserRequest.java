package work.StockManage.model.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserRequest {
    private String userName;
    private String password;
    private String email;
}
