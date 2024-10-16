package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.enumerator.TiposPlato;
import serv.saboresdecasa.model.TipoPlato;
import serv.saboresdecasa.repository.TipoPlatoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TipoPlatoService {
    private TipoPlatoRepository tipoPlatoRepository;

    /**
     * Delete a dish type by id
     * @param id Integer
     */
    public void delete(Integer id) {
        tipoPlatoRepository.deleteById(id);
    }

    /**
     * Save a dish type
     * @param tipoPlato TipoPlato
     * @return TipoPlato
     */
    public TipoPlato save(TipoPlato tipoPlato) {
        return tipoPlatoRepository.save(tipoPlato);
    }

    /**
     * Get a dish type by id
     * @param id Integer
     * @return TipoPlato
     */
    public TipoPlato findById(Integer id) {
        return tipoPlatoRepository.findById(id).orElse(null);
    }

    /**
     * Get all dish types
     * @return List<TipoPlato>
     */
    public List<TipoPlato> getAll() {
        return tipoPlatoRepository.findAll();
    }

    /**
     * Get all dishes by type id
     * @param id Integer
     * @return List<TipoPlato>
     */
    public List<TipoPlato> getByTipo(Integer id) {
        return tipoPlatoRepository.findByTipo(TiposPlato.values()[id]);
    }
}
