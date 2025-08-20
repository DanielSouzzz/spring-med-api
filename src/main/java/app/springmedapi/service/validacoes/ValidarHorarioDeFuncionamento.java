package app.springmedapi.service.validacoes;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
import app.springmedapi.infra.exception.ValidacaoException;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class ValidarHorarioDeFuncionamento implements ValidadorAGendamentosConsultas{
    public void validar(AgendamentoRequestDTO dto){
        var dataAgendamento = dto.data();
        var isDomingo = dataAgendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var isForaDeFuncionamento = dataAgendamento.getHour() < 7 || dataAgendamento.getHour() > 18;

        if (isDomingo || isForaDeFuncionamento){
            throw new ValidacaoException("Fora do horário de funcionamento.");
        }
    }
}
