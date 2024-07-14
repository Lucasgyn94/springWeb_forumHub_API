package br.com.alura.forumhub.forms;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RespostaFormulario {

    @NotNull
    @NotEmpty
    private String mensagem;

    @NotNull
    private Long topicoId;
}
