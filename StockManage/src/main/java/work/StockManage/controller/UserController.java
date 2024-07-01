package work.StockManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.StockManage.converter.UserConverter;
import work.StockManage.model.user.UserEntity;
import work.StockManage.model.user.UserRequest;
import work.StockManage.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserRequest user) {
        UserEntity userEntity = userConverter.requestToEntity(user);
        return userRepository.save(userEntity);
    }
}
