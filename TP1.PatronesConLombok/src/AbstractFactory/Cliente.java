package AbstractFactory;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Cliente {
    private final InterfazUI interfaz;
    private final MetodoEnvio envio;

    public Cliente(AbstractFactory factory) {
        this.interfaz = factory.crearUI();
        this.envio = factory.crearMetodoEnvio();
    }

    public void usarSistema(String item) {
        interfaz.mostrar();
        envio.enviar(item);
    }

    public static void main(String[] args) {
        Cliente admin = new Cliente(new AdminFactory());
        admin.usarSistema("Libro: 1984");

        Cliente usuario = new Cliente(new UsuarioFactory());
        usuario.usarSistema("Libro: El Principito");
    }
}