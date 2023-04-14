package com.barbearias.api;

import com.barbearias.domain.agenda.AgendaRepository;
import com.barbearias.domain.agenda.Agendamento;
import com.barbearias.domain.agenda.DadosAgendamento;
import com.barbearias.domain.agenda.DadosCancelamento;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/agendamento")
@SecurityRequirement(name = "bearer-key")
public class AgendamentoController {

    @Autowired
    private Agendamento agenda;

    @Autowired
    private AgendaRepository repository;

    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamento dados){
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamento dados){
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
