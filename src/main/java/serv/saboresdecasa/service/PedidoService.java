package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.dto.PedidoDTO;
import serv.saboresdecasa.dto.PlatoDTO;
import serv.saboresdecasa.dto.PlatoPedidoDTO;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.model.BebidaPedido;
import serv.saboresdecasa.model.Pedido;
import serv.saboresdecasa.model.PlatoPedido;
import serv.saboresdecasa.repository.PedidoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {
    private PedidoRepository pedidoRepository;

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
        return new PedidoDTO(pedido);
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
     * @param pedido Pedido
     * @return Pedido
     */
    public PedidoDTO save(PedidoDTO pedido) {
        Pedido pedidoSaved = pedidoRepository.save(pedido.convertToPedido());
        return new PedidoDTO(pedidoSaved);
    }

    /**
     * Get all records
     * @return List<Pedido>
     */
    public List<PedidoDTO> getAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoDTO::new).toList();
    }

    /**
     * Get all dishes from an order
     * @param idPedido Integer
     * @return List<String>
     */
    public List<PlatoDTO> getPlatos(Integer idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            return null;
        }

        List<PlatoPedido> platos = pedido.getPlatoPedidos().stream().toList();
        return platos.stream().map(PlatoPedido::getPlato).map(PlatoDTO::new).toList();
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
     * @param plato PlatoPedido
     */
    public PlatoPedidoDTO addPlato(Integer idPedido, PlatoPedidoDTO plato) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            return null;
        }

        PlatoPedido platoPedido = plato.convertToPlatoPedido();
        pedido.getPlatoPedidos().add(platoPedido);
        return new PlatoPedidoDTO(platoPedido);
    }
}
