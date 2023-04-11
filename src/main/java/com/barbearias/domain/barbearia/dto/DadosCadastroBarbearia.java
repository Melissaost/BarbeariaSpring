package com.barbearias.domain.barbearia.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroBarbearia(
        @NotBlank // nao é nulo nem vazio
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String bairro,
        @NotBlank
        String rua,
        @NotBlank
        String numero,
        String imagem ) {
}
