package app.springmedapi.controller;

import app.springmedapi.entity.dto.AtualizarMeditoDTO;
import app.springmedapi.entity.dto.DadosDetalhamentoMedicoDTO;
import app.springmedapi.entity.dto.ListarMedicoDTO;
import app.springmedapi.entity.dto.CadastrarMedicoDTO;
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
    public ResponseEntity<CadastrarMedicoDTO> cadastrarMedico(@RequestBody @Valid CadastrarMedicoDTO medico) {
        CadastrarMedicoDTO medicoSalvo = medicoService.createDoctor(medico);
        return ResponseEntity.ok(medicoSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<ListarMedicoDTO>> listarMedicos(
            @PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ListarMedicoDTO> medicos = medicoService.listarMedicos(pageable);
        return ResponseEntity.ok(medicos);
    }
    @PutMapping
    public ResponseEntity<DadosDetalhamentoMedicoDTO> atualizarMedico(@RequestBody @Valid AtualizarMeditoDTO medico) {
        DadosDetalhamentoMedicoDTO response = medicoService.atualizarMedico(medico.id(), medico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }
}