import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

// Immutable Person class
final class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}

class CurrencyConverter1 {
    private static final Map<String, BigDecimal> exchangeRates = new HashMap<>();
    
    static {
        exchangeRates.put("USD", BigDecimal.ONE);
        exchangeRates.put("EUR", new BigDecimal("0.85"));
        exchangeRates.put("GBP", new BigDecimal("0.75"));
    }

    @SuppressWarnings("deprecation")
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
        
        Person person = new Person("John", "Doe", LocalDate.of(1990, 5, 15));
        System.out.println("Full Name: " + person.getFullName());
        System.out.println("Age: " + person.getAge());
    }
}
