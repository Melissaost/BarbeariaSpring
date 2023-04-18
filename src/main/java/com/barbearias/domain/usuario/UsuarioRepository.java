package com.barbearias.domain.usuario;

import com.barbearias.domain.barbearia.Barbearia;
import org.springframework.beans.PropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    UserDetails findByLogin(String login);

    List<Usuario> findAllByAtivoTrue();

    @Query("""
            select u.ativo
            from Usuario u 
            where 
            u.id = :id
            """)
    Boolean findAtivoById(Long id);


    @Query("""
            select u.ativo
            from Usuario u 
            where 
            u.login = :login
            """)
    boolean findAtivoByLogin(String login);
}
