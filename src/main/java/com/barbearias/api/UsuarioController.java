package com.barbearias.api;

import com.barbearias.domain.barbearia.dto.BarbeariaDetalhada;
import com.barbearias.domain.barbearia.dto.DadosAtualizacaoBarbearia;
import com.barbearias.domain.usuario.Usuario;
import com.barbearias.domain.usuario.dto.DadosAtualizacaoUsuario;
import com.barbearias.domain.usuario.dto.DadosCadastroUsuario;
import com.barbearias.domain.usuario.dto.UsuarioDTO;
import com.barbearias.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping()
    public ResponseEntity detalhar() {
        var usuario = repository.findAll().stream().map(UsuarioDTO::new);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuider){
        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriBuider.path("/api/v1/barbearias/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

}
