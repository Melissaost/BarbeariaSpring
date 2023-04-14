package com.barbearias.api;

import com.barbearias.domain.barbearia.Barbearia;
import com.barbearias.domain.barbearia.BarbeariaRepository;
import com.barbearias.domain.barbearia.BarbeariaService;
import com.barbearias.domain.barbearia.dto.DadosBarbearia;
import com.barbearias.domain.barbearia.dto.DadosBarbeariaDetalhada;
import com.barbearias.domain.barbearia.dto.DadosAtualizacaoBarbearia;
import com.barbearias.domain.barbearia.dto.DadosCadastroBarbearia;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/barbearias")
@SecurityRequirement(name = "bearer-key")
public class BarbeariasController {
    @Autowired
    private BarbeariaRepository repository;
    @Autowired
    private BarbeariaService service;


    @GetMapping()
    public ResponseEntity detalhar() {
        var barbearia = repository.findAllByAtivoTrue().stream().map(DadosBarbearia::new);
        return ResponseEntity.ok(barbearia);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroBarbearia dados, UriComponentsBuilder uriBuider){
        var barbearia = new Barbearia(dados);
        repository.save(barbearia);

        var uri = uriBuider.path("/api/v1/barbearias/{id}").buildAndExpand(barbearia.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosBarbeariaDetalhada(barbearia));
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoBarbearia dados){
        var barbearia = repository.getReferenceById(dados.id());
        barbearia.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosBarbeariaDetalhada(barbearia));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var barbearia = repository.getReferenceById(id);
        barbearia.excluir();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/reativar/{id}")
    @Transactional
    public ResponseEntity reativar(@PathVariable Long id){
        var barbearia = service.reativar(id);
        return ResponseEntity.ok(barbearia);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var barbearia = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosBarbeariaDetalhada(barbearia));
    }


}
