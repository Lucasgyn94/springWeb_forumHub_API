package br.com.alura.forumhub.forms;


import br.com.alura.forumhub.model.Curso;
import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TopicoFormulario {

    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull
    @NotEmpty
    private String mensagem;

    @NotNull
    @NotEmpty
    private String cursoNome;

    public Topico converter(Usuario autor, Curso curso) {
        return new Topico(this.titulo, this.mensagem, autor, curso);
    }
}
