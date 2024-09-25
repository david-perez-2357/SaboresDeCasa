package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;
import serv.saboresdecasa.enumerator.TiposPlato;

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
    private Plato plato;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TiposPlato tipo;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @OneToMany(mappedBy = "tipoPlato")
    private Set<PlatoPedido> platoPedidos = new LinkedHashSet<>();

}