import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

// Immutable Person class
final class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}

class CurrencyConverter {
    private static final Map<String, BigDecimal> exchangeRates = new HashMap<>();
    
    static {
        exchangeRates.put("USD", BigDecimal.ONE);
        exchangeRates.put("EUR", new BigDecimal("0.85"));
        exchangeRates.put("GBP", new BigDecimal("0.75"));
    }

    @SuppressWarnings("deprecation")
    public static BigDecimal convert(BigDecimal amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }
        BigDecimal rateFrom = exchangeRates.get(fromCurrency);
        BigDecimal rateTo = exchangeRates.get(toCurrency);
        return amount.multiply(rateTo).divide(rateFrom, 4, BigDecimal.ROUND_HALF_UP);
    }
}

class MathUtils {
    public static double calculateAverage(double... values) {
        if (values.length == 0) return 0;
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class LeetCodeSolutions {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != map.get(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        int original = x;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return original == reversed;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;
        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("100");
        System.out.println("100 USD to EUR: " + CurrencyConverter.convert(amount, "USD", "EUR"));
        System.out.println("100 EUR to GBP: " + CurrencyConverter.convert(amount, "EUR", "GBP"));
        
        Person person = new Person("John", "Doe", LocalDate.of(1990, 5, 15));
        System.out.println("Full Name: " + person.getFullName());
        System.out.println("Age: " + person.getAge());
        
        System.out.println("Average: " + MathUtils.calculateAverage(10.5, 20.3, 30.7));
        
        int[] nums = {2, 7, 11, 15};
        System.out.println("Two Sum: " + Arrays.toString(LeetCodeSolutions.twoSum(nums, 9)));
        
        System.out.println("Valid Parentheses: " + LeetCodeSolutions.isValid("(){}[]"));
        
        System.out.println("Palindrome Number: " + LeetCodeSolutions.isPalindrome(121));
    }
}
