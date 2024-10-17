package app.springmedapi.mapper;

import app.springmedapi.entity.Endereco;
import app.springmedapi.entity.Medico;
import app.springmedapi.entity.dto.EnderecoDTO;
import app.springmedapi.entity.dto.MedicoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoDTO toMedicoDTO(Medico medico);

    Medico toMedico(MedicoDTO medicoDTO);

    EnderecoDTO toEnderecoDTO(Endereco endereco);

    Endereco toEndereco(EnderecoDTO enderecoDTO);
}
