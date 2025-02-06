public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Red", 0);
        Car car2 = new Car("Honda", "Blue", 0);
        car1.start();
        car1.accelerate();
        car1.accelerate();
        car1.stop();

        System.out.println();

        car2.start();
        car2.accelerate();
        car2.stop();
    }

    @Override
    public String toString() {
        return "Main []";
    }
}

class Car {
    String brand;
    String color;
    int speed;
    public Car(String brand, String color, int speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
    }
    public void start() {
        System.out.println(brand + " car is starting.");
    }
    public void stop() {
        System.out.println(brand + " car is stopping.");
    }
    public void accelerate() {
        speed += 10;
        System.out.println(brand + " car is accelerating. Current speed: " + speed + " km/h.");
    }
}