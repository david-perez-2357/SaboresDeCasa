package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.dto.ClienteDTO;
import serv.saboresdecasa.mapper.ClienteMapper;
import serv.saboresdecasa.model.Cliente;
import serv.saboresdecasa.repository.ClienteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    /**
     * Delete a client by id
     * @param idCliente Integer
     */
    public void delete(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    /**
     * Find a client by id
     * @param idCliente Integer
     * @return Cliente
     */
    public Cliente findClienteById(Integer idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    /**
     * Find a client by id
     * @param idCliente Integer
     * @return ClienteDTO
     */
    public ClienteDTO findById(Integer idCliente) {
        if (idCliente == null) {
            throw new IllegalArgumentException("client id is null");
        }

        Cliente cliente = findClienteById(idCliente);

        if (cliente == null) {
            throw new NullPointerException("client not found");
        }

        return clienteMapper.toDTO(cliente);
    }

    /**
     * Save a client, if it already exists, it updates it
     * @param cliente Cliente
     * @return Cliente
     */
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Get all records
     * @return List<Cliente>
     */
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }
}
