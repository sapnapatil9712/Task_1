import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
    public static void main(String[] args) {
        // Creating an ArrayList of student names
        ArrayList<String> students = new ArrayList<>();
        students.add("Anushka");
        students.add("Asmita");
        students.add("Nikita");
        students.add("Roshni");
        students.add("Sapna");

        // Using Iterator to print all student names
        System.out.println("Student List:");
        Iterator<String> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Removing a student whose name starts with "A"
        iterator = students.iterator(); // Resetting iterator
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.startsWith("A")) {
                iterator.remove();
            }
        }

        // Printing the updated student list
        System.out.println("\nUpdated Student List (after removal):");
        for (String student : students) {
            System.out.println(student);
        }
    }
}
