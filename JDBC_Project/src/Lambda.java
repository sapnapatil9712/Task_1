import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Lambda{
    public static void main(String[] args) {
        // Task 1: Filter numbers greater than 10
        List<Integer> numbers = Arrays.asList(5, 12, 8, 15, 3, 20);
        Predicate<Integer> isLessThanOrEqualTo10 = num -> num <= 10;
        List<Integer> filteredNumbers = numbers.stream().filter(isLessThanOrEqualTo10).collect(Collectors.toList());
        System.out.println("Numbers ≤ 10: " + filteredNumbers);

        // Task 2: Convert strings to uppercase using Function
        List<String> words = Arrays.asList("hello", "world", "java", "lambda");
        Function<String, String> toUpperCase = String::toUpperCase;
        List<String> uppercasedWords = words.stream().map(toUpperCase).collect(Collectors.toList());
        System.out.println("Uppercased Words: " + uppercasedWords);

        // Task 3: Print strings in uppercase using Consumer
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        words.forEach(printUpperCase);

        // Task 4: Sort Person objects based on the second character of their names
        List<Person> people = Arrays.asList(new Person("Alice"), new Person("Bob"), new Person("Charlie"));
        var bySecondChar = Comparator.comparing(person -> ((Person) person).getName().charAt(1));
        people.sort(bySecondChar);

        System.out.println("Sorted by second character:");
        people.forEach(person -> System.out.println(person.getName()));
    }
}
