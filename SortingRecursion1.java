import java.util.*;

public class SortingRecursion1 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void fibonacci(int n, int a, int b) {
        if (n == 0) return;
        System.out.print(a + " ");
        fibonacci(n - 1, b, a + b);
    }

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void priorityHospitalQueue() {
        PriorityQueue<Patient> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));
        pq.add(new Patient("Alice", 2));
        pq.add(new Patient("Bob", 1));
        pq.add(new Patient("Charlie", 3));

        while (!pq.isEmpty()) {
            System.out.println("Attending: " + pq.poll().name);
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        int[] bubbleArr = arr.clone();
        bubbleSort(bubbleArr);
        System.out.println("Bubble Sort:");
        for (int num : bubbleArr) System.out.print(num + " ");
        System.out.println();
        
        int[] selectionArr = arr.clone();
        selectionSort(selectionArr);
        System.out.println("Selection Sort:");
        for (int num : selectionArr) System.out.print(num + " ");
        System.out.println();
        
        System.out.println("Factorial of 5: " + factorial(5));
        
        System.out.println("Fibonacci sequence (10 terms):");
        fibonacci(10, 0, 1);
        System.out.println();
        
        System.out.println("Reverse of 'hello': " + reverseString("hello"));
        
        System.out.println("Priority Hospital Queue:");
        priorityHospitalQueue();
    }
}

class Patient {
    String name;
    int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

