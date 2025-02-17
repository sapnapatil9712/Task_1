import java.util.Enumeration;
import java.util.Vector;

public class CountryList {
    public static void main(String[] args) {
        // Creating a Vector of country names
        Vector<String> countries = new Vector<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Germany");
        countries.add("France");
        countries.add("Japan");

        // Using Enumeration to print all country names
        System.out.println("List of Countries:");
        Enumeration<String> enumeration = countries.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
