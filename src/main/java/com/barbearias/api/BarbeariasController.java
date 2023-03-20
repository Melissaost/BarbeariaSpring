package com.barbearias.api;

import com.barbearias.domain.Barbearia;
import com.barbearias.domain.BarbeariaService;
import com.barbearias.domain.dto.BarbeariaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/barbearias")
public class BarbeariasController {
    @Autowired
    private BarbeariaService service;

    @GetMapping()
    public ResponseEntity get(){
        return ResponseEntity.ok(service.getBarbearias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<BarbeariaDTO>> get(@PathVariable("id") Long id){
        List<BarbeariaDTO> barbearia = service.getBarbeariaById(id);

        return ResponseEntity.ok(barbearia);
    }

    @GetMapping("/bairro/{bairro}")
    public ResponseEntity<List<BarbeariaDTO>> getByBairro(@PathVariable("bairro") String bairro){
        List<BarbeariaDTO> barbearias = service.getByBairro(bairro);

        return barbearias.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(barbearias);
    }

    @PostMapping
    public ResponseEntity<BarbeariaDTO> post(@RequestBody Barbearia barbearia) {

        BarbeariaDTO b = service.insert(barbearia);
        return b != null ?
                ResponseEntity.created(getUri(b.getId())).build() :
                ResponseEntity.badRequest().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BarbeariaDTO> put(@PathVariable("id") Long id, @RequestBody Barbearia barbearia) {

        barbearia.setId(id);
        BarbeariaDTO b = service.update(barbearia, id);

        return b != null ?
                ResponseEntity.ok(b) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<BarbeariaDTO>> delete(@PathVariable("id") Long id) {

        service.delete(id);
        return ResponseEntity.ok(service.getBarbearias());
    }
}
