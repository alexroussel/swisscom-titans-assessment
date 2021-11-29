package com.swisscom.backend.controller;

import com.swisscom.backend.service.FrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class FrontController {

    private final FrontService frontService;

    @GetMapping("/")
    public String index() {
        return frontService.index();
    }

    @PostMapping("/upload-csv-file")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        return frontService.upload(file, model);
    }
}
