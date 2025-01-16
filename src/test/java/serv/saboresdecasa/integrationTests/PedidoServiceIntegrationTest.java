package serv.saboresdecasa.integrationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import serv.saboresdecasa.dto.PedidoDTO;
import serv.saboresdecasa.mapper.PedidoMapper;
import serv.saboresdecasa.model.Pedido;
import serv.saboresdecasa.repository.PedidoRepository;
import serv.saboresdecasa.service.PedidoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("\uD83E\uDD1D Integration Tests PedidoService")
public class PedidoServiceIntegrationTest {
    @InjectMocks
    private PedidoService pedidoService; //REAL
    @Mock
    private PedidoRepository pedidoRepository; //SIMULADO
    @Mock
    private PedidoMapper pedidoMapper;

//    @Test
//    public void testGetAll() {
//        //GIVEN
//        PedidoDTO pedido1 = new PedidoDTO(1, 1, (short) 1, "2021-06-01 12:00:00", 1);
//        List<Pedido> pedidosSim = new ArrayList<>(List.of(new Pedido()));
//
//        //WHEN
//        Mockito.when(pedidoRepository.findAll()).thenReturn(pedidosSim);
//        Mockito.when(pedidoMapper.toDTOList(pedidosSim)).thenReturn(List.of(pedido1));
//        List<PedidoDTO> pedidos = pedidoService.getAll();
//        //THEN
//        assertEquals(1, pedidos.size());
//    }

    @Test
    @Order(2)
    @DisplayName("④ Incorrect order data parameter")
    public void incorrectDataOrder() {
        //GIVEN
        PedidoDTO pedidoTest = new PedidoDTO(1, 1, (short) 1, "2021-06-01 12:00:00", 1);

        //WHEN
        Mockito.when(pedidoRepository.save(pedidoMapper.toModel(pedidoTest))).thenReturn(null);
        PedidoDTO pedido = pedidoService.save(pedidoTest);

        //THEN
        assertNull(pedido);
        assertThrows(IllegalArgumentException.class, () -> pedidoService.save(null));
    }

    @Test
    @Order(3)
    @DisplayName("④ Correct order")
    public void correctOrder() {
        //GIVEN
        PedidoDTO pedidoTest = new PedidoDTO(1, 1, (short) 1, "2021-06-01 12:00:00", 1);
        Pedido pedido = pedidoMapper.toModel(pedidoTest);

        //WHEN
        Mockito.when(pedidoRepository.save(Mockito.any())).thenReturn(pedido);
        Mockito.when(pedidoMapper.toModel(pedidoTest)).thenReturn(pedido);
        Mockito.when(pedidoMapper.toDTO(pedido)).thenReturn(pedidoTest);
        PedidoDTO pedidoResult = pedidoService.save(pedidoTest);

        //THEN
        assertNotNull(pedidoResult);
        assertEquals(pedidoTest, pedidoResult);
    }

    @Test
    @Order(1)
    @DisplayName("③ Check if the price is correct")
    public void checkCorrect() {
        //GIVEN
        PedidoDTO pedidoTest = new PedidoDTO(1, 1, (short) 1, "2021-06-01 12:00:00", 1);
        Pedido pedido = pedidoMapper.toModel(pedidoTest);

        //WHEN
        Mockito.when(pedidoRepository.findById(1)).thenReturn(Optional.ofNullable(pedido));
        Mockito.when(pedidoMapper.toDTO(pedido)).thenReturn(pedidoTest);
        PedidoDTO pedidoResult = pedidoService.findById(1);

        //THEN
        assertNotNull(pedidoResult);
        assertEquals(pedidoTest, pedidoResult);
    }
}
