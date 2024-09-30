package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ingrediente", schema = "saboresdecasa", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "platos")
@EqualsAndHashCode(exclude = "platos")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "ingredientes")
    private Set<Plato> platos = new LinkedHashSet<>();
}