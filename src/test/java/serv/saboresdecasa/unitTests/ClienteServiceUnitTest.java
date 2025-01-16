package serv.saboresdecasa.unitTests;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import serv.saboresdecasa.service.ClienteService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureTestDatabase
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("\uD83E\uDDE9 Unit Tests ClienteService")
public class ClienteServiceUnitTest {
    @Autowired
    private ClienteService clientService;

    @Test
    @Order(1)
    @DisplayName("➄ Client id is not correct")
    public void clientIdIsNotCorrect() {
        //WHEN && THEN
        assertThrows(IllegalArgumentException.class, () -> clientService.findById(null));
    }

    @Test
    @Order(2)
    @DisplayName("➄ Client do not exist")
    public void clientDoNotExist() {
        //WHEN && THEN
        assertThrows(NullPointerException.class, () -> clientService.findById(10));
    }

    @Test
    @Order(3)
    @Transactional
    @DisplayName("➄ Client is not null")
    public void clientIsNotNull() {
        //WHEN && THEN
        assertNotNull(clientService.findById(1));
    }
}
