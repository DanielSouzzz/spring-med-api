package app.springmedapi.service.validacoes;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.infra.exception.ValidacaoException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ValidarAntecedencia implements ValidadorAGendamentosConsultas{
    public void validar(AgendamentoRequestDTO dto) {
        var dataConsulta = dto.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30){
            throw new ValidacaoException("A consulta deve ser agendada com antecedencia mínima de 30 minutos");
        }
    }
}
