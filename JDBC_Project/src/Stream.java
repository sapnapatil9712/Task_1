import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

public class Stream {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 78),
            new Student("Charlie", 90),
            new Student("David", 60),
            new Student("Eve", 98),
            new Student("Robert", 92),
            new Student("John", 86)
        );

        // Task 1: Filter students with marks > 80
        List<Student> topStudents = students.stream()
                .filter(student -> student.getMarks() > 80)
                .collect(Collectors.toList());

        System.out.println("Students with marks above 80:");
        topStudents.forEach(System.out::println);

        // List of names
        List<String> names = Arrays.asList("john", "mike", "sarah", "emma");

        // Task 2: Convert names to uppercase using map()
        List<String> uppercasedNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("\nNames in uppercase:");
        uppercasedNames.forEach(System.out::println);
    }
}
