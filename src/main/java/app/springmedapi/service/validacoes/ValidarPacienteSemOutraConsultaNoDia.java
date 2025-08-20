package app.springmedapi.service.validacoes;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.infra.exception.ValidacaoException;
import app.springmedapi.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidarPacienteSemOutraConsultaNoDia implements ValidadorAGendamentosConsultas{
    private final AgendamentoRepository agendamentoRepository;

    public ValidarPacienteSemOutraConsultaNoDia(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public void validar(AgendamentoRequestDTO dto){
        boolean possuiAgendamentoNoDia = agendamentoRepository.isHasScheduleOnDay(dto.idPaciente(),dto.data());

        if (possuiAgendamentoNoDia){
            throw new ValidacaoException("Você já tem agendamentos marcados para o dia: "+dto.data());
        }

    }
}
