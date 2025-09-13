package Prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Prestamo implements Cloneable {
    private LibroP libro;
    private UsuarioP usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Override
    public Prestamo clone() {
        try {
            Prestamo clon = (Prestamo) super.clone();
            clon.libro = this.libro.clone();
            clon.usuario = this.usuario.clone();
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Prestamo", e);
        }
    }
}