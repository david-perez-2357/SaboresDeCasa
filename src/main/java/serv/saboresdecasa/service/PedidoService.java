package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.Pedido;
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
     * @return Pedido
     */
    public Pedido findById(Integer idPedido) {
        return pedidoRepository.findById(idPedido).orElse(null);
    }

    /**
     * Save an order, if it already exists, it updates it
     * @param pedido Pedido
     * @return Pedido
     */
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    /**
     * Get all records
     * @return List<Pedido>
     */
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }
}
