package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import serv.saboresdecasa.model.Plato;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    Integer id;
    String nombre;

    public PlatoDTO(Plato plato) {
        if (plato == null) {
            return;
        }

        this.id = plato.getId();
        this.nombre = plato.getNombre();
    }

    public Plato convertToPlato() {
        return new Plato(this.id, this.nombre, null, null);
    }

    public Plato convertToPlato(Plato plato) {
        return new Plato(this.id, this.nombre, plato.getIngredientes(), plato.getTipoPlatos());
    }
}