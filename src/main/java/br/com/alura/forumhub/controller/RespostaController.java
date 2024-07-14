package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.dto.RespostaDto;
import br.com.alura.forumhub.forms.RespostaFormulario;
import br.com.alura.forumhub.service.RespostaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @GetMapping
    public List<RespostaDto> listar() {
        return respostaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaDto> buscarPorId(@PathVariable Long id) {
        RespostaDto resposta = respostaService.buscarPorId(id);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping
    public ResponseEntity<RespostaDto> criar(@RequestBody @Validated RespostaFormulario form) {
        RespostaDto resposta = respostaService.criar(form);
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaDto> atualizar(@PathVariable Long id, @RequestBody @Validated RespostaFormulario form) {
        RespostaDto resposta = respostaService.atualizar(id, form);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        respostaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
