import java.util.*;

public class JavaCol {
    public static void main(String[] args) {
        arrayListAndLinkedListDemo();
        treeSetDemo();
        hashMapStudentDemo();
        wordFrequencyCounter();
        findDuplicatesInArrayList();
        removeDuplicatesUsingHashSet();
    }

    // 1. Add and Retrieve Elements from ArrayList and LinkedList
    public static void arrayListAndLinkedListDemo() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println("ArrayList elements: " + arrayList);

        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("Dog", "Elephant", "Fox"));
        System.out.println("LinkedList elements: " + linkedList);
    }

    // 2. Demonstrate Insertion Order and Sorting in TreeSet
    public static void treeSetDemo() {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 3));
        System.out.println("TreeSet (Sorted Order): " + treeSet);
    }

    // 3. Use HashMap to Store and Retrieve Student Details
    public static void hashMapStudentDemo() {
        HashMap<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        System.out.println("Student Details: " + studentMap);
    }

    // 4. Count Word Frequency in a Given Sentence Using HashMap
    public static void wordFrequencyCounter() {
        String sentence = "Java is powerful and Java is popular";
        String[] words = sentence.split("\\s+");
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies: " + wordCountMap);
    }

    // 5. Find Duplicate Elements in an ArrayList
    public static void findDuplicatesInArrayList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 1, 7, 8, 3);
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer num : numbers) {
            if (!uniqueNumbers.add(num)) {
                duplicates.add(num);
            }
        }

        System.out.println("Duplicate Elements: " + duplicates);
    }

    // 6. Remove Duplicates from a List Using HashSet
    public static void removeDuplicatesUsingHashSet() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 20, 40, 10, 50);
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        System.out.println("List after removing duplicates: " + new ArrayList<>(uniqueNumbers));
    }
}
