package com.barbearias.domain.barbearia.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoBarbearia(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String imagem) {
}
