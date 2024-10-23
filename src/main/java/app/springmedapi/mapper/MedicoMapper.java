package app.springmedapi.mapper;

import app.springmedapi.entity.Medico;
import app.springmedapi.entity.dto.ListagemMedicoDTO;
import app.springmedapi.entity.dto.MedicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class})
public interface MedicoMapper {
    @Mapping(source = "endereco", target = "endereco")
    MedicoDTO toMedicoDTO(Medico medico);

    @Mapping(source = "endereco", target = "endereco")
    Medico toMedico(MedicoDTO medicoDTO);

    ListagemMedicoDTO toListagemMedicoDTO(Medico medico);
}

