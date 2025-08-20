package app.springmedapi.service.validacoes;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface ValidadorAGendamentosConsultas {
    void validar(AgendamentoRequestDTO dto);
}
