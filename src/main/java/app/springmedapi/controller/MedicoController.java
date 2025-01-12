package app.springmedapi.controller;

import app.springmedapi.entity.medicoDTO.AtualizarMeditoDTO;
import app.springmedapi.entity.medicoDTO.DadosDetalhamentoMedicoDTO;
import app.springmedapi.entity.medicoDTO.ListarMedicoDTO;
import app.springmedapi.entity.medicoDTO.CadastrarMedicoDTO;
import app.springmedapi.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin("*")
@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<DadosDetalhamentoMedicoDTO> cadastrarMedico(@RequestBody @Valid CadastrarMedicoDTO medico, UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoMedicoDTO MedicoSalvo = medicoService.createDoctor(medico);

        UriComponents uri = uriBuilder.path("/medicos/{id}").buildAndExpand(MedicoSalvo.id());

        return ResponseEntity.created(uri.toUri()).body(MedicoSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<ListarMedicoDTO>> listarMedicos(
            @PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ListarMedicoDTO> medicos = medicoService.listarMedicos(pageable);
        return ResponseEntity.ok(medicos);
    }
    @PutMapping
    public ResponseEntity<DadosDetalhamentoMedicoDTO> atualizarMedico(@RequestBody @Valid AtualizarMeditoDTO medico) {
        DadosDetalhamentoMedicoDTO response = medicoService.atualizarMedico(medico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedicoDTO> detalharMedico(@PathVariable Long id){
        DadosDetalhamentoMedicoDTO medico = medicoService.detalharMedico(id);
        return ResponseEntity.ok(medico);
    }
}