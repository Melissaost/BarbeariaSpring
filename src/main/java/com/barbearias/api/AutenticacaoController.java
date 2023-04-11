package com.barbearias.api;

import com.barbearias.domain.usuario.dto.UsuarioDTO;
import com.barbearias.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository rep;

    @GetMapping
    public ResponseEntity detalhar() {
        var usuario = rep.findAll().stream().map(UsuarioDTO::new);
        return ResponseEntity.ok(usuario);
    }

}
