import java.util.LinkedList;
import java.util.ListIterator;

public class CityList {
    public static void main(String[] args) {
        // Creating a LinkedList of city names
        LinkedList<String> cities = new LinkedList<>();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        cities.add("Houston");
        cities.add("Miami");
        cities.add("India");

        // Using ListIterator to traverse forward and print all cities
        System.out.println("Cities in forward order:");
        ListIterator<String> listIterator = cities.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // Using ListIterator to traverse in reverse order
        System.out.println("\nCities in reverse order:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
