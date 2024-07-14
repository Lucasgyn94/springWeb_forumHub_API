package br.com.alura.forumhub.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.dataCriacao = LocalDateTime.now();
    }

    public enum StatusTopico {
        NAO_RESPONDIDO,
        NAO_SOLUCIONADO,
        SOLUCIONADO,
        FECHADO;
    }
}
