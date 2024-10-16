package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serv.saboresdecasa.dto.PlatoFormattedDTO;
import serv.saboresdecasa.mapper.PlatoFormattedMapper;
import serv.saboresdecasa.service.TipoPlatoService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/carta")
public class CartaController {
    private PlatoFormattedMapper platoFormattedMapper;
    private TipoPlatoService platoService;

    @GetMapping
    public List<PlatoFormattedDTO> getPlatos() {
        return platoFormattedMapper.toDTOList(platoService.getAll());
    }
}
