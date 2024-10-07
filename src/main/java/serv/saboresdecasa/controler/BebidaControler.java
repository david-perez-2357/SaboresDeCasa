package serv.saboresdecasa.controler;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serv.saboresdecasa.dto.BebidaDTO;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.service.BebidaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bebida")
public class BebidaControler {
    private BebidaService bebidaService;

    @GetMapping("/all")
    public List<BebidaDTO> getAll() {
        List<Bebida> bebidas = bebidaService.getAll();
        List<BebidaDTO> bebidasDTO = new ArrayList<>();

        for (Bebida bebida : bebidas) {
            BebidaDTO bebidaDTO = new BebidaDTO(bebida);
            bebidasDTO.add(bebidaDTO);
        }

        return bebidasDTO;
    }

    @GetMapping("/one")
    public BebidaDTO getByIdParam(@RequestParam Integer id) {
        Bebida bebida = bebidaService.findById(id);
        return new BebidaDTO(bebida);
    }

    @GetMapping("/one/id/{id}")
    public BebidaDTO getByIdPath(@PathVariable Integer id) {
        Bebida bebida = bebidaService.findById(id);
        return new BebidaDTO(bebida);
    }

    @PostMapping("/save")
    public Bebida save(@RequestBody Bebida bebida) {
        return bebidaService.save(bebida);
    }

    @DeleteMapping("/delete/id/{id}")
    public void delete(@PathVariable Integer id) {
        try {
            bebidaService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
