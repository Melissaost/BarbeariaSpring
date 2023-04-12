package com.barbearias.domain.agenda;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamento(
        @NotNull
        Long idUsuario,
        @NotNull
        Long idBarbearia,

        @NotNull
        @Future
        LocalDateTime data) {
}
