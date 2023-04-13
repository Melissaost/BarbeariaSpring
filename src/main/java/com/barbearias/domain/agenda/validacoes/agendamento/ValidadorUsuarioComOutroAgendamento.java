package com.barbearias.domain.agenda.validacoes.agendamento;

import com.barbearias.domain.ValidacaoException;
import com.barbearias.domain.agenda.AgendaRepository;
import com.barbearias.domain.agenda.DadosAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Validador usuario com outro agendamento no mesmo dia")
public class ValidadorUsuarioComOutroAgendamento implements ValidadorAgendamento{

    @Autowired
    private AgendaRepository repository;

    public void validar(DadosAgendamento dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(20);
        var usuarioPossuiOutroAgendamentoNoMesmoDia = repository.existsByUsuarioIdAndDataBetweenAndMotivoCancelamentoIsNull(dados.idUsuario(), primeiroHorario, ultimoHorario);

        if(usuarioPossuiOutroAgendamentoNoMesmoDia){
            throw new ValidacaoException("Usuário já marcou outro atendimento nesse mesmo dia. ");
        }
    }
}
