package serv.saboresdecasa.dto;

import lombok.Data;

@Data
public class PedidoTotalPriceDTO {
    Integer id;
    Integer idCliente;
    Short numMesa;
    String fecha;
    Integer idPromocion;
    Double totalPrice;

    public PedidoTotalPriceDTO(PedidoDTO pedidoDTO) {
        this.id = pedidoDTO.getId();
        this.idCliente = pedidoDTO.getIdCliente();
        this.numMesa = pedidoDTO.getNumMesa();
        this.fecha = pedidoDTO.getFecha();
        this.idPromocion = pedidoDTO.getIdPromocion();
        this.totalPrice = 0.0;
    }
}
