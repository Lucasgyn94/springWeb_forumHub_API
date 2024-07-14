package br.com.alura.forumhub.controller;


import br.com.alura.forumhub.dto.TopicoDto;
import br.com.alura.forumhub.model.TopicoFormulario;
import br.com.alura.forumhub.service.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<TopicoDto> listar() {
        return topicoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> buscarPorId(@PathVariable Long id) {
        TopicoDto topico = topicoService.buscarPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PostMapping
    public ResponseEntity<TopicoDto> criar(@RequestBody @Validated TopicoFormulario form) {
        TopicoDto topico = topicoService.criar(form);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Validated TopicoFormulario form) {
        TopicoDto topico = topicoService.atualizar(id, form);
        return ResponseEntity.ok(topico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        topicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
