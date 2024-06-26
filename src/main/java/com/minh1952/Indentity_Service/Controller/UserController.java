package com.minh1952.Indentity_Service.Controller;

import com.minh1952.Indentity_Service.Entity.User;
import com.minh1952.Indentity_Service.Exception.AppException;
import com.minh1952.Indentity_Service.Service.UserService;
import com.minh1952.Indentity_Service.dto.request.ApiResponse;
import com.minh1952.Indentity_Service.dto.request.UserCreationRequest;
import com.minh1952.Indentity_Service.dto.request.UserUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId ){
        return userService.getUserById(userId);
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/{userId}")                                // @Valid : kiểm tra tính hợp lệ trong dữ liệu của request
    User updateUser(@PathVariable String userId ,@RequestBody @Valid UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been delete";
    }

}
