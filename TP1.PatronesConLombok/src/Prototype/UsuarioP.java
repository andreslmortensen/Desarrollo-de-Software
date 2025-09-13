package Prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UsuarioP implements Cloneable {
    private String nombre;
    private String email;

    @Override
    public UsuarioP clone() {
        try {
            return (UsuarioP) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar Usuario", e);
        }
    }
}