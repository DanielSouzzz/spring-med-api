package app.springmedapi.mapper;

import app.springmedapi.entity.Medico;
import app.springmedapi.entity.dto.AtualizarMeditoDTO;
import app.springmedapi.entity.dto.ListarMedicoDTO;
import app.springmedapi.entity.dto.CadastrarMedicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class})
public interface MedicoMapper {
    @Mapping(source = "endereco", target = "endereco")
    CadastrarMedicoDTO toMedicoDTO(Medico medico);

    @Mapping(source = "endereco", target = "endereco")
    Medico toMedico(CadastrarMedicoDTO medicoDTO);

    @Mapping(source = "endereco", target = "endereco")
    AtualizarMeditoDTO toAtualizarMedicoDTO(Medico medico);

    @Mapping(source = "endereco", target = "endereco")
    Medico toMedicoAtualizado(AtualizarMeditoDTO medicoDTO);

    ListarMedicoDTO toListagemMedicoDTO(Medico medico);
}