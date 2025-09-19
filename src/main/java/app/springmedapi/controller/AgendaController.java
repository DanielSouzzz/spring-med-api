package app.springmedapi.controller;

import app.springmedapi.entity.AgendamentoDTO.AgendamentoRequestDTO;
import app.springmedapi.entity.AgendamentoDTO.AgendamentoResponseDTO;
import app.springmedapi.entity.agenda.AgendaRequestDTO;
import app.springmedapi.entity.agenda.AgendaResponseDTO;
import app.springmedapi.service.AgendaService;
import app.springmedapi.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agenda")
@SecurityRequirement(name = "bearer-key")
public class AgendaController {
    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping
    @Operation(
            summary = "Libera horários na agenda",
            description = "Recebe os dados de horários disponíveis e retorna a agenda criada."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Horários liberados com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<AgendaResponseDTO> liberarHorarios(@Valid @RequestBody AgendaRequestDTO agendaResquestDTO){
        AgendaResponseDTO agenda = agendaService.liberarHorarios(agendaResquestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(agenda);
    }
}
