package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    Integer id;
    String nombre;
    String apellidos;
    Integer numPedidos;
    Double gastoTotal;
}
