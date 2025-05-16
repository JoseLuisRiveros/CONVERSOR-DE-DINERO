import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class Config {
    private Properties props;

    public Config() {
        props = new Properties();
        try {
            // Cargar configuración desde archivo
            props.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            // Valores por defecto si no existe el archivo
            System.out.println("Usando configuración por defecto");
            props.setProperty("api.url", "https://v6.exchangerate-api.com/v6/");
            props.setProperty("api.key", "7e4258a780b3811633a81a50");
            props.setProperty("currencies", "USD,EUR,GBP,JPY,ARS");
            props.setProperty("cache.minutes", "60");
        }
    }

    public String getApiUrl() {
        return props.getProperty("api.url");
    }

    public String getApiKey() {
        return props.getProperty("api.key");
    }

    public List<String> getSupportedCurrencies() {
        return Arrays.asList(props.getProperty("currencies").split(","));
    }

    public int getCacheTimeout() {
        return Integer.parseInt(props.getProperty("cache.minutes"));
    }
}