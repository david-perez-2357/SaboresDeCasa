package serv.saboresdecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serv.saboresdecasa.model.Pedido;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.model.PlatoPedido;

import java.util.List;

@Repository
public interface PlatoPedidoRepository extends JpaRepository<PlatoPedido, Integer> {
    List<PlatoPedido> findAllByPedido(Pedido pedido);
    List<PlatoPedido> findByPlato(Plato plato);
}
