package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.service.PlatoService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plato")
public class PlatoController {
    private PlatoService platoService;

    @GetMapping("/all")
    public List<Plato> getAll() {
        return platoService.getAll();
    }
}
