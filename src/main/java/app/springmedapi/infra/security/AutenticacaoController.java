package app.springmedapi.infra.security;

import app.springmedapi.infra.security.usuarioDTO.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
        var authenticaon = authenticationManager.authenticate(authenticationTokentoken);

        var tokenJWT = tokenService.gerarToken((Usuario) authenticaon.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJwtDTO(tokenJWT));
    }
}
