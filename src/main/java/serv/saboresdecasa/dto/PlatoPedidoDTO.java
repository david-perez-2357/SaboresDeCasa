package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import serv.saboresdecasa.model.PlatoPedido;
import serv.saboresdecasa.model.TipoPlato;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoPedidoDTO {
    Integer id;
    Integer idPlato;
    Integer idPedido;
    Integer idTipoPlato;
    Integer cantidad;
    Boolean servido;
    BigDecimal precio;

    public PlatoPedidoDTO(PlatoPedido platoPedido) {
        if (platoPedido == null) {
            return;
        }

        this.id = platoPedido.getId();
        this.idPlato = platoPedido.getPlato().getId();
        this.idPedido = platoPedido.getPedido().getId();
        this.idTipoPlato = platoPedido.getTipoPlato().getId();
        this.cantidad = platoPedido.getCantidad();
        this.servido = platoPedido.getServido();
        this.precio = platoPedido.getPrecio();
    }

    public PlatoPedido convertToPlatoPedido() {
        return new PlatoPedido(this.id, null, null, null, this.cantidad, this.servido, this.precio);
    }
}
