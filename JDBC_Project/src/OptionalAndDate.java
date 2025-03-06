import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

class Person {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class OptionalAndDate{
    // Method that returns an Optional to avoid NullPointerException
    public static Optional<Person> getPerson(boolean isPresent) {
        return isPresent ? Optional.of(new Person("John Doe")) : Optional.empty();
    }

    // Method to get and format the current date
    public static String getFormattedCurrentDate() {
        LocalDate currentDate = LocalDate.now(); // Get current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // Define format
        return currentDate.format(formatter); // Format the date
    }

    public static void main(String[] args) {
        // 1. Handling Optional to avoid NullPointerException
        Optional<Person> person = getPerson(true);
        System.out.println("Person Name: " + person.map(Person::getName).orElse("No Person Available"));

        Optional<Person> emptyPerson = getPerson(false);
        System.out.println("Person Name: " + emptyPerson.map(Person::getName).orElse("No Person Available"));

        // 2. Get and format the current date
        System.out.println("Current Date: " + getFormattedCurrentDate());
    }

    @Override
    public String toString() {
        return "OptionalAndDate []";
    }
}
