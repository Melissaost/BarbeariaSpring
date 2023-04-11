package com.barbearias.api;

import com.barbearias.domain.barbearia.Barbearia;
import com.barbearias.domain.barbearia.BarbeariaRepository;
import com.barbearias.domain.barbearia.dto.BarbeariaDTO;
import com.barbearias.domain.barbearia.dto.BarbeariaDetalhada;
import com.barbearias.domain.barbearia.dto.DadosCadastroBarbearia;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/barbearias")
public class BarbeariasController {
    @Autowired
    private BarbeariaRepository repository;

    @GetMapping()
    public ResponseEntity detalhar() {
        var barbearia = repository.findAll().stream().map(BarbeariaDTO::new);
        return ResponseEntity.ok(barbearia);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroBarbearia dados, UriComponentsBuilder uriBuider){
        var barbearia = new Barbearia(dados);
        repository.save(barbearia);

        var uri = uriBuider.path("/api/v1/barbearias/{id}").buildAndExpand(barbearia.getId()).toUri();

        return ResponseEntity.created(uri).body(new BarbeariaDetalhada(barbearia));
    }


}
