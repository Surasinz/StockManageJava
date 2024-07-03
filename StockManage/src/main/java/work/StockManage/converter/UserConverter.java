package work.StockManage.converter;

import org.springframework.stereotype.Component;
import work.StockManage.model.user.UserEntity;
import work.StockManage.model.user.UserRequest;
import work.StockManage.model.user.UserResponse;

@Component
public class UserConverter {
    public UserEntity requestToEntity (UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRequest.getUserName());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setEmail(userRequest.getEmail());
        return userEntity;
    }
    public UserResponse entityToResponse (UserEntity userEntity){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setUserName(userEntity.getUserName());
        return userResponse;
    }
}
