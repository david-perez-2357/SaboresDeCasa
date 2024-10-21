package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import serv.saboresdecasa.model.Pedido;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    Integer id;
    Integer idCliente;
    Short numMesa;
    String fecha;
    Integer idPromocion;
}
