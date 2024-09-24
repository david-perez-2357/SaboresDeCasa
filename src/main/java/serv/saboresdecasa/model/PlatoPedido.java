package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "plato_pedido", schema = "SaboresDeCasa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class PlatoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plato")
    private Plato idPlato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido idPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_plato", nullable = false)
    private TipoPlato idTipoPlato;

    @ColumnDefault("1")
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ColumnDefault("false")
    @Column(name = "servido", nullable = false)
    private Boolean servido = false;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

}