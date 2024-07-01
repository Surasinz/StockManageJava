package work.StockManage.converter;

import org.springframework.stereotype.Component;
import work.StockManage.model.user.UserEntity;
import work.StockManage.model.user.UserRequest;

@Component
public class UserConverter {
    public UserEntity requestToEntity (UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setEmail(userRequest.getEmail());
        return userEntity;
    }
}
