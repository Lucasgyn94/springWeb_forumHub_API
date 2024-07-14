package br.com.alura.forumhub.service;


import br.com.alura.forumhub.dto.RespostaDto;
import br.com.alura.forumhub.forms.RespostaFormulario;
import br.com.alura.forumhub.model.Resposta;
import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.repository.RespostaRepository;
import br.com.alura.forumhub.repository.TopicoRepository;
import br.com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private AutenticacaoService autenticacaoService;

    public List<RespostaDto> listar() {
        List<Resposta> respostas = respostaRepository.findAll();
        return respostas.stream().map(RespostaDto::new).collect(Collectors.toList());
    }

    public RespostaDto buscarPorId(Long id) {
        Resposta resposta = respostaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
        return new RespostaDto(resposta);
    }

    public RespostaDto criar(RespostaFormulario form) {
        String emailDoUsuarioLogado = autenticacaoService.getEmailUsuarioLogado();
        Usuario autor = usuarioRepository.findByEmail(emailDoUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        Topico topico = topicoRepository.findById(form.getTopicoId())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        Resposta resposta = new Resposta();
        resposta.setMensagem(form.getMensagem());
        resposta.setAutor(autor);
        resposta.setTopico(topico);
        respostaRepository.save(resposta);

        return new RespostaDto(resposta);
    }

    public RespostaDto atualizar(Long id, RespostaFormulario form) {
        Resposta resposta = respostaRepository.findById(id).orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
        resposta.setMensagem(form.getMensagem());
        respostaRepository.save(resposta);
        return new RespostaDto(resposta);
    }

    public void deletar(Long id) {
        respostaRepository.deleteById(id);
    }
}
