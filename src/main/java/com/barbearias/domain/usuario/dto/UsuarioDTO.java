package com.barbearias.domain.usuario.dto;

import com.barbearias.domain.usuario.Usuario;

public record UsuarioDTO(Long id, String nome) {
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin());
    }
}