package serv.saboresdecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serv.saboresdecasa.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String userName);
}
