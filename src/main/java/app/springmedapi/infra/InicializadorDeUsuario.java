package app.springmedapi.infra;

import app.springmedapi.infra.security.Usuario;
import app.springmedapi.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InicializadorDeUsuario {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public InicializadorDeUsuario(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void criarUsuarioAdmin() {
        if (usuarioRepository.findByLogin("admin").isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setLogin("admin");
            usuario.setSenha(passwordEncoder.encode("123456"));
            usuarioRepository.save(usuario);
        }
    }
}
