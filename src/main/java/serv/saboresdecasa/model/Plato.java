package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "plato", schema = "saboresdecasa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"ingredientes", "tipoPlatos"})
@EqualsAndHashCode(exclude = {"ingredientes", "tipoPlatos"})
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(name = "plato_ingrediente",
            joinColumns = @JoinColumn(name = "id_plato"),
            schema = "saboresdecasa",
            inverseJoinColumns = @JoinColumn(name = "id_ingrediente"))
    private Set<Ingrediente> ingredientes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "plato")
    private Set<TipoPlato> tipoPlatos = new LinkedHashSet<>();
}
