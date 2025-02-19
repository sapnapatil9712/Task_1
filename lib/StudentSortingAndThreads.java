import java.util.*;

// Student class implementing Comparable for natural ordering by name
class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int rollNumber;

    public Student(String name, int age, int rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getRollNumber() { return rollNumber; }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", rollNumber=" + rollNumber + "}";
    }
}

// Comparator to sort students by Age
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}

// Comparator to sort students by Roll Number
class RollNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollNumber(), s2.getRollNumber());
    }
}

// Class for even and odd number printing using threads
class EvenOddPrinter {
    private int max;
    private int number = 1;

    public EvenOddPrinter(int max) {
        this.max = max;
    }

    public synchronized void printEven() {
        while (number <= max) {
            if (number % 2 == 0) {
                System.out.println("Even: " + number);
                number++;
                notify();
            } else {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public synchronized void printOdd() {
        while (number <= max) {
            if (number % 2 != 0) {
                System.out.println("Odd: " + number);
                number++;
                notify();
            } else {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}

// Main class
public class StudentSortingAndThreads {
    public static void main(String[] args) {
        // 1. Sorting Students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, 3));
        students.add(new Student("Bob", 20, 1));
        students.add(new Student("Charlie", 21, 2));

        // Sorting by name (natural ordering)
        Collections.sort(students);
        System.out.println("Sorted by Name: " + students);

        // Sorting by Age
        Collections.sort(students, new AgeComparator());
        System.out.println("Sorted by Age: " + students);

        // Sorting by Roll Number
        Collections.sort(students, new RollNumberComparator());
        System.out.println("Sorted by Roll Number: " + students);

        // 2. Even-Odd Number Printing using Threads
        EvenOddPrinter printer = new EvenOddPrinter(10);

        Thread evenThread = new Thread(() -> printer.printEven());
        Thread oddThread = new Thread(() -> printer.printOdd());

        evenThread.start();
        oddThread.start();
    }
}
