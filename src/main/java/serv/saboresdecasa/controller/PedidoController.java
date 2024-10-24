package serv.saboresdecasa.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serv.saboresdecasa.dto.PedidoDTO;
import serv.saboresdecasa.dto.PedidoTotalPriceDTO;
import serv.saboresdecasa.dto.PlatoPedidoDTO;
import serv.saboresdecasa.model.Bebida;
import serv.saboresdecasa.service.PedidoService;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> getAll() {
        return pedidoService.getAll();
    }

    @GetMapping("/{id}")
    public PedidoDTO getById(@PathVariable Integer id) {
        return pedidoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pedidoService.delete(id);
    }

    @PostMapping
    public PedidoDTO save(@RequestBody PedidoDTO pedido) {
        return pedidoService.save(pedido);
    }

    @GetMapping("/{id}/plato")
    public List<PlatoPedidoDTO> getPlatos(@PathVariable Integer id) {
        return pedidoService.getPlatos(id);
    }

    @GetMapping("/{id}/bebida")
    public List<Bebida> getBebidas(@PathVariable Integer id) {
        return pedidoService.getBebidas(id);
    }

    @PostMapping("/{id}/plato")
    public PlatoPedidoDTO addPlato(@PathVariable Integer id, @RequestBody PlatoPedidoDTO plato) {
        plato.setIdPedido(id);
        PlatoPedidoDTO platoPedidoDTO = pedidoService.addPlato(id, plato);
        return Objects.requireNonNullElseGet(platoPedidoDTO, PlatoPedidoDTO::new);
    }

    @GetMapping("/{id}/price")
    public PedidoTotalPriceDTO getPrice(@PathVariable Integer id) {
        PedidoDTO pedidoDTO = pedidoService.findById(id);

        if (pedidoDTO == null) {
            return new PedidoTotalPriceDTO();
        }

        PedidoTotalPriceDTO pedidoTotalPriceDTO = new PedidoTotalPriceDTO(pedidoDTO);
        pedidoTotalPriceDTO.setTotalPrice(pedidoService.getTotalPrice(id));
        return pedidoTotalPriceDTO;
    }
}
