package com.barbearias.domain.barbearia.dto;

import com.barbearias.domain.barbearia.Barbearia;

public record DadosBarbeariaDetalhada(
        Long id,
        String nome,
        String telefone,
        String cep,
        String cidade,
        String bairro,
        String rua,
        String numero) {

    public DadosBarbeariaDetalhada(Barbearia barbearia) {
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
