package serv.saboresdecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serv.saboresdecasa.model.Cliente;
import serv.saboresdecasa.model.Pedido;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findAllByCliente(Cliente cliente);
}
