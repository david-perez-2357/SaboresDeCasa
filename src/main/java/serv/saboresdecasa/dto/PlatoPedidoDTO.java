package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoPedidoDTO {
    Integer id;
    Integer idPedido;
    Integer idTipoPlato;
    Integer cantidad;
    Boolean servido;
    BigDecimal precio;
}
