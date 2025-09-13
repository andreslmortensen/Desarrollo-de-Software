package Singleton;

public class Database{
private static volatile Database instance;
private String libro;

public Database(String value) {
    this.libro = value;
    System.out.println("Instancia SingletonDCL creada con valor: " + value);
}

public static Database getInstance(String value) {
    if (instance == null) { // Primera comprobación sin bloqueo
        synchronized (Database.class) {
            if (instance == null) { // Segunda comprobación dentro del bloqueo
                instance = new Database(value);
            }
        }
    }
    return instance;
}

public String getLibro() {
    return libro;
}
}

