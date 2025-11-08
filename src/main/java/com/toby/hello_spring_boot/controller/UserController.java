package com.toby.hello_spring_boot.controller;

import com.toby.hello_spring_boot.dto.request.ApiResponse;
import com.toby.hello_spring_boot.dto.request.UserCreationRequest;
import com.toby.hello_spring_boot.dto.request.UserUpdaeRequest;
import com.toby.hello_spring_boot.dto.response.UserResponse;
import com.toby.hello_spring_boot.entity.User;
import com.toby.hello_spring_boot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse =  new ApiResponse<>();

         apiResponse.setResult(userService.createUser(request));

         return  apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdaeRequest request) {
        return userService.upadteUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted successfully";
    }
}
