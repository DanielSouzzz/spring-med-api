package app.springmedapi.service.validacoes;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.infra.exception.ValidacaoException;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidarAntecedencia {
    public void validar(AgendamentoRequestDTO dto) {
        var dataConsulta = dto.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30){
            throw new ValidacaoException("A consulta deve ser agendada com antecedencia mínima de 30 minutos");
        }
    }
}
