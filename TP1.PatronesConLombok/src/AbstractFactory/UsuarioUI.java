package AbstractFactory;

public class UsuarioUI implements InterfazUI {
    @Override
    public void mostrar() {
        System.out.println("Interfaz de Usuario con permisos limitados");
    }
}