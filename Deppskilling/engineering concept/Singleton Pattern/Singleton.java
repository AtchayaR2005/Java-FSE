class Singleton {
    private static Singleton instance;
    private Singleton() {
        System.out.println("Singleton Object Created");
    }
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if(s1 == s2) {
            System.out.println("Only One Object Created");
        }
    }
}