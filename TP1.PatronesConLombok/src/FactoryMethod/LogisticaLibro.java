package FactoryMethod;

public abstract class LogisticaLibro {
    public abstract Libro crearLibro(String titulo, String autor);

    public void entregarLibro(String titulo, String autor) {
        Libro libro = crearLibro(titulo, autor);
        libro.mostrarInfo();
    }
}

