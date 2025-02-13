import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class CurrencyConverter {
    private static final Map<String, BigDecimal> exchangeRates = new HashMap<>();
    
    static {
        exchangeRates.put("USD", BigDecimal.ONE);
        exchangeRates.put("EUR", new BigDecimal("0.85"));
        exchangeRates.put("GBP", new BigDecimal("0.75"));
    }

    public static BigDecimal convert(BigDecimal amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }
        BigDecimal rateFrom = exchangeRates.get(fromCurrency);
        BigDecimal rateTo = exchangeRates.get(toCurrency);
        return amount.multiply(rateTo).divide(rateFrom, 4, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("100");
        System.out.println("100 USD to EUR: " + convert(amount, "USD", "EUR"));
        System.out.println("100 EUR to GBP: " + convert(amount, "EUR", "GBP"));
    }
}
