package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.repository.BebidaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BebidaService {
    private BebidaRepository bebidaRepository;

    /**
     * Find a drink by name
     * @param name String
     * @return List<Bebida>
     */
    public List<Bebida> findByName(String name) {
        return bebidaRepository.findAllByNombreContaining(name);
    }

    /**
     * Get all records
     * @return List<Bebida>
     */
    public List<Bebida> getAll() {
        return bebidaRepository.findAll();
    }

    /**
     * Save a drink, if it already exists, it updates it
     * @param bebida Bebida
     * @return Bebida
     */
    public Bebida save(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }

    /**
     * Delete a drink by id
     * @param idBebida Integer
     */
    public void delete(Integer idBebida) {
        bebidaRepository.deleteById(idBebida);
    }

    /**
     * Find a drink by id
     * @param idBebida Integer
     * @return Bebida
     */
    public Bebida findById(Integer idBebida) {
        return bebidaRepository.findById(idBebida).orElse(null);
    }
}
