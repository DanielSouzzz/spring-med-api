package app.springmedapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Table(name = "enderecos")
@Entity(name = "enderecos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    @OneToMany(mappedBy = "endereco")
    private List<Medico> medicos;

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}