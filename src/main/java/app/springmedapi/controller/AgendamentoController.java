package app.springmedapi.controller;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
import app.springmedapi.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
@SecurityRequirement(name = "bearer-key")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    @Operation(
            summary = "Realiza o agendamento de uma consulta",
            description = "Recebe os dados do paciente e da consulta, e retorna o agendamento realizado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consulta agendada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para agendamento")
    })
    public ResponseEntity<AgendamentoResponseDTO> agendar(@Valid @RequestBody AgendamentoRequestDTO agendamentoRequestDTO) {
        AgendamentoResponseDTO agendamento = agendamentoService.agendar(agendamentoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamento);
    }
}
