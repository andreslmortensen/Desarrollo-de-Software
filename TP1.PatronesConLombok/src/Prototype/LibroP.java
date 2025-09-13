package Prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LibroP implements Cloneable {
    private String titulo;
    private String autor;

    @Override
    public LibroP clone() {
        try {
            return (LibroP) super.clone(); // shallow clone suficiente
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Libro", e);
        }
    }
}

