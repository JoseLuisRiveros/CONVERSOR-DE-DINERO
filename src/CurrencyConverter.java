import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {
    private ExchangeRateCache rateCache;
    private ConversionHistory history;
    private Config config;

    public CurrencyConverter() {
        this.config = new Config();
        this.rateCache = new ExchangeRateCache(config);
        this.history = new ConversionHistory();
    }
//metodo convert
    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        // Validar monedas
        if (!config.getSupportedCurrencies().contains(fromCurrency)) {
            throw new Exception("Moneda no soportada: " + fromCurrency);
        }
        if (!config.getSupportedCurrencies().contains(toCurrency)) {
            throw new Exception("Moneda no soportada: " + toCurrency);
        }

        // Obtener tasas de cambio
        double fromRate = rateCache.getRate(fromCurrency);
        double toRate = rateCache.getRate(toCurrency);


        BigDecimal amountBD = new BigDecimal(amount);
        BigDecimal fromRateBD = new BigDecimal(fromRate);
        BigDecimal toRateBD = new BigDecimal(toRate);

        BigDecimal result = amountBD.divide(fromRateBD, 10, RoundingMode.HALF_UP)
                .multiply(toRateBD);

        // Solo modifica al final para mostrar el resultado
        result = result.setScale(2, RoundingMode.DOWN);

        history.addConversion(fromCurrency, toCurrency, amount, result.doubleValue(), LocalDateTime.now());

        return result.doubleValue();
    }

    public void showHistory() {
        List<String> conversions = history.getHistory();
        if (conversions.isEmpty()) {
            System.out.println("No hay conversiones registradas");
            return;
        }

        System.out.println("\n=== HISTORIAL ===");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (String conv : conversions) {
            System.out.println(conv);
        }
    }

    public void updateRates() {
        rateCache.clearCache();
    }
}