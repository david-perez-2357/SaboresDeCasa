package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.repository.PlatoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlatoService {
    private PlatoRepository platoRepository;

    /**
     * Delete a dish by id
     * @param idPlato Integer
     */
    public void delete(Integer idPlato) {
        platoRepository.deleteById(idPlato);
    }

    /**
     * Find a dish by id
     * @param idPlato Integer
     * @return Plato
     */
    public Plato findById(Integer idPlato) {
        return platoRepository.findById(idPlato).orElse(null);
    }

    /**
     * Save a dish, if it already exists, it updates it
     * @param plato Plato
     * @return Plato
     */
    public Plato save(Plato plato) {
        return platoRepository.save(plato);
    }

    /**
     * Get all records
     * @return List<Plato>
     */
    public List<Plato> getAll() {
        return platoRepository.findAll();
    }
}
