package serv.saboresdecasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.model.BebidaPedido;
import serv.saboresdecasa.model.Pedido;

import java.util.List;

@Repository
public interface BebidaPedidoRepository extends JpaRepository<BebidaPedido, Integer> {
    List<BebidaPedido> findByPedido(Pedido pedido);
    List<BebidaPedido> findByBebida(Bebida bebida);
}
