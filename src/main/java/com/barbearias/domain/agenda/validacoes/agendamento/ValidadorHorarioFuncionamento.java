package com.barbearias.domain.agenda.validacoes.agendamento;

import com.barbearias.domain.ValidacaoException;
import com.barbearias.domain.agenda.DadosAgendamento;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamento{
    public void validar(DadosAgendamento dados){
        var dataAgendamento = dados.data();

        var domingo = dataAgendamento .getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaBarbearia = dataAgendamento .getHour() < 7;
        var depoisDoEncerramentoDaBarbearia = dataAgendamento .getHour() > 20;

        if(domingo || antesDaAberturaDaBarbearia || depoisDoEncerramentoDaBarbearia){
            throw new ValidacaoException("Agendamento fora do horario de funcionamento da barbearia. ");
        }

    }
}
