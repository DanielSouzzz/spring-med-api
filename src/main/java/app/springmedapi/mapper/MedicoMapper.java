package app.springmedapi.mapper;

import app.springmedapi.entity.Endereco;
import app.springmedapi.entity.Medico;
import app.springmedapi.entity.dto.EnderecoDTO;
import app.springmedapi.entity.dto.MedicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicoMapper {
    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    Medico toEntity(MedicoDTO dto);

    MedicoDTO toDto(Medico medico);

    Endereco toEntity(EnderecoDTO enderecoDTO);

    EnderecoDTO toDto(Endereco endereco);
}
