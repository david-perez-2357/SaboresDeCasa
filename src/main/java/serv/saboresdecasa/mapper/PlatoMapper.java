package serv.saboresdecasa.mapper;

import org.mapstruct.Mapper;
import serv.saboresdecasa.dto.PlatoDTO;
import serv.saboresdecasa.model.Plato;

import java.util.List;

@Mapper
public interface PlatoMapper {
    PlatoDTO toDTO(Plato plato);

    Plato toModel(PlatoDTO platoDTO);

    List<PlatoDTO> toDTOList(List<Plato> platos);

    List<Plato> toModelList(List<PlatoDTO> platoDTOs);
}
