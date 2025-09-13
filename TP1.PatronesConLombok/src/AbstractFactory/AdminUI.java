package AbstractFactory;

public class AdminUI implements InterfazUI {
    @Override
    public void mostrar() {
        System.out.println("Interfaz de Administrador con permisos avanzados");
    }
}