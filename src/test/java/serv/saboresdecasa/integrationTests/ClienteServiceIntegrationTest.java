package serv.saboresdecasa.integrationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import serv.saboresdecasa.dto.ClienteDTO;
import serv.saboresdecasa.mapper.ClienteMapper;
import serv.saboresdecasa.model.Cliente;
import serv.saboresdecasa.repository.ClienteRepository;
import serv.saboresdecasa.service.ClienteService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("\uD83E\uDD1D Integration Tests ClienteService")
public class ClienteServiceIntegrationTest {
    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private ClienteMapper clienteMapper;

    @Test
    @Transactional
    @DisplayName("➄ Client order is correct")
    public void clientOrderCorrect() {
        //GIVEN
        Cliente cliente = new Cliente();
        cliente.setId(1);
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(1);

        //WHEN
        Mockito.when(clienteRepository.findById(Mockito.any())).thenReturn(java.util.Optional.of(cliente));
        Mockito.when(clienteMapper.toDTO(cliente)).thenReturn(clienteDTO);

        //THEN
        assertEquals(cliente.getId(), clienteService.findById(1).getId());
    }
}
