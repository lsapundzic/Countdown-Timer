
public class Another {
    public static void main(String[] args) {
        Animal Zebby = new Animal(1, "Zebby", true);

        System.out.println(Zebby.getName() + " " + Zebby.isAlive());

    }
}

class Animal {
    private int number;
    private String name;
    private boolean alive;

    Animal() {

    }

    Animal(int number, String name, boolean alive) {
        this.number = number;
        this.name = name;
        this.alive = alive;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
