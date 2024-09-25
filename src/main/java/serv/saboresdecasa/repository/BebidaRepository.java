package serv.saboresdecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serv.saboresdecasa.model.Bebida;

import java.util.List;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer> {
    List<Bebida> findBebidaByNombreContaining(String nombre);
}
