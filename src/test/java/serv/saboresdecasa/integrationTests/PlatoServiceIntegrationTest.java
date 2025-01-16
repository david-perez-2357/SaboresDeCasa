package serv.saboresdecasa.integrationTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import serv.saboresdecasa.repository.PlatoRepository;
import serv.saboresdecasa.service.PlatoService;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("\uD83E\uDD1D Integration Tests PlatoService")
public class PlatoServiceIntegrationTest {
    @InjectMocks
    private PlatoService platoServiceMock;
    @Mock
    private PlatoRepository platoRepository;

    @Test
    @Order(1)
    @DisplayName("① Menu dont return data")
    public void menuIsNotCorrect() {
        //GIVEN
        //WHEN
        Mockito.when(platoRepository.findAll()).thenReturn(null);

        //THEN
        assertNull(platoServiceMock.getAll());
    }
}
