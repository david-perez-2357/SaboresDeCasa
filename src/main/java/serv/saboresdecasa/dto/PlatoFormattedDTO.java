package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoFormattedDTO {
    Integer id;
    Integer idPlato;
    String nombre;
    BigDecimal precio;
    String tipo;
}
