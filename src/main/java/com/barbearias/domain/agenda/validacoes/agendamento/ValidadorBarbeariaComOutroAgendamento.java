package com.barbearias.domain.agenda.validacoes.agendamento;

import com.barbearias.domain.ValidacaoException;
import com.barbearias.domain.agenda.AgendaRepository;
import com.barbearias.domain.agenda.DadosAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Validador barberaria com outro agendamento no mesmo horario")
public class ValidadorBarbeariaComOutroAgendamento implements ValidadorAgendamento{

    @Autowired
    private AgendaRepository repository;

    public void validar(DadosAgendamento dados){
        var babeariaPossuiOutroAgendamentoNoMesmoHorario = repository.existsByBarbeariaIdAndDataAndMotivoCancelamentoIsNull(dados.idBarbearia(), dados.data());
        if (babeariaPossuiOutroAgendamentoNoMesmoHorario){
            throw new ValidacaoException("A barbearia já possui outro agendamento para esse horario.");
        }
    }
}
