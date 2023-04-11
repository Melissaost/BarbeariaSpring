package com.barbearias.domain.barbearia.dto;

import com.barbearias.domain.barbearia.Barbearia;

public record BarbeariaDetalhada(
        Long id,
        String nome,
        String telefone,
        String cep,
        String cidade,
        String bairro,
        String rua,
        String numero) {

    public BarbeariaDetalhada(Barbearia barbearia) {
        this(
                barbearia.getId(),
                barbearia.getNome(),
                barbearia.getTelefone(),
                barbearia.getCidade(),
                barbearia.getBairro(),
                barbearia.getRua(),
                barbearia.getNumero(),
                barbearia.getCep());
    }
}
