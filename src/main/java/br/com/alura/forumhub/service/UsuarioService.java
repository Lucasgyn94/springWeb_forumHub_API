package br.com.alura.forumhub.service;


import br.com.alura.forumhub.dto.UsuarioDto;
import br.com.alura.forumhub.forms.UsuarioFormulario;
import br.com.alura.forumhub.model.Usuario;
import br.com.alura.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioDto> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }

    public UsuarioDto buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsuarioDto(usuario);
    }

    public UsuarioDto criar(UsuarioFormulario form) {
        if (usuarioRepository.existsByEmail(form.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(form.getNome());
        usuario.setEmail(form.getEmail());
        usuario.setSenha(passwordEncoder.encode(form.getSenha()));
        usuarioRepository.save(usuario);

        return new UsuarioDto(usuario);
    }

    public UsuarioDto atualizar(Long id, UsuarioFormulario form) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(form.getNome());
        usuario.setEmail(form.getEmail());
        if (form.getSenha() != null && !form.getSenha().isEmpty()) {
            usuario.setSenha(passwordEncoder.encode(form.getSenha()));
        }
        usuarioRepository.save(usuario);
        return new UsuarioDto(usuario);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
