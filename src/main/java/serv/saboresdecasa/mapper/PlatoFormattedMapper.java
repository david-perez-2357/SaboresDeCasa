package serv.saboresdecasa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import serv.saboresdecasa.dto.PlatoFormattedDTO;
import serv.saboresdecasa.enumerator.TiposPlato;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.model.TipoPlato;

import java.util.List;

@Mapper
public abstract class PlatoFormattedMapper {
    @Mapping(target = "nombre", source = "plato", qualifiedByName = "nombre")
    @Mapping(target = "tipo", source = "tipo", qualifiedByName = "tipo")
    @Mapping(target = "idPlato", source = "plato", qualifiedByName = "idPlato")
    public abstract PlatoFormattedDTO toDTO(TipoPlato plato);

    @Mapping(target = "plato.nombre", source = "nombre")
    @Mapping(target = "tipo", source = "tipo")
    @Mapping(target = "plato.id", source = "idPlato")
    public abstract TipoPlato toModel(PlatoFormattedDTO platoFormattedDTO);

    public abstract List<PlatoFormattedDTO> toDTOList(List<TipoPlato> platos);
    public abstract List<TipoPlato> toModelList(List<PlatoFormattedDTO> platoFormattedDTO);

    @Named("nombre")
    public String mapToNombre(Plato plato) {
        return plato.getNombre();
    }

    @Named("tipo")
    public String mapToTipo(Integer tipoPlato) {
        return TiposPlato.values()[tipoPlato].name();
    }

    @Named("idPlato")
    public Integer mapToIdPlato(Plato plato) {
        return plato.getId();
    }
}
