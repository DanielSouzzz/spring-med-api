package app.springmedapi.service;

import app.springmedapi.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {
    public String gerarToken(Usuario user) {
        try {
            var algorithm = Algorithm.HMAC256("secret");
             return JWT.create()
                    .withIssuer("API SpringMed")
                     .withSubject(user.getLogin())
                     .withClaim("id", user.getId())
                     .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    public Instant expirationDate() {
        return Instant.now().plusSeconds(3600);
    }
}
