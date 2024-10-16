package serv.saboresdecasa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import serv.saboresdecasa.dto.PlatoPedidoDTO;
import serv.saboresdecasa.model.Pedido;
import serv.saboresdecasa.model.PlatoPedido;
import serv.saboresdecasa.model.TipoPlato;
import serv.saboresdecasa.repository.PedidoRepository;
import serv.saboresdecasa.service.TipoPlatoService;

import java.util.List;

@Mapper
public abstract class PlatoPedidoMapper {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private TipoPlatoService tipoPlatoService;

    @Mapping(target = "idPedido", source = "pedido.id")
    @Mapping(target = "idTipoPlato", source = "tipoPlato.id")
    public abstract PlatoPedidoDTO toDTO(PlatoPedido platoPedido);

    @Mapping(target = "pedido", source = "idPedido", qualifiedByName = "idPedido")
    @Mapping(target = "tipoPlato", source = "idTipoPlato", qualifiedByName = "idTipoPlato")
    public abstract PlatoPedido toModel(PlatoPedidoDTO platoPedidoDTO);

    public abstract List<PlatoPedidoDTO> toDTOList(List<PlatoPedido> platosPedidos);
    public abstract List<PlatoPedido> toModelList(List<PlatoPedidoDTO> platoPedidoDTO);


    @Named("idPedido")
    public Pedido mapToPedido(Integer pedidoId) {
        return pedidoRepository.findById(pedidoId).orElse(null);
    }

    @Named("idTipoPlato")
    public TipoPlato mapToTipoPlato(Integer tipoPlatoId) {
        return tipoPlatoService.findById(tipoPlatoId);
    }
}
