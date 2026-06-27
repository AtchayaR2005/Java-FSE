

class Singleton {

    private static Singleton obj = new Singleton();

    private Singleton() {
    }

    static Singleton getInstance() {
        return obj;
    }

    void display() {
        System.out.println("Singleton Pattern");
    }
}

public class SingletonPattern {

    public static void main(String[] args) {

        Singleton s = Singleton.getInstance();
        s.display();

    }

}
