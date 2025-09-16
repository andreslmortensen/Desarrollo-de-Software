package Modelado;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder

public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean es_Casa_Matriz;
    private Domicilio domicilio;


    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", horarioApertura=" + horarioApertura +
                ", horarioCierre=" + horarioCierre +
                ", esCasaMatriz=" + es_Casa_Matriz +
                ", domicilio=" + domicilio +
                '}';
    }

}

