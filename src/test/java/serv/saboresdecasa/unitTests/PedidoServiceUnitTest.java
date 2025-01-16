package serv.saboresdecasa.unitTests;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import serv.saboresdecasa.dto.PedidoDTO;
import serv.saboresdecasa.mapper.PedidoMapper;
import serv.saboresdecasa.service.PedidoService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("\uD83E\uDDE9 Unit Tests PedidoService")
public class PedidoServiceUnitTest {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private PedidoMapper pedidoMapper;

    @Test
    @Order(1)
    @DisplayName("③ Incorrect data order")
    public void productIdIsNotCorrect() {
        //WHEN && THEN
        assertThrows(IllegalArgumentException.class, () -> pedidoService.getTotalPrice(null));
    }

    @Test
    @Order(2)
    @DisplayName("③ Product do not exist")
    public void productDoNotExist() {
        //WHEN && THEN
        assertThrows(NullPointerException.class, () -> pedidoService.getTotalPrice(10));
    }

    @Test
    @Order(3)
    @DisplayName("③ Check if the price is correct")
    @Transactional
    public void checkCorrect() {
        //WHEN
        Double price = pedidoService.getTotalPrice(1);

        //THEN
        assertNotNull(price);
    }

    @Test
    @Order(4)
    @DisplayName("④ Incorrect order data parameter")
    public void incorrectDataOrder() {
        //WHEN && THEN
        assertThrows(IllegalArgumentException.class, () -> pedidoService.save(null));
    }

    @Test
    @Order(5)
    @DisplayName("④ Correct order")
    public void correctOrder() {
        //GIVEN
        PedidoDTO pedidoTest = new PedidoDTO(1, 1, (short) 1, "2021-06-01 12:00:00", 1);

        //WHEN
        PedidoDTO pedidoResult = pedidoService.save(pedidoTest);

        //THEN
        assertNotNull(pedidoResult);
        assertEquals(pedidoTest, pedidoResult);
    }
}
