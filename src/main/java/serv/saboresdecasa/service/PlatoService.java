package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.dto.PlatoDTO;
import serv.saboresdecasa.mapper.PlatoMapper;
import serv.saboresdecasa.mapper.PlatoMapperImpl;
import serv.saboresdecasa.model.Ingrediente;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.repository.PlatoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlatoService {
    private final IngredienteService ingredienteService;
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
     * @return PlatoDTO
     */
    public PlatoDTO findById(Integer idPlato) {
        Plato plato = platoRepository.findById(idPlato).orElse(null);
        return new PlatoDTO(plato);
    }

    /**
     * Find a dish by id
     * @param idPlato Integer
     * @return Plato
     */
    public Plato findPlatoById(Integer idPlato) {
        return platoRepository.findById(idPlato).orElse(null);
    }

    /**
     * Save a dish, if it already exists, it updates it
     * @param plato Plato
     * @return Plato
     */
    public PlatoDTO save(Plato plato) {
        Plato platoSaved = platoRepository.save(plato);
        return new PlatoDTO(platoSaved);
    }

    /**
     * Get all records
     * @return List<Plato>
     */
    public List<PlatoDTO> getAll() {
        List<Plato> platos = platoRepository.findAll();
        List<PlatoDTO> platoDTOS = new ArrayList<>();
        PlatoMapper platoMapper = new PlatoMapperImpl();

        return platoMapper.toDTOList(platos);
    }

    /**
     * Get all ingredients from a dish
     * @param idPlato Integer
     * @return List<Ingrediente>
     */
    public List<Ingrediente> getIngredientes(Integer idPlato) {
        Plato plato = platoRepository.findById(idPlato).orElse(null);
        if (plato == null) {
            return null;
        }
        return plato.getIngredientes().stream().toList();
    }

    /**
     * Add an ingredient to a dish
     * @param idPlato Integer
     * @param idIngrediente Integer
     * @return PlatoDTO
     */
    public PlatoDTO addIngredient(Integer idPlato, Integer idIngrediente) {
        PlatoMapper platoMapper = new PlatoMapperImpl();
        Plato plato = findPlatoById(idPlato);
        Ingrediente ingrediente = ingredienteService.findById(idIngrediente);
        System.out.println((plato == null) + " " + (ingrediente == null));
        if (plato == null || ingrediente == null) {
            return null;
        }
        plato.getIngredientes().add(ingrediente);
        return save(plato);
    }

    /**
     * Delete an ingredient from a dish
     * @param idPlato Integer
     * @param idIngrediente Integer
     * @return PlatoDTO
     */
    public PlatoDTO deleteIngredient(Integer idPlato, Integer idIngrediente) {
        Plato plato = findPlatoById(idPlato);
        Ingrediente ingrediente = ingredienteService.findById(idIngrediente);
        if (plato == null || ingrediente == null) {
            return null;
        }
        plato.getIngredientes().remove(ingrediente);
        return save(plato);
    }
}
