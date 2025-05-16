import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeRateCache {
    private Map<String, Double> rates = new HashMap<>();
    private Config config;
    private long lastUpdate;

    public ExchangeRateCache(Config config) {
        this.config = config;
        loadDefaultRates();
    }

    public double getRate(String currency) throws Exception {
        // Si no está en caché o ha expirado, actualizar
        if (!rates.containsKey(currency)) {
            updateRates();
        }

        return rates.get(currency);
    }

    private void updateRates() throws Exception {
        System.out.println("Actualizando tasas desde ExchangeRate-API...");

        // Construye la URL con tu API key
        String urlStr = "https://v6.exchangerate-api.com/v6/" + config.getApiKey() + "/latest/USD";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Verifica si la respuesta es exitosa (código 200)
            if (request.getResponseCode() != 200) {
                throw new Exception("Error en la API: Código " + request.getResponseCode());
            }

            // Parsea la respuesta JSON
            JsonParser jp = new JsonParser();
            JsonObject root = jp.parse(new InputStreamReader((InputStream) request.getContent())).getAsJsonObject();

            // Verifica si la API retornó éxito
            if (!root.get("result").getAsString().equals("success")) {
                throw new Exception("Error en la API: " + root.get("error-type").getAsString());
            }

            // Obtiene el objeto de tasas de conversión
            JsonObject ratesJson = root.getAsJsonObject("conversion_rates");

            // Limpia las tasas existentes
            rates.clear();

            // Agrega todas las tasas recibidas
            for (String currency : ratesJson.keySet()) {
                rates.put(currency, ratesJson.get(currency).getAsDouble());
            }

            // Establece la tasa base (USD)
            rates.put("USD", 1.0);

            System.out.println("Tasas actualizadas correctamente");
            lastUpdate = System.currentTimeMillis();

        } catch (Exception e) {
            System.out.println("Error al actualizar tasas: " + e.getMessage());
            // Si falla, carga las tasas por defecto
            loadDefaultRates();
            throw new Exception("No se pudieron obtener tasas actualizadas. Usando valores por defecto.");
        }
    }

    private void loadDefaultRates() {
        // Tasas de respaldo (actualízacion manual 16/05/2025)
        rates.put("USD", 1.0);       // Dólar estadounidense
        rates.put("EUR", 0.89);      // Euro
        rates.put("GBP", 0.75);      // Libra esterlina
        rates.put("JPY", 145.09);    // Yen japonés
        rates.put("ARS", 1137.95);    // Peso argentino
        rates.put("BOB", 6.91);      // Boliviano boliviano
        rates.put("BRL", 5.68);      // Real brasileño
        rates.put("CLP", 938.97);     // Peso chileno
        rates.put("COP", 4199.19);    // Peso colombiano

        System.out.println("Cargando tasas por defecto");
    }

    public void clearCache() {
        rates.clear();
    }
}