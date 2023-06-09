package com.company.practics.practic_23.controllers;

import com.company.practics.practic_23.configs.SecurityConfig;
import com.company.practics.practic_23.models.Student;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Controller
public class HomeController {

    @GetMapping("/home")
    @ResponseBody
    public String getHomePage() throws IOException {
        Resource resource = new ClassPathResource("templates/home.html");
        InputStream inputStream = resource.getInputStream();
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }
}