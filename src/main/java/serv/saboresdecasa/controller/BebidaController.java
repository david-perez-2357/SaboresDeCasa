package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.service.BebidaService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bebida")
public class BebidaController {
    private BebidaService bebidaService;

    @GetMapping("/all")
    public List<Bebida> getAll() {
        return bebidaService.getAll();
    }

    @GetMapping("/id/{id}")
    public Bebida getByIdPath(@PathVariable Integer id) {
        return bebidaService.findById(id);
    }

    @PostMapping("/add")
    public Bebida add(@RequestBody Bebida bebida) {
        return bebidaService.save(bebida);
    }

    @PutMapping("/update")
    public Bebida update(@RequestBody Bebida bebida) {
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
