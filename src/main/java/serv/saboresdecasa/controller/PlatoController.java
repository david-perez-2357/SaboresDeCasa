package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serv.saboresdecasa.dto.PlatoDTO;
import serv.saboresdecasa.model.Ingrediente;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.service.IngredienteService;
import serv.saboresdecasa.service.PlatoService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plato")
public class PlatoController {
    private PlatoService platoService;
    private IngredienteService ingredienteService;

    @GetMapping
    public List<PlatoDTO> getAll() {
        return platoService.getAll();
    }

    @GetMapping("/{id}")
    public PlatoDTO getById(@PathVariable Integer id) {
        return platoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        platoService.delete(id);
    }

    @PostMapping
    public PlatoDTO save(@RequestBody PlatoDTO platoDTO) {
        return platoService.save(platoDTO.convertToPlato());
    }

    @PutMapping
    public PlatoDTO update(@RequestBody PlatoDTO platoDTO) {
        Plato originalPlato = platoService.findPlatoById(platoDTO.getId());
        Plato finalPlato = platoDTO.convertToPlato(originalPlato);
        return platoService.save(finalPlato);
    }

    @GetMapping("/{idPlato}/ingredient/")
    public List<Ingrediente> getIngredients(@PathVariable Integer idPlato) {
        return platoService.getIngredientes(idPlato);
    }

    @PostMapping("/{idPlato}/ingredient/{idIngrediente}")
    public PlatoDTO addIngredient(@PathVariable Integer idPlato, @PathVariable Integer idIngrediente) {
        return platoService.addIngredient(idPlato, idIngrediente);
    }

    @DeleteMapping("/{idPlato}/ingredient/{idIngrediente}")
    public PlatoDTO deleteIngredient(@PathVariable Integer idPlato, @PathVariable Integer idIngrediente) {
        return platoService.deleteIngredient(idPlato, idIngrediente);
    }
}
