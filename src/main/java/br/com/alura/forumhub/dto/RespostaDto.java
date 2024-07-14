package br.com.alura.forumhub.dto;

import br.com.alura.forumhub.model.Resposta;
import lombok.*;

import java.time.LocalDateTime;

public record RespostaDto(
        Long id,
        String mensagem,
        LocalDateTime dataCriacao,
        boolean solucao,
        Long autorId,
        Long topicoId
) {

    public RespostaDto(Resposta resposta) {
        this(resposta.getId(), resposta.getMensagem(), resposta.getDataCriacao(), resposta.isSolucao(),
                resposta.getAutor().getId(), resposta.getTopico().getId());
    }
}
