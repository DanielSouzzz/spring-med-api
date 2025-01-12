package app.springmedapi.mapper;

import app.springmedapi.entity.Endereco;
import app.springmedapi.entity.medicoDTO.EnderecoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoDTO toEnderecoDTO(Endereco endereco);

    Endereco toEndereco(EnderecoDTO enderecoDTO);
}

