package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mesa", schema = "SaboresDeCasa")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Mesa {
    @Id
    @Column(name = "numero", nullable = false)
    private Short id;

    @ColumnDefault("2")
    @Column(name = "capacidad", nullable = false)
    private Short capacidad;

    @OneToMany(mappedBy = "idMesa")
    private Set<Pedido> pedidos = new LinkedHashSet<>();

}