package com.barbearias.domain.agenda;

import com.barbearias.domain.ValidacaoException;
import com.barbearias.domain.agenda.validacoes.agendamento.ValidadorAgendamento;
import com.barbearias.domain.barbearia.BarbeariaRepository;
import com.barbearias.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Agendamento {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Autowired
    private List<ValidadorAgendamento> validadores;

    public DadosDetalhamentoDoAgendamento agendar(DadosAgendamento dados){
        if(dados.idUsuario() != null && !usuarioRepository.existsById(dados.idUsuario())){
            throw new ValidacaoException("Id do usuario não existe. ");
        }

        if(!usuarioRepository.findAtivoById(dados.idUsuario())){
            throw new ValidacaoException("Usuário não está ativo. ");
        }

        if(dados.idBarbearia() != null && !barbeariaRepository.existsById(dados.idBarbearia())){
            throw new ValidacaoException("Id da barbearia não existe. ");
        }

        validadores.forEach(v -> v.validar(dados));

        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var barbearia = barbeariaRepository.getReferenceById(dados.idBarbearia());
        if (barbearia == null){
            throw new ValidacaoException("Não existe horario disponível nessa data. ");
        }
        var agendamento = new Agenda(null, usuario, barbearia, dados.data(), null);
        agendaRepository.save(agendamento);


        return new DadosDetalhamentoDoAgendamento(agendamento);
    }

    public void cancelar(DadosCancelamento dados) {
        if(!agendaRepository.existsById(dados.idAgendamento())){
            throw new ValidacaoException("Id do agendamento informado não existe. ");
        }

        var agenda = agendaRepository.getReferenceById(dados.idAgendamento());
        agenda.cancelar(dados.motivo());
    }
}
