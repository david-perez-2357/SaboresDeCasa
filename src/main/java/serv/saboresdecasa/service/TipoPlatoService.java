package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.enumerator.TiposPlato;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.model.TipoPlato;
import serv.saboresdecasa.repository.PlatoRepository;
import serv.saboresdecasa.repository.TipoPlatoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class TipoPlatoService {
    private TipoPlatoRepository tipoPlatoRepository;
    private PlatoRepository platoRepository;

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
        if (id == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        return tipoPlatoRepository.findByTipo(TiposPlato.values()[id]);
    }

    /**
     * Update the price of a dish type
     * @param idPlato Integer
     * @param idTipo Integer
     * @param price Double
     * @return TipoPlato
     */
    public TipoPlato updateTipoPlatoPrice(Integer idPlato, Integer idTipo, Double price) {
        if (idPlato == null || idTipo == null || price == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        if (idTipo < 0 || idTipo >= TiposPlato.values().length) {
            throw new NullPointerException("Invalid type");
        }

        TiposPlato tipo = TiposPlato.values()[idTipo];
        List<TipoPlato> tipoPlato = tipoPlatoRepository.findByTipo(tipo);
        Plato plato = platoRepository.findById(idPlato).orElse(null);
        TipoPlato tipoPlatoToUpdate = tipoPlato.stream().filter(tp -> tp.getPlato().equals(plato)).findFirst().orElse(null);

        if (tipoPlatoToUpdate != null) {
            tipoPlatoToUpdate.setPrecio(BigDecimal.valueOf(price));
            return tipoPlatoRepository.save(tipoPlatoToUpdate);
        }else {
            throw new NullPointerException("Product or format not exist");
        }
    }
}
