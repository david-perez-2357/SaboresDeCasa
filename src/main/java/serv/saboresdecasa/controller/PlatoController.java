package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serv.saboresdecasa.dto.PlatoDTO;
import serv.saboresdecasa.dto.PlatoFormattedDTO;
import serv.saboresdecasa.mapper.PlatoFormattedMapper;
import serv.saboresdecasa.mapper.PlatoMapper;
import serv.saboresdecasa.model.Ingrediente;
import serv.saboresdecasa.model.Plato;
import serv.saboresdecasa.model.TipoPlato;
import serv.saboresdecasa.service.IngredienteService;
import serv.saboresdecasa.service.PlatoService;
import serv.saboresdecasa.service.TipoPlatoService;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/plato")
public class PlatoController {
    private PlatoService platoService;
    private IngredienteService ingredienteService;
    private TipoPlatoService tipoPlatoService;
    private PlatoFormattedMapper platoFormattedMapper;

    @GetMapping("/format/{id}")
    public List<PlatoFormattedDTO> getPlatosByTipo(@PathVariable Integer id) {
        return platoFormattedMapper.toDTOList(tipoPlatoService.getByTipo(id));
    }

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
        return platoService.save(PlatoMapper.INSTANCE.toModel(platoDTO));
    }

    @PutMapping
    public PlatoDTO update(@RequestBody PlatoDTO platoDTO) {
        Plato originalPlato = platoService.findPlatoById(platoDTO.getId());
        Plato finalPlato = PlatoMapper.INSTANCE.toModel(platoDTO);
        return platoService.save(finalPlato);
    }

    @PutMapping("/{id}/tipo/{idTipo}")
    public PlatoFormattedDTO updatePlatoPrice(@PathVariable Integer id, @PathVariable Integer idTipo, @RequestParam Double price) {
        TipoPlato tipoPlato = tipoPlatoService.updateTipoPlatoPrice(id, idTipo, price);
        PlatoFormattedDTO platoFormattedDTO = platoFormattedMapper.toDTO(tipoPlato);

        return Objects.requireNonNullElseGet(platoFormattedDTO, PlatoFormattedDTO::new);
    }

    @GetMapping("/{idPlato}/ingredient/")
    public List<Ingrediente> getIngredients(@PathVariable Integer idPlato) {
        return platoService.getIngredientes(idPlato);
    }

    @PostMapping("/{idPlato}/ingredient/{idIngrediente}")
    public PlatoDTO addIngredient(@PathVariable Integer idPlato, @PathVariable Integer idIngrediente) {
        PlatoDTO platoDTO = platoService.addIngredient(idPlato, idIngrediente);
        return Objects.requireNonNullElseGet(platoDTO, PlatoDTO::new);
    }

    @DeleteMapping("/{idPlato}/ingredient/{idIngrediente}")
    public PlatoDTO deleteIngredient(@PathVariable Integer idPlato, @PathVariable Integer idIngrediente) {
        return platoService.deleteIngredient(idPlato, idIngrediente);
    }
}
