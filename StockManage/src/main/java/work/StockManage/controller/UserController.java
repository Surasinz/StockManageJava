package work.StockManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.StockManage.converter.UserConverter;
import work.StockManage.model.user.UserEntity;
import work.StockManage.model.user.UserRequest;
import work.StockManage.model.user.UserResponse;
import work.StockManage.repository.UserRepository;
import work.StockManage.validator.UserValidator;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserValidator userValidator;

    @PostMapping("/register")
    public UserEntity registerUser(@RequestBody UserRequest user) {
        UserEntity userEntity = userConverter.requestToEntity(user);
        return userRepository.save(userEntity);
    }
    @GetMapping("/login")
    public UserResponse getUserByUserNameAndPassword(@RequestParam String userName, @RequestParam String password) throws Exception {
        UserEntity userEntity = userRepository.findOneByUserName(userName);
        userValidator.validateUserLoginAndPassword(userEntity, password);
        return (userConverter.entityToResponse(userEntity));
    }
}
