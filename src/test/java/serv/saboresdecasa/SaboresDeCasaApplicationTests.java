package serv.saboresdecasa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import serv.saboresdecasa.enumerator.TiposPlato;
import serv.saboresdecasa.model.*;
import serv.saboresdecasa.repository.BebidaRepository;
import serv.saboresdecasa.service.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootTest
class SaboresDeCasaApplicationTests {
    @Autowired
    private BebidaService bebidaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private IngredienteService ingredienteService;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PlatoService platoService;
    @Autowired
    private PromocionService promocionService;
    @Autowired
    private TipoPlatoService tipoPlatoService;

    @Test
    void contextLoads() {
        System.out.println("Context loads...");
        assert true;
    }

    @Test
    void addDataToAllTables() {
        System.out.println("Adding data to all tables...");
        Bebida bebida = new Bebida();
        bebida.setId(4);
        bebida.setNombre("Coca Cola");
        bebida.setMlDeCapacidad(500);
        bebidaService.save(bebida);
        System.out.println("Added data to Bebida table");

        Plato plato = new Plato();
        plato.setNombre("Pizza");
        platoService.save(plato);
        System.out.println("Added data to Plato table");

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Queso");
        ingredienteService.save(ingrediente);
        System.out.println("Added data to Ingrediente table");

        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setNombre("Tomate");
        ingredienteService.save(ingrediente2);
        System.out.println("Added data to Ingrediente table");

        TipoPlato tipoPlato = new TipoPlato();
        tipoPlato.setTipo(TiposPlato.PRINCIPAL);
        tipoPlato.setPrecio(BigDecimal.valueOf(10.0));
        tipoPlato.setPlato(plato);
        tipoPlatoService.save(tipoPlato);
        System.out.println("Added data to TipoPlato table");

        plato.setIngredientes(Set.of(ingrediente, ingrediente2));
        platoService.save(plato);
        System.out.println("Added relations to Plato table");

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidos("Perez");
        cliente.setTelefono("123456789");
        clienteService.save(cliente);
        System.out.println("Added data to Cliente table");

        Mesa mesa = new Mesa();
        mesa.setId(Short.valueOf("1"));
        mesa.setCapacidad(Short.valueOf("4"));
        mesaService.save(mesa);
        System.out.println("Added data to Mesa table");

        Promocion promocion = new Promocion();
        promocion.setTitulo("2x1");
        promocion.setPorcentajeDescuento(Short.valueOf("50"));
        promocion.setDescripcion("Lleva 2 platos y paga 1");
        promocionService.save(promocion);
        System.out.println("Added data to Promocion table");

        Pedido pedido = new Pedido();
        pedido.setId(1);
        pedido.setCliente(cliente);
        pedido.setMesa(mesa);
        pedido.setPromocion(promocion);
        pedido.setFecha(Instant.now());
        pedidoService.save(pedido);
        System.out.println("Added data to Pedido table");

        PlatoPedido platoPedido = new PlatoPedido();
        platoPedido.setPlato(plato);
        platoPedido.setPedido(pedido);
        platoPedido.setTipoPlato(tipoPlato);
        platoPedido.setCantidad(1);
        platoPedido.setServido(false);
        platoPedido.setPrecio(BigDecimal.valueOf(10.0));
        pedido.setPlatoPedidos(Set.of(platoPedido));
        pedidoService.save(pedido);
        System.out.println("Added data to PlatoPedido table");

        BebidaPedido bebidaPedido = new BebidaPedido();
        bebidaPedido.setBebida(bebida);
        bebidaPedido.setPedido(pedido);
        bebidaPedido.setCantidad(2);
        bebidaPedido.setServido(false);
        bebidaPedido.setPrecio(BigDecimal.valueOf(5.0));
        pedido.setBebidaPedidos(Set.of(bebidaPedido));
        pedidoService.save(pedido);
        System.out.println("Added data to BebidaPedido table");
    }
}
