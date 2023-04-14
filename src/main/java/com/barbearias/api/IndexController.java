package com.barbearias.api;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SecurityRequirement(name = "bearer-key")
public class IndexController {

    @GetMapping()
    public String get() {
        return "Api de barbearias";
    }
}
