package com.barbearias.domain.agenda;

import java.time.LocalDateTime;

public record DadosDetalhamentoDoAgendamento(
        Long id,
        Long idUsuario,
        Long idBarbearia,
        LocalDateTime data
) {

    public DadosDetalhamentoDoAgendamento(Agenda agenda) {
        this(agenda.getId(), agenda.getUsuario().getId(), agenda.getBarbearia().getId(), agenda.getData());
    }
}
