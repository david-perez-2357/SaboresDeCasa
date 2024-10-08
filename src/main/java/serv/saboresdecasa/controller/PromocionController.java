package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serv.saboresdecasa.model.Promocion;
import serv.saboresdecasa.service.PromocionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/promotion")
public class PromocionController {
    private PromocionService promocionService;

    @GetMapping
    public List<Promocion> getAll() {
        return promocionService.getAll();
    }

    @GetMapping("/id/{id}")
    public Promocion getById(@PathVariable Integer id) {
        return promocionService.findById(id);
    }

    @PostMapping("/add")
    public Promocion add(@RequestBody Promocion promocion) {
        return promocionService.save(promocion);
    }

    @PutMapping("/edit")
    public Promocion save(@RequestBody Promocion promocion) {
        return promocionService.save(promocion);
    }
}
