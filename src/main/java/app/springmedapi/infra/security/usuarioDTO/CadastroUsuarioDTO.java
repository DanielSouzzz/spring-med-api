package app.springmedapi.infra.security.usuarioDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroUsuarioDTO(
        @NotBlank(message = "O login é obrigatório")
        @Email(message = "O login deve ser um e-mail válido")
        String login,
        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        String senha
) {
}