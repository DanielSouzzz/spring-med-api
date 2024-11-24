package app.springmedapi.entity;

import app.springmedapi.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;
    private Boolean ativo = true;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", nullable = true)
    private Endereco endereco;

    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", crm='" + crm + '\'' +
                ", telefone='" + telefone + '\'' +
                ", especialidade=" + especialidade +
                ", endereco=" + endereco +
                '}';
    }
}
