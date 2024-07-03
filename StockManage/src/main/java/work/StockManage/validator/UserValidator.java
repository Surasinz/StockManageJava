package work.StockManage.validator;

import org.springframework.stereotype.Component;
import work.StockManage.model.user.UserEntity;

@Component
public class UserValidator {
    public void validateUserLoginAndPassword(UserEntity userEntity, String password) throws Exception {
        if (userEntity == null) {
            throw new Exception("User Not found");
        }
        else if (!(userEntity.getPassword().equals(password))) {
            throw new Exception("Wrong password");
        }
    }
}
