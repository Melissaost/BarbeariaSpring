package com.barbearias.domain.agenda;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamento(
        @NotNull
        Long idAgendamento,

        @NotNull
        MotivoCancelamento motivo) {
}
