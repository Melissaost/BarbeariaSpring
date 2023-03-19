package com.barbearias.api;

import com.barbearias.domain.BarbeariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/barbearias")
public class BarbeariasController {
    @Autowired
    private BarbeariaService service;

    @GetMapping()
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getBarbearias());
    }
}
