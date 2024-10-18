package serv.saboresdecasa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import serv.saboresdecasa.dto.PedidoDTO;
import serv.saboresdecasa.model.Cliente;
import serv.saboresdecasa.model.Mesa;
import serv.saboresdecasa.model.Pedido;
import serv.saboresdecasa.model.Promocion;
import serv.saboresdecasa.repository.ClienteRepository;
import serv.saboresdecasa.service.MesaService;
import serv.saboresdecasa.service.PromocionService;

import java.util.List;

@Mapper
public abstract class PedidoMapper {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PromocionService promocionService;
    @Autowired
    private MesaService mesaService;

    @Mapping(target = "fecha", source = "fecha", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "idCliente", source = "cliente.id")
    @Mapping(target = "numMesa", source = "mesa.id")
    @Mapping(target = "idPromocion", source = "promocion.id")
    public abstract PedidoDTO toDTO(Pedido pedido);

    @Mapping(target = "fecha", source = "fecha", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "cliente", source = "idCliente", qualifiedByName = "idCliente")
    @Mapping(target = "promocion", source = "idPromocion", qualifiedByName = "idPromocion")
    @Mapping(target = "mesa", source = "numMesa", qualifiedByName = "numMesa")
    public abstract Pedido toModel(PedidoDTO pedidoDTO);

    public abstract List<PedidoDTO> toDTOList(List<Pedido> pedidos);
    public abstract List<Pedido> toModelList(List<PedidoDTO> pedidoDTOs);

    @Named("idCliente")
    public Cliente mapToCliente(Integer clienteId) {
        return clienteRepository.findById(clienteId).orElse(null);
    }

    @Named("idPromocion")
    public Promocion mapToPromocion(Integer promocionId) {
        if (promocionId == null) {
            return null;
        }
        return promocionService.findById(promocionId);
    }

    @Named("numMesa")
    public Mesa mapToNumMesa(Integer mesaId) {
        return mesaService.findById(mesaId);
    }
}
