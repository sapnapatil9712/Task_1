public class SortingRecursion {

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
        if (s.isEmpty()) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
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
    }
}
