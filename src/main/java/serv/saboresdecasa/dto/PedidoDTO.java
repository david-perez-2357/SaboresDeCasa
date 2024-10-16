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

//    public PedidoDTO(Pedido pedido) {
//        if (pedido == null) {
//            return;
//        }
//
//        this.id = pedido.getId();
//        this.idCliente = pedido.getCliente().getId();
//        this.numMesa = pedido.getMesa().getId();
//        this.fecha = pedido.getFecha();
//        this.idPromocion = pedido.getPromocion().getId();
//    }
//
//    public Pedido convertToPedido() {
//        return new Pedido(this.id, null, null, this.fecha, null, null, null);
//    }
}
