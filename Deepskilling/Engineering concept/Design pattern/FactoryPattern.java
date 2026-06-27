class Car {

    void show() {
        System.out.println("Car Created");
    }

}

class Factory {

    Car getCar() {
        return new Car();
    }

}

public class FactoryPattern {

    public static void main(String[] args) {

        Factory f = new Factory();
        Car c = f.getCar();

        c.show();

    }

}
