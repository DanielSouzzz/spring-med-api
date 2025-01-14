package app.springmedapi.controller;

import app.springmedapi.entity.usuarioDTO.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @RequestMapping
    public ResponseEntity autenticar(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        return ResponseEntity.ok().build();
    }
}
