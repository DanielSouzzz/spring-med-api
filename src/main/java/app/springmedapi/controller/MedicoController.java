package app.springmedapi.controller;

import app.springmedapi.entity.dto.MedicoDTO;
import app.springmedapi.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> cadastrarMedico(@RequestBody @Valid MedicoDTO medico) {
        MedicoDTO medicoSalvo = medicoService.createDoctor(medico);
        return ResponseEntity.ok(medicoSalvo);
    }
}