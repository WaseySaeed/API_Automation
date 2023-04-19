package config;

public class configProperties {

    public static appConfigReader appConfig = new appConfigReader();

    public static String baseUrl = appConfig.getBaseUrl();
    public static String apiKey = appConfig.getApiKey();
    public static String apiHost = appConfig.getApiHost();
}
