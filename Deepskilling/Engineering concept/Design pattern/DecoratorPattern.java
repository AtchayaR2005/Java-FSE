class Coffee {

    void make() {
        System.out.println("Coffee");
    }

}

class MilkCoffee extends Coffee {

    void make() {

        System.out.println("Coffee with Milk");

    }

}

public class DecoratorPattern {

    public static void main(String[] args) {

        Coffee c = new MilkCoffee();

        c.make();

    }

}
