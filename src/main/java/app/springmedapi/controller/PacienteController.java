package app.springmedapi.controller;

import app.springmedapi.entity.pacienteDTO.CadastrarPacienteDTO;
import app.springmedapi.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*")  // Corrigido o uso do @CrossOrigin
@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    private final PacienteService pacienteService;  // Corrigido a declaração do serviço

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    @Operation(
            summary = "Cadastrar um novo paciente",
            description = "Recebe os dados do paciente e retorna o paciente cadastrado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public CadastrarPacienteDTO cadastrarPaciente(
            @RequestBody @Valid CadastrarPacienteDTO cadastrarPacienteDTO,
            UriComponentsBuilder uriBuilder) {
        CadastrarPacienteDTO pacienteSalvo = pacienteService.createPatient(cadastrarPacienteDTO);
        return pacienteSalvo;
    }
}
