package com.swisscom.backend.controller;

import com.swisscom.backend.model.UserDto;
import com.swisscom.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers(@RequestParam(required = false) List<String> filter) {
        return userService.getUsers(filter);
    }

    @DeleteMapping("/users")
    public void deleteUsers() {
        userService.deleteUsers();
    }
}
