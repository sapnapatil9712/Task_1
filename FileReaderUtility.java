import java.io.*;

public class FileReaderUtility {
    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    public static int countWordsInFile(String filePath) {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            System.err.println("An error occurred while counting words in the file: " + e.getMessage());
        }
        return wordCount;
    }
    public static class Student implements Serializable {
        private String name;
        private int marks;

        public Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }

        public static void serializeStudent(Student student, String filePath) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
                out.writeObject(student);
            } catch (IOException e) {
                System.err.println("Error serializing student: " + e.getMessage());
            }
        }
        public static Student deserializeStudent(String filePath) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
                return (Student) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error deserializing student: " + e.getMessage());
            }
            return null;
        }
    }
    public static void main(String[] args) {
        String filePath = "example.txt"; 
        System.out.println("Reading file content:");
        readFile(filePath);

        int wordCount = countWordsInFile(filePath);
        System.out.println("Total number of words in file: " + wordCount);
        Student student = new Student("Surabhi Rathore", 776);
        String studentFilePath = "student.ser";

        Student.serializeStudent(student, studentFilePath);
        System.out.println("Student object serialized successfully!");
        Student deserializedStudent = Student.deserializeStudent(studentFilePath);
        if (deserializedStudent != null) {
            System.out.println("Deserialized Student: " + deserializedStudent.getName() + ", Marks: " + deserializedStudent.getMarks());
        }
    }
}