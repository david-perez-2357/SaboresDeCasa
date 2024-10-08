package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.model.Ingrediente;
import serv.saboresdecasa.model.TipoPlato;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    Integer id;
    String nombre;

    public PlatoDTO(Plato plato) {
        this.id = plato.getId();
        this.nombre = plato.getNombre();
    }

    public Plato convertToPlato() {
        return new Plato(this.id, this.nombre, null, null);
    }
}