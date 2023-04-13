package com.barbearias.domain.barbearia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {
    List<Barbearia> findByBairro(String bairro);

    List<Barbearia> findAllByAtivoTrue();

    @Query("""
            select b.ativo
            from Barbearia b 
            where 
            b.id = :id
            """)
    Boolean findAtivoById(Long id);


}
