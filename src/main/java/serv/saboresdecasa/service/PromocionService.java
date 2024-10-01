package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.Promocion;
import serv.saboresdecasa.repository.PromocionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PromocionService {
    private PromocionRepository promocionRepository;

    /**
     * Delete a promotion by id
     * @param id Integer
     */
    public void delete(Integer id) {
        promocionRepository.deleteById(id);
    }

    /**
     * Save a promotion
     * @param promocion Promocion
     * @return Promocion
     */
    public Promocion save(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    /**
     * Get a promotion by id
     * @param id Integer
     * @return Promocion
     */
    public Promocion getById(Integer id) {
        return promocionRepository.findById(id).orElse(null);
    }

    /**
     * Get all promotions
     * @return List<Promocion>
     */
    public List<Promocion> getAll() {
        return promocionRepository.findAll();
    }
}
