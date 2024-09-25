package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pedido", schema = "SaboresDeCasa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa mesa;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_promocion")
    private Promocion promocion;

    @OneToMany(mappedBy = "pedido")
    private Set<BebidaPedido> bebidaPedidos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pedido")
    private Set<PlatoPedido> platoPedidos = new LinkedHashSet<>();
}