package app.springmedapi.controller;

import app.springmedapi.entity.dto.ListagemMedicoDTO;
import app.springmedapi.entity.dto.MedicoDTO;
import app.springmedapi.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDTO>> listarMedicos(
            @PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ListagemMedicoDTO> medicos = medicoService.listarMedicos(pageable);
        return ResponseEntity.ok(medicos);
    }
}