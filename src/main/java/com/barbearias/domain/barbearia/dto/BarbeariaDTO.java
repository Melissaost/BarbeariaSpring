package com.barbearias.domain.barbearia.dto;

import com.barbearias.domain.barbearia.Barbearia;

public record BarbeariaDTO(Long id, String nome, String rua, String bairro){
    public BarbeariaDTO(Barbearia barbearia) {
        this(barbearia.getId(), barbearia.getNome(), barbearia.getRua(), barbearia.getBairro());
    }
}
