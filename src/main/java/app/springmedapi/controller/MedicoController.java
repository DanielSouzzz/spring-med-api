package app.springmedapi.controller;

import app.springmedapi.entity.medicoDTO.AtualizarMeditoDTO;
import app.springmedapi.entity.medicoDTO.DadosDetalhamentoMedicoDTO;
import app.springmedapi.entity.medicoDTO.ListarMedicoDTO;
import app.springmedapi.entity.medicoDTO.CadastrarMedicoDTO;
import app.springmedapi.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearer-key")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    @Operation(
            summary = "Cadastrar um novo médico",
            description = "Recebe os dados do médico e retorna o médico cadastrado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Médico cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<DadosDetalhamentoMedicoDTO> cadastrarMedico(
            @RequestBody @Valid CadastrarMedicoDTO medico,
            UriComponentsBuilder uriBuilder) {
        DadosDetalhamentoMedicoDTO MedicoSalvo = medicoService.createDoctor(medico);
        UriComponents uri = uriBuilder.path("/medicos/{id}").buildAndExpand(MedicoSalvo.id());
        return ResponseEntity.created(uri.toUri()).body(MedicoSalvo);
    }

    @GetMapping
    @Operation(
            summary = "Listar médicos",
            description = "Retorna uma lista paginada de médicos cadastrados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de médicos retornada com sucesso")
    })
    public ResponseEntity<Page<ListarMedicoDTO>> listarMedicos(
            @PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ListarMedicoDTO> medicos = medicoService.listarMedicos(pageable);
        return ResponseEntity.ok(medicos);
    }

    @PutMapping
    @Operation(
            summary = "Atualizar dados de um médico",
            description = "Atualiza os dados de um médico existente e retorna os dados atualizados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<DadosDetalhamentoMedicoDTO> atualizarMedico(@RequestBody @Valid AtualizarMeditoDTO medico) {
        DadosDetalhamentoMedicoDTO response = medicoService.atualizarMedico(medico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Excluir médico",
            description = "Exclui um médico pelo ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Médico excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado")
    })
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        medicoService.deletarMedico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Detalhar médico",
            description = "Retorna os dados detalhados de um médico pelo ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados do médico retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado")
    })
    public ResponseEntity<DadosDetalhamentoMedicoDTO> detalharMedico(@PathVariable Long id){
        DadosDetalhamentoMedicoDTO medico = medicoService.detalharMedico(id);
        return ResponseEntity.ok(medico);
    }
}