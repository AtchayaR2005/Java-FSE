class OldPrinter {

    void printOld() {
        System.out.println("Old Printer");
    }

}

class Adapter {

    OldPrinter p = new OldPrinter();

    void print() {
        p.printOld();
    }

}

public class AdapterPattern {

    public static void main(String[] args) {

        Adapter a = new Adapter();

        a.print();

    }

}
