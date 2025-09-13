package Builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Usuario {
    private final String nombre;
    private final String email;
    private final String direccion;
    private final String telefono;
    private final String fechaNacimiento;
}
