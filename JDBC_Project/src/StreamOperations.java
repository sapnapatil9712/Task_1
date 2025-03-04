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

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

public class StreamOperations {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 78),
            new Student("Charlie", 90),
            new Student("David", 60),
            new Student("Eve", 95)
        );

        // Task 1: Filter students with marks > 80
        List<Student> topStudents = students.stream()
                .filter(student -> student.getMarks() > 80)
                .collect(Collectors.toList());

        System.out.println("Students with marks above 80:");
        topStudents.forEach(System.out::println);

        // Task 2: Find the sum of all numbers using reduce()
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);  // Integer::sum is equivalent to (a, b) -> a + b

        System.out.println("\nSum of all numbers: " + sum);
    }
}
