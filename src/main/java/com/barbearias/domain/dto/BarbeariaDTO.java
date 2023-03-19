package com.barbearias.domain.dto;

import com.barbearias.domain.Barbearia;
import lombok.Data;
import org.modelmapper.ModelMapper;
@Data
public class BarbeariaDTO {

    private Long id;
    private String nome;
    private String rua;

    public static BarbeariaDTO create(Barbearia b){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(b, BarbeariaDTO.class);
    }
}
