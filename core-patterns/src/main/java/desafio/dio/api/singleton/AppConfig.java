package desafio.dio.api.corepatterns.singleton;

/**
 * Singleton clássico (eager initialization).
 * Simples, thread-safe e ideal para demonstrar o padrão em Java puro.
 */
public final class AppConfig {

    private static final AppConfig INSTANCE = new AppConfig();

    private final String apiBasePath = "/api/v1";
    private final String environment = "dev";

    private AppConfig() {}

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getApiBasePath() {
        return apiBasePath;
    }

    public String getEnvironment() {
        return environment;
    }
}
