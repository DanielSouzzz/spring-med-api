package app.springmedapi.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario user) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
             return JWT.create()
                    .withIssuer("SpringMed API")
                     .withSubject(user.getLogin())
                     .withClaim("id", user.getId())
                     .withExpiresAt(Date.from(expirationDate()))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("SpringMed API")
                    .build().verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Erro ao verificar token jwt", exception);
        }
    }
    private Instant expirationDate() {
        return Instant.now().plusSeconds(3600);
    }
}
