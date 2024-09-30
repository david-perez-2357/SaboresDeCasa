package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "promocion", schema = "saboresdecasa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pedidos")
@EqualsAndHashCode(exclude = "pedidos")
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = Integer.MAX_VALUE)
    private String descripcion;

    @Column(name = "porcentaje_descuento", nullable = false)
    private Short porcentajeDescuento;

    @OneToMany(mappedBy = "promocion")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

}