import java.io.*;

public class ExceptionHandlingDemo {

    // Method demonstrating division by zero handling
    public static void divideNumbers(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }

    // Method demonstrating use of throws for file reading
    public static void readFile(String filename) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            System.out.println("File content: " + reader.readLine());
        } finally {
            if (reader != null) {
                reader.close();
                System.out.println("File closed successfully.");
            }
        }
    }

    public static void main(String[] args) {
        // Handling division by zero
        divideNumbers(10, 0);

        // Handling custom exception
        try {
            AgeValidator.validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Handling file reading with throws
        try {
            readFile("test.txt");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidator {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative!");
        } else {
            System.out.println("Valid age: " + age);
        }
    }
}
