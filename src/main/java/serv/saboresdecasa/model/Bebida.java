package serv.saboresdecasa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bebida", schema = "saboresdecasa", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ml_de_capacidad", nullable = false)
    private Integer mlDeCapacidad;
}
