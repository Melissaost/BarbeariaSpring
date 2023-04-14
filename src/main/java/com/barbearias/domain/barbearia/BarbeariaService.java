package com.barbearias.domain.barbearia;

import com.barbearias.domain.ValidacaoException;
import com.barbearias.domain.barbearia.dto.DadosBarbeariaDetalhada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarbeariaService {

    @Autowired
    private BarbeariaRepository repository;

    public DadosBarbeariaDetalhada reativar(long id){
        var barbearia = repository.getReferenceById(id);
        if(barbearia.getAtivo()){
            throw new ValidacaoException("Barbearia já está ativa. ");
        }
        barbearia.reativar();
        return new DadosBarbeariaDetalhada(barbearia);
    }
}
