package serv.saboresdecasa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PedidoTotalPriceDTO {
    Integer id;
    Integer idCliente;
    Integer idPromocion;
    Double totalPrice;

    public PedidoTotalPriceDTO(PedidoDTO pedidoDTO) {
        this.id = pedidoDTO.getId();
        this.idCliente = pedidoDTO.getIdCliente();
        this.idPromocion = pedidoDTO.getIdPromocion();
        this.totalPrice = 0.0;
    }
}
