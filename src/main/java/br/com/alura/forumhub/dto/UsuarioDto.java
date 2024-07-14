package br.com.alura.forumhub.dto;


import br.com.alura.forumhub.model.Usuario;

public record UsuarioDto(Long id, String nome, String email) {
    public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}
