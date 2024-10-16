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
}