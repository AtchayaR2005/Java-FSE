class Car {

    String make;
    String model;
    int year;

    void displayDetails() {
        System.out.println(make+" "+model+" "+year);
    }
}

public class ClassObjectDemo {
    public static void main(String[] args) {

        Car c = new Car();

        c.make = "Toyota";
        c.model = "Camry";
        c.year = 2024;

        c.displayDetails();
    }
}
