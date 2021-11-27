package com.swisscom.backend.controller;

import com.swisscom.backend.model.UserEntity;
import com.swisscom.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/")
    public String index() {
        return userService.index();
    }

    @PostMapping("/upload-csv-file")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        return userService.upload(file, model);
    }
}
