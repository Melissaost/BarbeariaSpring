package com.barbearias.domain.usuario.dto;

import com.barbearias.domain.usuario.Usuario;

public record DadosUsuario(Long id, String nome, String telefone, String login) {
    public DadosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getTelefone(), usuario.getNome());
    }
}