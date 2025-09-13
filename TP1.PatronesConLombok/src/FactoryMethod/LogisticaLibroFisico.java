package FactoryMethod;

public class LogisticaLibroFisico extends LogisticaLibro {
    @Override
    public Libro crearLibro(String titulo, String autor) {
        return new LibroFisico(titulo, autor);
    }
}
