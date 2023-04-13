package com.barbearias.domain.agenda;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    boolean existsByBarbeariaIdAndDataAndMotivoCancelamentoIsNull(Long idBarbearia, LocalDateTime data);

  //  boolean existsByUsuarioIdAndData(Long idUsuario, LocalDateTime data);

     boolean existsByUsuarioIdAndDataBetweenAndMotivoCancelamentoIsNull(Long idUsuario, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

}
