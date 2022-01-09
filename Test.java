import java.io.Console;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello friends!");

        Holder holdme = new Holder(5, true);

        holdme.printer();
    }
}

class Holder {
    private int a;
    private boolean c;

    Holder(int a, boolean c) {
        this.a = a;
        this.c = c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public void printer() {
        System.out.println("Hello, I am " + a + " and I am " + c);
    }
}