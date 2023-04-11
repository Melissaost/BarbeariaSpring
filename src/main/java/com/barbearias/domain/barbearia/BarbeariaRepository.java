package com.barbearias.domain.barbearia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {
    List<Barbearia> findByBairro(String bairro);
}
