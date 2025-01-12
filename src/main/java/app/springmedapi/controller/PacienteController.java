package app.springmedapi.controller;

import app.springmedapi.entity.pacienteDTO.CadastrarPacienteDTO;
import app.springmedapi.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*")  // Corrigido o uso do @CrossOrigin
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;  // Corrigido a declaração do serviço

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public CadastrarPacienteDTO cadastrarPaciente(@RequestBody @Valid CadastrarPacienteDTO cadastrarPacienteDTO, UriComponentsBuilder uriBuilder) {
        CadastrarPacienteDTO pacienteSalvo = pacienteService.createPatient(cadastrarPacienteDTO);  // Corrigido o nome do método

        return pacienteSalvo;
    }
}
