package serv.saboresdecasa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import serv.saboresdecasa.dto.ClienteDTO;
import serv.saboresdecasa.model.Cliente;
import serv.saboresdecasa.model.Pedido;
import serv.saboresdecasa.repository.ClienteRepository;
import serv.saboresdecasa.service.PedidoService;

import java.util.List;

@Mapper
public abstract class ClienteMapper {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Mapping(target = "numPedidos", source = "id", qualifiedByName = "numPedidos")
    @Mapping(target = "gastoTotal", source = "id", qualifiedByName = "gastoTotal")
    public abstract ClienteDTO toDTO(Cliente cliente);

    @Mapping(target = "pedidos", ignore = true)
    public abstract Cliente toModel(ClienteDTO clienteDTO);

    public abstract List<ClienteDTO> toDTOList(List<Cliente> clientes);

    public abstract List<Cliente> toModelList(List<ClienteDTO> clienteDTOs);

    @Named("numPedidos")
    public Integer numPedidos(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            return 0;
        }
        return cliente.getPedidos().size();
    }

    @Named("gastoTotal")
    public Double gastoTotal(Integer idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            return 0.0;
        }
        Double gastoTotal = 0.0;
        for (Pedido pedido : cliente.getPedidos()) {
            gastoTotal += pedidoService.getTotalPrice(pedido.getId());
        }
        return gastoTotal;
    }
}
