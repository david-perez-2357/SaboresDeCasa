package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.Ingrediente;
import serv.saboresdecasa.repository.IngredienteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredienteService {
    private IngredienteRepository ingredienteRepository;

    /**
     * Delete an ingredient by id
     * @param idIngrediente Integer
     */
    public void delete(Integer idIngrediente) {
        ingredienteRepository.deleteById(idIngrediente);
    }

    /**
     * Find an ingredient by id
     * @param idIngrediente Integer
     * @return Ingrediente
     */
    public Ingrediente findById(Integer idIngrediente) {
        return ingredienteRepository.findById(idIngrediente).orElse(null);
    }

    /**
     * Save an ingredient, if it already exists, it updates it
     * @param ingrediente Ingrediente
     * @return Ingrediente
     */
    public Ingrediente save(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    /**
     * Get all records
     * @return List<Ingrediente>
     */
    public List<Ingrediente> getAll() {
        return ingredienteRepository.findAll();
    }
}
