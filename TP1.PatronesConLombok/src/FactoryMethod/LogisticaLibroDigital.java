package FactoryMethod;

public class LogisticaLibroDigital extends LogisticaLibro {
    @Override
    public Libro crearLibro(String titulo, String autor) {
        return new LibroDigital(titulo, autor);
    }
}
