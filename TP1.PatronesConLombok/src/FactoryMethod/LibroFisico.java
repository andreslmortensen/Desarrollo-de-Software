package FactoryMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class LibroFisico implements Libro {
    private String titulo;
    private String autor;

    @Override
    public void mostrarInfo() {
        System.out.println("Libro Físico: " + titulo + " de " + autor);
    }
}
