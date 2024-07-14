package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.Topico;
import lombok.*;

import java.time.LocalDateTime;

public record TopicoDto (
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao

){

    // Construtor que aceita um objeto Topico
    public TopicoDto(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),topico.getDataCriacao());
        /*
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        *
         */
    }
}
