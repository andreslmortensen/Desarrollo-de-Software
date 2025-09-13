package AbstractFactory;

public class EnvioExpress implements MetodoEnvio {
    @Override
    public void enviar(String item) {
        System.out.println("Envío EXPRESS del item: " + item + " (llega en 24h)");
    }
}