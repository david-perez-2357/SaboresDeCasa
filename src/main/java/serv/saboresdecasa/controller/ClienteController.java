package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serv.saboresdecasa.dto.ClienteDTO;
import serv.saboresdecasa.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }
}
