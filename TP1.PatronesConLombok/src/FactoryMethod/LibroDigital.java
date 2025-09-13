package FactoryMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class LibroDigital implements Libro {
    private String titulo;
    private String autor;

    @Override
    public void mostrarInfo() {
        System.out.println("Libro Digital: " + titulo + " de " + autor);
    }
}


