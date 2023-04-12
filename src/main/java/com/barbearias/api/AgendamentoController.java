package com.barbearias.api;

import com.barbearias.domain.agenda.Agendamento;
import com.barbearias.domain.agenda.DadosAgendamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/agendamento")
public class AgendamentoController {

    @Autowired
    private Agendamento agenda;

    @PostMapping
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamento dados){
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

}
