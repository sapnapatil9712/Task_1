import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String originalPassword = "secret123"; // Actual password
        String encodedPassword = Base64.getEncoder().encodeToString(originalPassword.getBytes()); 
        
        System.out.println("Enter your password:");
        
        int count = 0;
        while (count < 4) {
            String pswrd = sc.nextLine();
            String decodedPassword = new String(Base64.getDecoder().decode(encodedPassword)); 
            
            if (pswrd.equals(decodedPassword)) {
                System.out.println("Access Granted");
                break;
            } else {
                count++;
                if (count == 3) {
                    System.out.println("You are blocked for 24 hrs: Try after some time");
                    break;
                } else {
                    System.out.println("Oops, wrong password. Try again:");
                }
            }
        }
        sc.close();
    }
}