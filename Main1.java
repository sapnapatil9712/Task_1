interface Shape {
    double calculateArea();
}

// Abstract class Rectangle implementing Shape
abstract class Rectangle implements Shape {
    protected double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

// Static nested class Circle inside Rectangle
class RectangleWithCircle extends Rectangle {
    public RectangleWithCircle(double width, double height) {
        super(width, height);
    }

    @Override
    public double calculateArea() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    static class Circle implements Shape {
        private double radius;
        
        public Circle(double radius) {
            this.radius = radius;
        }
        
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        // Anonymous class for Rectangle
        Rectangle anonymousRectangle = new Rectangle(10, 5) {
            @Override
            public double calculateArea() {
                return width * height;
            }
        };

        // Instance of the static nested Circle class
        RectangleWithCircle.Circle circle = new RectangleWithCircle.Circle(7);
        
        System.out.println("Rectangle Area: " + anonymousRectangle.calculateArea());
        System.out.println("Circle Area: " + circle.calculateArea());
    }
}
