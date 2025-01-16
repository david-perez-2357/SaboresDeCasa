package serv.saboresdecasa.integrationTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import serv.saboresdecasa.enumerator.TiposPlato;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.model.TipoPlato;
import serv.saboresdecasa.repository.PlatoRepository;
import serv.saboresdecasa.repository.TipoPlatoRepository;
import serv.saboresdecasa.service.TipoPlatoService;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("\uD83E\uDD1D Integration Tests TipoPlatoService")
public class TipoPlatoIntegrationTest {
    @InjectMocks
    private TipoPlatoService tipoPlatoService;
    @Mock
    private TipoPlatoRepository tipoPlatoRepository;
    @Mock
    private PlatoRepository platoRepository;

    @Test
    @Order(2)
    @DisplayName("➅ Product or format do not exist")
    public void productFormatIdIsNotCorrect() {
        //GIVEN
        Integer id = null;
        Integer tipo = 1;
        Double price = 10.0;

        //WHEN && THEN
        assertThrows(IllegalArgumentException.class, () -> tipoPlatoService.updateTipoPlatoPrice(id, tipo, price));
        Mockito.verify(tipoPlatoRepository, Mockito.times(0)).findByTipo(Mockito.any());
    }

    @Test
    @Order(3)
    @DisplayName("➅ Product or format is correct")
    public void productFormatCorrect() {
        //GIVEN
        Integer id = 1;
        Integer tipo = 1;
        Double price = 10.0;
        TipoPlato tipoPlato = new TipoPlato(1, new Plato(), TiposPlato.PRINCIPAL, BigDecimal.valueOf(10.0), new HashSet<>());
        Plato plato = new Plato(1, "Plato", new HashSet<>(), new HashSet<>(Set.of(tipoPlato)));
        tipoPlato.setPlato(plato);

        //WHEN
        Mockito.when(platoRepository.findById(tipo)).thenReturn(Optional.of(plato));
        Mockito.when(tipoPlatoRepository.save(Mockito.any())).thenReturn(new TipoPlato());
        Mockito.when(tipoPlatoRepository.findByTipo(Mockito.any())).thenReturn(new ArrayList<>(List.of(tipoPlato)));

        //THEN
        assertNotNull(tipoPlatoService.updateTipoPlatoPrice(id, tipo, price));
    }

    @Test
    @Order(1)
    @DisplayName("② Give a null value to the parameter")
    public void formatIsCorrect() {
        //GIVEN
        Integer typeId = 1;

        //WHEN && THEN
        Mockito.when(tipoPlatoRepository.findByTipo(Mockito.any())).thenReturn(new ArrayList<>(List.of(new TipoPlato())));
        tipoPlatoService.getByTipo(typeId);

        assertNotNull(tipoPlatoService.getByTipo(typeId));
    }
}
