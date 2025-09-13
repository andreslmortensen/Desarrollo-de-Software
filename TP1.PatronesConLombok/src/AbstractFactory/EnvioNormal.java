package AbstractFactory;

public class EnvioNormal implements MetodoEnvio {
    @Override
    public void enviar(String item) {
        System.out.println("Envío NORMAL del item: " + item + " (3-5 días hábiles)");
    }
}