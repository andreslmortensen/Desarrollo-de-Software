package Modelado;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;

    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();
    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", cuil=" + cuit + '\'' +
                ", logo=" + logo +
+                '}';
    }
}



