package com.barbearias.api;

import com.barbearias.domain.usuario.Usuario;
import com.barbearias.domain.usuario.dto.DadosAtualizacaoUsuario;
import com.barbearias.domain.usuario.dto.DadosCadastroUsuario;
import com.barbearias.domain.usuario.dto.DadosUsuario;
import com.barbearias.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping()
    public ResponseEntity detalhar() {
        var usuario = repository.findAllByAtivoTrue().stream().map(DadosUsuario::new);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuider){
        var usuario = new Usuario(dados);
        usuario.setSenha(encoder.encode(usuario.getSenha()));

        repository.save(usuario);

        var uri = uriBuider.path("/api/v1/barbearias/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosUsuario(usuario));
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosUsuario(usuario));
    }

}
