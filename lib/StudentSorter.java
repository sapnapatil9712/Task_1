import java.util.*;

// Student class implementing Comparable for natural ordering by age
class Student implements Comparable<Student> {
    String firstName;
    String lastName;
    int age;
    double height;

    // Constructor
    public Student(String firstName, String lastName, int age, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
    }

    // Natural ordering by age
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    // Overriding toString for readable output
    @Override
    public String toString() {
        return firstName + " " + lastName + " | Age: " + age + " | Height: " + height;
    }
}

// Custom Comparator to sort students by the second character of firstName
class SecondCharComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Extracting the second character (assuming names are at least 2 characters long)
        char c1 = (s1.firstName.length() > 1) ? s1.firstName.charAt(1) : s1.firstName.charAt(0);
        char c2 = (s2.firstName.length() > 1) ? s2.firstName.charAt(1) : s2.firstName.charAt(0);
        return Character.compare(c1, c2);
    }
}

public class StudentSorter {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Brown", 22, 5.6));
        students.add(new Student("Bob", "Smith", 20, 5.9));
        students.add(new Student("Charlie", "Johnson", 21, 6.1));
        students.add(new Student("David", "White", 23, 5.8));
        students.add(new Student("Eve", "Williams", 19, 5.5));
        students.add(new Student("Joy", "berk", 25, 5.3));
        students.add(new Student("Robert", "Hook", 29, 5.2));
        students.add(new Student("Ana", "Brown", 26, 5.1));
        students.add(new Student("Alias", "Einstein", 24, 5.3));
        students.add(new Student("Albert", "Einstein", 18, 5.8));

        // Sorting by natural order (age)
        Collections.sort(students);
        System.out.println("Students sorted by age (natural order):");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sorting by second character of firstName
        Collections.sort(students, new SecondCharComparator());
        System.out.println("\nStudents sorted by second character of firstName:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
