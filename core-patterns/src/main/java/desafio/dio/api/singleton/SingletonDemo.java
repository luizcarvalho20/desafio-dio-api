package desafio.dio.api.corepatterns.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println("API Base Path: " + config1.getApiBasePath());
        System.out.println("Environment: " + config1.getEnvironment());

        // prova de que é a mesma instância
        System.out.println("Mesma instância? " + (config1 == config2));
    }
}
