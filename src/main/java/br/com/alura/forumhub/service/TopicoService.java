package br.com.alura.forumhub.service;

import br.com.alura.forumhub.dto.TopicoDto;
import br.com.alura.forumhub.model.Curso;
import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.TopicoFormulario;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.repository.CursoRepository;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import br.com.alura.forumhub.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AutenticacaoService autenticacaoService;

    public List<TopicoDto> listar() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

    public TopicoDto buscarPorId(Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        return new TopicoDto(topico);
    }

    public TopicoDto criar(TopicoFormulario form) {
        String emailDoUsuarioLogado = autenticacaoService.getEmailUsuarioLogado();
        Usuario autor = usuarioRepository.findByEmail(emailDoUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        Curso curso = cursoRepository.findByNome(form.getCursoNome())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Topico topico = form.converter(autor, curso);
        topicoRepository.save(topico);
        return new TopicoDto(topico);
    }

    public TopicoDto atualizar(Long id, TopicoFormulario form) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setTitulo(form.getTitulo());
        topico.setMensagem(form.getMensagem());
        topicoRepository.save(topico);
        return new TopicoDto(topico);
    }

    public void deletar(Long id) {
        topicoRepository.deleteById(id);
    }
}
