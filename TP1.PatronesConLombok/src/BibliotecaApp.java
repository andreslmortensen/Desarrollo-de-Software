import Builder.Usuario;
import FactoryMethod.*;
import Prototype.*;
import Singleton.Database;
import AbstractFactory.*;

import java.time.LocalDate;


public class BibliotecaApp {
    public static void main(String[] args) {
        System.out.println("=== Singleton ===");
        Runnable task1 = () -> {
            Database singleton = Database.getInstance("Pinocho");
            System.out.println(Thread.currentThread().getName() + " obtuvo valor: " + singleton.getLibro());
        };

        Runnable task2 = () -> {
            Database singleton = Database.getInstance("Los 3 mosqueteros");
            System.out.println(Thread.currentThread().getName() + " obtuvo valor: " + singleton.getLibro());
        };

        Thread t1 = new Thread(task1, "Hilo 1");
        Thread t2 = new Thread(task2, "Hilo 2");
        t1.start();
        t2.start();

        // Esperamos a que terminen
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n----Factory Method-----");

        LogisticaLibro logistica = new LogisticaLibroDigital();
        Libro novela = logistica.crearLibro("DON QUIJOTE","PEPE");
        System.out.println(novela);
        LogisticaLibro logistica1 = new LogisticaLibroFisico();
        Libro novela1 = logistica1.crearLibro("INVENTOR DE JUEGOS","FEDE");
        System.out.println(novela1);

        System.out.println("\n----Abstrac Factory-----");

        Cliente admin = new Cliente(new AdminFactory());
        admin.usarSistema("Libro: 1984");

        Cliente usuario = new Cliente(new UsuarioFactory());
        usuario.usarSistema("Libro: El Principito");

        System.out.println("\n----Builder-----");

        Usuario u1 = Usuario.builder()
                .nombre("Carlos")
                .email("c@mail.com")
                .direccion("Calle 123")
                .build();

        Usuario u2 = Usuario.builder()
                .nombre("Ana")
                .email("a@mail.com")
                .telefono("555-123")
                .fechaNacimiento("1995-05-10")
                .build();

        System.out.println(u1);
        System.out.println(u2);

        System.out.println("\n----Prototype-----");
        // Crear prototipo de préstamo
        LibroP libro = new LibroP("El Quijote", "Cervantes");
        UsuarioP usuario1 = new UsuarioP("Ana", "ana@mail.com");
        Prestamo prestamoOriginal = new Prestamo(libro, usuario1, LocalDate.now(), LocalDate.now().plusDays(15));

        System.out.println("=== Préstamo Original ===");
        System.out.println(prestamoOriginal);

        // Clonar 1
        Prestamo clon1 = prestamoOriginal.clone();
        clon1.getUsuario().setNombre("Carlos");
        clon1.getLibro().setTitulo("La Odisea");

        // Clonar 2
        Prestamo clon2 = prestamoOriginal.clone();
        clon2.getUsuario().setNombre("María");
        clon2.getLibro().setTitulo("Hamlet");

        System.out.println("\n=== Clon 1 ===");
        System.out.println(clon1);

        System.out.println("\n=== Clon 2 ===");
        System.out.println(clon2);

        System.out.println("\n=== Préstamo Original (se mantiene intacto) ===");
        System.out.println(prestamoOriginal);
    }
}

