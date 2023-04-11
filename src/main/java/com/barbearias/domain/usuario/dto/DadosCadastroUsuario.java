package com.barbearias.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank // nao é nulo nem vazio
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotBlank
        String login,
        @NotBlank
        String senha) {
}
