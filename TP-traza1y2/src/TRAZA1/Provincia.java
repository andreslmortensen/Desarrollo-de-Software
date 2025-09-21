package TRAZA1;

import lombok.*;
import lombok.experimental.SuperBuilder;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder


public class Provincia {
    private Long id;
    private String nombre;
    private Pais pais;

    @Override
    public String toString() {
        return "Provincia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais=" + pais +
                '}';
    }
}

