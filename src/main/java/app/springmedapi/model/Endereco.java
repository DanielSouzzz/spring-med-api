package app.springmedapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "enderecos")
@Entity(name = "enderecos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    @OneToMany(mappedBy = "endereco")
    private List<Medico> medicos;
}