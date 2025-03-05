import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Interface with a default method
interface MyInterface {
    // Default method
    default void show() {
        System.out.println("Default method in Interface");
    }
    
    // Abstract method
    void display();
}

// Class that implements the interface and overrides the default method
class MyClass implements MyInterface {
    @Override
    public void display() {
        System.out.println("Overridden display method in MyClass");
    }

    @Override
    public void show() {
        System.out.println("Overridden default method in MyClass");
    }

    // Instance method for method reference example
    public String convertToUpper(String str) {
        return str.toUpperCase();
    }
}

public class MethodReference {
    public static void main(String[] args) {
        // Example 1: Convert Lambda Expression to Method Reference
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        // Using Lambda Expression
        List<String> upperCaseNamesLambda = names.stream()
                .map(name -> name.toUpperCase()) // Lambda expression
                .toList();
        System.out.println("Using Lambda: " + upperCaseNamesLambda);

        // Using Method Reference
        List<String> upperCaseNamesMethodRef = names.stream()
                .map(String::toUpperCase) // Method reference
                .toList();
        System.out.println("Using Method Reference: " + upperCaseNamesMethodRef);

        // Another example using an instance method
        MyClass obj = new MyClass();
        
        // Lambda Expression
        Function<String, String> lambdaFunc = str -> obj.convertToUpper(str);
        System.out.println("Lambda Result: " + lambdaFunc.apply("hello"));

        // Method Reference
        Function<String, String> methodRefFunc = obj::convertToUpper;
        System.out.println("Method Reference Result: " + methodRefFunc.apply("hello"));

        // Example 2: Interface Default Method Override
        MyInterface myObj = new MyClass();
        myObj.display(); // Calls overridden method
        myObj.show(); // Calls overridden default method
    }
}
