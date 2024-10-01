package serv.saboresdecasa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serv.saboresdecasa.model.Cliente;
import serv.saboresdecasa.repository.ClienteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

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
    public Cliente findById(Integer idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
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
