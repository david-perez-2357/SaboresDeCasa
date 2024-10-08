package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "plato_pedido", schema = "saboresdecasa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"plato", "pedido"})
@EqualsAndHashCode(exclude = {"plato", "pedido"})
public class PlatoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plato")
    private Plato plato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_plato", nullable = false)
    private TipoPlato tipoPlato;

    @ColumnDefault("1")
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ColumnDefault("false")
    @Column(name = "servido", nullable = false)
    private Boolean servido = false;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;
}