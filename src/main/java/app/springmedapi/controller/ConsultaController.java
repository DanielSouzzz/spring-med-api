package app.springmedapi.controller;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
import app.springmedapi.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final AgendamentoService agendamentoService;

    public ConsultaController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponseDTO> agendar(@Valid @RequestBody AgendamentoRequestDTO agendamentoRequestDTO) {
        AgendamentoResponseDTO agendamento = agendamentoService.agendar(agendamentoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamento);
    }
}
