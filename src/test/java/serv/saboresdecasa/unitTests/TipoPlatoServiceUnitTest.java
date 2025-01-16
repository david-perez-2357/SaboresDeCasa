package serv.saboresdecasa.unitTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import serv.saboresdecasa.model.TipoPlato;
import serv.saboresdecasa.service.TipoPlatoService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@DisplayName("\uD83E\uDDE9 Unit Tests TipoPlatoService")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TipoPlatoServiceUnitTest {
    @Autowired
    private TipoPlatoService tipoPlatoService;

    @Test
    @Order(3)
    @DisplayName("➅ Product format id is not correct")
    public void productFormatIdIsNotCorrect() {
        //WHEN && THEN
        assertThrows(IllegalArgumentException.class, () -> tipoPlatoService.updateTipoPlatoPrice(null, null, null));
    }

    @Test
    @Order(4)
    @DisplayName("➅ Product or format do not exist")
    public void productOrFormatNotExist() {
        //THEN
        assertThrows(NullPointerException.class, () -> tipoPlatoService.updateTipoPlatoPrice(10, 10, 10.0));
    }

    @Test
    @Order(5)
    @Transactional
    @DisplayName("➅ Product format correct")
    public void productFormatCorrect() {
        //THEN
        assertNotNull(tipoPlatoService.updateTipoPlatoPrice(1, 0, 10.0));
    }

    @Test
    @Order(1)
    @DisplayName("② Give a null value to the parameter")
    public void formatIdIsNotCorrect() {
        //GIVEN
        Integer typeId = null;

        //WHEN && THEN
        assertThrows(IllegalArgumentException.class, () -> tipoPlatoService.getByTipo(typeId));
    }

    @Test
    @Order(2)
    @DisplayName("② Get all dishes by type id")
    public void formatIsCorrect() {
        //GIVEN
        Integer typeId = 1;

        //WHEN && THEN
        List<TipoPlato> tipoPlatos = tipoPlatoService.getByTipo(typeId);

        assertNotNull(tipoPlatos);
    }
}
