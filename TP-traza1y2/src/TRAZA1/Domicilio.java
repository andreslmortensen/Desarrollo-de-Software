package TRAZA1;

import lombok.*;
import lombok.experimental.SuperBuilder;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", cp=" + cp +
                ", localidad=" + localidad  +
                '}';
    }
}

