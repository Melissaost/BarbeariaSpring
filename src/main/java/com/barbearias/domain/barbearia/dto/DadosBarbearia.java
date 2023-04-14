package com.barbearias.domain.barbearia.dto;

import com.barbearias.domain.barbearia.Barbearia;

public record DadosBarbearia(Long id, String nome, String rua, String bairro){
    public DadosBarbearia(Barbearia barbearia) {
        this(barbearia.getId(), barbearia.getNome(), barbearia.getRua(), barbearia.getBairro());
    }
}
