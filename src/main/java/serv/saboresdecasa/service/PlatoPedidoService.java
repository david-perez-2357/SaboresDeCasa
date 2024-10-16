package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.PlatoPedido;
import serv.saboresdecasa.repository.PlatoPedidoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatoPedidoService {
    private PlatoPedidoRepository platoPedidoRepository;

    /**
     * Delete a dish order by id
     * @param idPlatoPedido Integer
     */
    public void delete(Integer idPlatoPedido) {
        platoPedidoRepository.deleteById(idPlatoPedido);
    }

    /**
     * Find a dish order by id
     * @param idPlatoPedido Integer
     * @return PlatoPedido
     */
    public PlatoPedido findById(Integer idPlatoPedido) {
        if (idPlatoPedido == null) {
            return null;
        }
        return platoPedidoRepository.findById(idPlatoPedido).orElse(null);
    }

    /**
     * Save a dish order, if it already exists, it updates it
     * @param platoPedido PlatoPedido
     * @return PlatoPedido
     */
    public PlatoPedido save(PlatoPedido platoPedido) {
        return platoPedidoRepository.save(platoPedido);
    }

    /**
     * Get all records
     * @return List<PlatoPedido>
     */
    public List<PlatoPedido> getAll() {
        return platoPedidoRepository.findAll();
    }
}
