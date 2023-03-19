package com.barbearias.domain;

import com.barbearias.domain.dto.BarbeariaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarbeariaService {

    @Autowired
    private BarbeariaRepository rep;

    public List<BarbeariaDTO> getBarbearias() {

        return rep.findAll().stream().map(c -> BarbeariaDTO.create(c)).collect(Collectors.toList());

        // List<CarroDTO> list = new ArrayList<>();
        // for(Carro c : carros) {
        //		list.add(new CarroDTO(c));
        // }

    }
}
