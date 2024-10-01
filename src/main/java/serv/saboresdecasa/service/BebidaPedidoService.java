package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.BebidaPedido;
import serv.saboresdecasa.repository.BebidaPedidoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BebidaPedidoService {
    private BebidaPedidoRepository bebidaPedidoRepository;

    /**
     * Delete a drink order by id
     * @param idBebidaPedido Integer
     */
    public void delete(Integer idBebidaPedido) {
        bebidaPedidoRepository.deleteById(idBebidaPedido);
    }

    /**
     * Find a drink order by id
     * @param idBebidaPedido Integer
     * @return BebidaPedido
     */
    public BebidaPedido findById(Integer idBebidaPedido) {
        return bebidaPedidoRepository.findById(idBebidaPedido).orElse(null);
    }

    /**
     * Save a drink order, if it already exists, it updates it
     * @param bebidaPedido BebidaPedido
     * @return BebidaPedido
     */
    public BebidaPedido save(BebidaPedido bebidaPedido) {
        return bebidaPedidoRepository.save(bebidaPedido);
    }

    /**
     * Get all records
     * @return List<BebidaPedido>
     */
    public List<BebidaPedido> getAll() {
        return bebidaPedidoRepository.findAll();
    }
}
