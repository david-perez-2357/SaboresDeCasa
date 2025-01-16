package serv.saboresdecasa.unitTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import serv.saboresdecasa.dto.PlatoDTO;
import serv.saboresdecasa.repository.PlatoRepository;
import serv.saboresdecasa.service.PlatoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@ExtendWith(MockitoExtension.class)
@DisplayName("\uD83E\uDDE9 Unit Tests PlatoService")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlatoServiceUnitTest {
    @InjectMocks
    private PlatoService platoServiceMock;
    @Mock
    private PlatoRepository platoRepository;
    @Autowired
    private PlatoService platoService;

    @Test
    @Order(1)
    @DisplayName("① Menu return data")
    public void menuIsCorrect() {
        //WHEN
        List<PlatoDTO> platos = platoService.getAll();

        //THEN
        assertNotNull(platos);
        assertEquals(2, platos.size());
    }
}
