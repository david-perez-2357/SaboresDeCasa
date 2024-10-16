package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.dto.PedidoDTO;
import serv.saboresdecasa.dto.PlatoPedidoDTO;
import serv.saboresdecasa.mapper.PedidoMapper;
import serv.saboresdecasa.mapper.PlatoPedidoMapper;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.model.BebidaPedido;
import serv.saboresdecasa.model.Pedido;
import serv.saboresdecasa.model.PlatoPedido;
import serv.saboresdecasa.repository.PedidoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {
    private PedidoRepository pedidoRepository;
    private PedidoMapper pedidoMapper;
    private PlatoPedidoMapper platoPedidoMapper;
    private PlatoPedidoService platoPedidoService;

    /**
     * Delete order by id
     * @param idPedido Integer
     */
    public void delete(Integer idPedido) {
        pedidoRepository.deleteById(idPedido);
    }

    /**
     * Find an order by id
     * @param idPedido Integer
     * @return PedidoDTO
     */
    public PedidoDTO findById(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        return pedidoMapper.toDTO(pedido);
    }

    /**
     * Find an order by id
     * @param idPedido Integer
     * @return Pedido
     */
    public Pedido findPedidoById(Integer idPedido) {
        return pedidoRepository.findById(idPedido).orElse(null);
    }

    /**
     * Save an order, if it already exists, it updates it
     * @param pedidoDTO Pedido
     * @return Pedido
     */
    public PedidoDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.toModel(pedidoDTO);

        Pedido pedidoSaved = pedidoRepository.save(pedido);
        return pedidoMapper.toDTO(pedidoSaved);
    }

    /**
     * Get all records
     * @return List<Pedido>
     */
    public List<PedidoDTO> getAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedidoMapper::toDTO).toList();
    }

    /**
     * Get all dishes from an order
     * @param idPedido Integer
     * @return List<String>
     */
    public List<PlatoPedidoDTO> getPlatos(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            return new ArrayList<>();
        }

        List<PlatoPedido> platos = pedido.getPlatoPedidos().stream().toList();
        return platoPedidoMapper.toDTOList(platos);
    }

    /**
     * Get all drinks from an order
     * @param idPedido Integer
     * @return List<Bebida>
     */
    public List<Bebida> getBebidas(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            return null;
        }

        List<BebidaPedido> bebidas = pedido.getBebidaPedidos().stream().toList();
        return bebidas.stream().map(BebidaPedido::getBebida).toList();
    }

    /**
     * Add a dish to an order
     * @param idPedido Integer
     * @param platoPedidoDTO PlatoPedido
     */
    public PlatoPedidoDTO addPlato(Integer idPedido, PlatoPedidoDTO platoPedidoDTO) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            return null;
        }
        PlatoPedido foundPlatoPedido = platoPedidoService.findById(platoPedidoDTO.getId());
        PlatoPedido platoPedido = platoPedidoMapper.toModel(platoPedidoDTO);

        if (foundPlatoPedido == null) {
            platoPedido = platoPedidoService.save(platoPedido);
        }

        pedido.getPlatoPedidos().add(platoPedido);
        return platoPedidoMapper.toDTO(platoPedido);
    }
}
