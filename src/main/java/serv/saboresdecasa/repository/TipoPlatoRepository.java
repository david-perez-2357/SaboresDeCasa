package serv.saboresdecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.model.TipoPlato;

import java.util.List;

@Repository
public interface TipoPlatoRepository extends JpaRepository<TipoPlato, Integer> {
    List<TipoPlato> findAllByPlato(Plato plato);
}
