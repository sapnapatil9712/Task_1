import java.io.*;
import java.util.Random;

public class FileOperations {
    public static void main(String[] args) {
        // Task 1
        String filePath = "random_numbers.txt";
        createFileAndWriteRandomNumbers(filePath);

        // Task 2
        int sum = readFileAndCalculateSum(filePath);
        System.out.println("Sum of numbers in the file: " + sum);
        int lineCount = countLinesInFile(filePath);
        System.out.println("Number of lines in the file: " + lineCount);

        // Task 4
        String sourceImagePath = "source_image.jpg"; 
        String destinationImagePath = "copied_image.jpg";
        copyBinaryFile(sourceImagePath, destinationImagePath);
    }
    public static void createFileAndWriteRandomNumbers(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(100);
                writer.write(String.valueOf(randomNumber));
                writer.newLine();
            }
            System.out.println("Random numbers have been written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    // Task 2
    public static int readFileAndCalculateSum(String filePath) {
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sum += Integer.parseInt(line); 
            }
        } catch (IOException e) {
    System.out.println("Error reading from file: " + e.getMessage());
        }
        return sum;
    }

    // Task 3
    public static int countLinesInFile(String filePath) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return lineCount;
    }

    // Task 4
    public static void copyBinaryFile(String sourcePath, String destinationPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied from " + sourcePath + " to " + destinationPath);
        } catch (IOException e) {
            System.out.println("Error copying binary file: " + e.getMessage());
        }
    }
}