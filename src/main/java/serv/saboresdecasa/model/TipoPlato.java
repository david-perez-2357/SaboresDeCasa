package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_plato", schema = "SaboresDeCasa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class TipoPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plato")
    private Plato idPlato;

    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @OneToMany(mappedBy = "idTipoPlato")
    private Set<PlatoPedido> platoPedidos = new LinkedHashSet<>();

}