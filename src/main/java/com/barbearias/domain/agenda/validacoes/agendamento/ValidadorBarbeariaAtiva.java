package com.barbearias.domain.agenda.validacoes.agendamento;

import com.barbearias.domain.ValidacaoException;
import com.barbearias.domain.agenda.DadosAgendamento;
import com.barbearias.domain.barbearia.BarbeariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorBarbeariaAtiva implements ValidadorAgendamento{

    @Autowired
    private BarbeariaRepository repository;

    public void validar(DadosAgendamento dados){
        if(dados.idBarbearia() == null){
            return;
        }
        var barbeariaEstaAtiva = repository.findAtivoById(dados.idBarbearia());
        if(!barbeariaEstaAtiva){
            throw new ValidacaoException("A barbearia escolhida não está ativa. ");
        }
    }

}
