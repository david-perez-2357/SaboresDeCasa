package serv.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import serv.saboresdecasa.model.Bebida;

import java.util.List;

@Data
@AllArgsConstructor
public class BebidaDTO {
    private Integer id;
    private String nombre;
    private Integer MlDeCapacidad;

    public BebidaDTO(Bebida bebida) {
        this.id = bebida.getId();
        this.nombre = bebida.getNombre();
        this.MlDeCapacidad = bebida.getMlDeCapacidad();
    }
}
