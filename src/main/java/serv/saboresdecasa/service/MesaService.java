package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.Mesa;
import serv.saboresdecasa.repository.MesaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MesaService {
    private MesaRepository mesaRepository;

    /**
     * Delete a table by id
     * @param idMesa Integer
     */
    public void delete(Integer idMesa) {
        mesaRepository.deleteById(idMesa);
    }

    /**
     * Find a table by id
     * @param idMesa Integer
     * @return Mesa
     */
    public Mesa findById(Integer idMesa) {
        return mesaRepository.findById(idMesa).orElse(null);
    }

    /**
     * Save a table, if it already exists, it updates it
     * @param mesa Mesa
     * @return Mesa
     */
    public Mesa save(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    /**
     * Get all records
     * @return List<Mesa>
     */
    public List<Mesa> getAll() {
        return mesaRepository.findAll();
    }
}
