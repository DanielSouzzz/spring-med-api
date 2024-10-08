package app.springmedapi.controller;

import app.springmedapi.model.dto.DadosMedicoDTO;
import app.springmedapi.repository.MedicoRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoRepository repository;

    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void cadastrar(@RequestBody DadosMedicoDTO dados){
        System.out.println("hello");
    }
}
