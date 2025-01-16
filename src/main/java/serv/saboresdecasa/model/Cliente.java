package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cliente", schema = "saboresdecasa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pedidos")
@EqualsAndHashCode(exclude = "pedidos")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;
}
