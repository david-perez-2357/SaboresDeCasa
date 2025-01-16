package serv.saboresdecasa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import serv.saboresdecasa.enumerator.TiposPlato;
import serv.saboresdecasa.model.*;
import serv.saboresdecasa.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@SpringBootTest
@AutoConfigureTestDatabase
@DisplayName("\uD83D\uDCC1 Add All Data")
class AddAllData {
    @Autowired
    private BebidaRepository bebidaRepository;
    @Autowired
    private PlatoRepository platoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PlatoPedidoRepository platoPedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private MesaRepository mesaRepository;
    @Autowired
    private PromocionRepository promocionRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private TipoPlatoRepository tipoPlatoRepository;
    @Autowired
    private BebidaPedidoRepository bebidaPedidoRepository;

    @Test
    @DisplayName("\uD83D\uDCCA Add data to all tables")
    @BeforeEach
    void addDataToAllTables() {
        System.out.println("Adding data to all tables...");
        Bebida bebida = new Bebida();
        bebida.setNombre("Coca Cola");
        bebida.setMlDeCapacidad(500);
        bebidaRepository.save(bebida);
        System.out.println("Added data to Bebida table");

        Plato plato = new Plato();
        plato.setNombre("Pizza");
        platoRepository.save(plato);
        System.out.println("Added data to Plato table");

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Queso");
        ingredienteRepository.save(ingrediente);
        System.out.println("Added data to Ingrediente table");

        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setNombre("Tomate");
        ingredienteRepository.save(ingrediente2);
        System.out.println("Added data to Ingrediente table");

        TipoPlato tipoPlato = new TipoPlato();
        tipoPlato.setTipo(TiposPlato.PRINCIPAL);
        tipoPlato.setPrecio(BigDecimal.valueOf(10.0));
        tipoPlato.setPlato(plato);
        tipoPlatoRepository.save(tipoPlato);
        System.out.println("Added data to TipoPlato table");

        plato.setIngredientes(Set.of(ingrediente, ingrediente2));
        platoRepository.save(plato);
        System.out.println("Added relations to Plato table");

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidos("Perez");
        cliente.setTelefono("123456789");
        clienteRepository.save(cliente);
        System.out.println("Added data to Cliente table");

        Mesa mesa = new Mesa();
        mesa.setId(Short.valueOf("1"));
        mesa.setCapacidad(Short.valueOf("4"));
        mesaRepository.save(mesa);
        System.out.println("Added data to Mesa table");

        Promocion promocion = new Promocion();
        promocion.setTitulo("2x1");
        promocion.setPorcentajeDescuento(Short.valueOf("50"));
        promocion.setDescripcion("Lleva 2 platos y paga 1");
        promocionRepository.save(promocion);
        System.out.println("Added data to Promocion table");

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setMesa(mesa);
        pedido.setPromocion(promocion);
        pedido.setFecha(LocalDate.now().atStartOfDay());
        pedidoRepository.save(pedido);
        System.out.println("Added data to Pedido table");

        PlatoPedido platoPedido = new PlatoPedido();
        platoPedido.setPedido(pedido);
        platoPedido.setTipoPlato(tipoPlato);
        platoPedido.setCantidad(1);
        platoPedido.setServido(false);
        platoPedido.setPrecio(BigDecimal.valueOf(10.0));
        pedido.setPlatoPedidos(Set.of(platoPedido));
        pedidoRepository.save(pedido);
        platoPedidoRepository.save(platoPedido);
        System.out.println("Added data to PlatoPedido table");

        BebidaPedido bebidaPedido = new BebidaPedido();
        bebidaPedido.setBebida(bebida);
        bebidaPedido.setPedido(pedido);
        bebidaPedido.setCantidad(2);
        bebidaPedido.setServido(false);
        bebidaPedido.setPrecio(BigDecimal.valueOf(5.0));
        pedido.setBebidaPedidos(Set.of(bebidaPedido));
        bebidaPedidoRepository.save(bebidaPedido);
        System.out.println("Added data to BebidaPedido table");
    }

//    @Test
//    void deleteDataFromAllTables() {
//        System.out.println("Deleting data from all tables...");
//        bebidaPedidoService.delete(1);
//        System.out.println("Deleted data from BebidaPedido table");
//
//        platoPedidoService.delete(1);
//        System.out.println("Deleted data from PlatoPedido table");
//
//        pedidoService.delete(1);
//        System.out.println("Deleted data from Pedido table");
//
//        promocionService.delete(1);
//        System.out.println("Deleted data from Promocion table");
//
//        mesaService.delete(1);
//        System.out.println("Deleted data from Mesa table");
//
//        clienteService.delete(1);
//        System.out.println("Deleted data from Cliente table");
//
//        tipoPlatoService.delete(1);
//        System.out.println("Deleted data from TipoPlato table");
//
//        platoService.delete(1);
//        System.out.println("Deleted data from Plato table");
//
//        ingredienteService.delete(1);
//        System.out.println("Deleted data from Ingrediente table");
//
//        ingredienteService.delete(2);
//        System.out.println("Deleted data from Ingrediente table");
//
//        bebidaService.delete(1);
//        System.out.println("Deleted data from Bebida table");
//
//        System.out.println("Deleted data from all tables");
//    }

//    @Test
//    void getAllDataFromAllTables() {
//        System.out.println("Getting all data from all tables...");
//        List<Bebida> bebidas = bebidaService.getAll();
//        System.out.println("Bebidas: " + bebidas);
//
//        List<Cliente> clientes = clienteService.getAll();
//        System.out.println("Clientes: " + clientes);
//
//        List<Ingrediente> ingredientes = ingredienteService.getAll();
//        System.out.println("Ingredientes: " + ingredientes);
//
//        List<Mesa> mesas = mesaService.getAll();
//        System.out.println("Mesas: " + mesas);
//
//        List<Pedido> pedidos = pedidoService.getAll();
//        System.out.println("Pedidos: " + pedidos);
//
//        List<Plato> platos = platoService.getAll();
//        System.out.println("Platos: " + platos);
//
//        List<Promocion> promociones = promocionService.getAll();
//        System.out.println("Promociones: " + promociones);
//
//        List<TipoPlato> tiposPlato = tipoPlatoService.getAll();
//        System.out.println("TiposPlato: " + tiposPlato);
//
//        List<BebidaPedido> bebidaPedidos = bebidaPedidoService.getAll();
//        System.out.println("BebidaPedidos: " + bebidaPedidos);
//
//        List<PlatoPedido> platoPedidos = platoPedidoService.getAll();
//        System.out.println("PlatoPedidos: " + platoPedidos);
//    }

//    @Test
//    void getOneDataFromAllTables() {
//        System.out.println("Getting one data from all tables...");
//        Bebida bebida = bebidaService.findById(1);
//        System.out.println("Bebida: " + bebida);
//
//        Cliente cliente = clienteService.findById(1);
//        System.out.println("Cliente: " + cliente);
//
//        Ingrediente ingrediente = ingredienteService.findById(1);
//        System.out.println("Ingrediente: " + ingrediente);
//
//        Mesa mesa = mesaService.findById(1);
//        System.out.println("Mesa: " + mesa);
//
//        Pedido pedido = pedidoService.findById(1);
//        System.out.println("Pedido: " + pedido);
//
//        Plato plato = platoService.findById(1);
//        System.out.println("Plato: " + plato);
//
//        Promocion promocion = promocionService.findById(1);
//        System.out.println("Promocion: " + promocion);
//
//        TipoPlato tipoPlato = tipoPlatoService.findById(1);
//        System.out.println("TipoPlato: " + tipoPlato);
//
//        BebidaPedido bebidaPedido = bebidaPedidoService.findById(1);
//        System.out.println("BebidaPedido: " + bebidaPedido);
//
//        PlatoPedido platoPedido = platoPedidoService.findById(1);
//        System.out.println("PlatoPedido: " + platoPedido);
//    }
}
