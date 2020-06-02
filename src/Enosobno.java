import java.util.*;
import java.util.Scanner;


public class Enosobno extends Stanovanje {

    private boolean basement;
    private boolean balcony;

    public Enosobno() {

    }

    public Enosobno(boolean basement, boolean balcony) {
        this.basement = basement;
        this.balcony = balcony;
    }

    public Enosobno(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, int bed, int floor, boolean basement, boolean balcony) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, bed, floor);
        this.basement = basement;
        this.balcony = balcony;
    }

    public boolean isBasement() {
        return basement;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public static Enosobno vnesiEnosobno() {
        Scanner input = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi enosobno!\r\n" +
                "Vnesite lastnika nepremicnine: ");

        String lastnik = input.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = input.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = input.next();

        System.out.println("Vnesite ceno nepremicnine (v €): ");
        int cena = input.nextInt();

        System.out.println("Vnesite stevilo spalnic: ");
        int bed = input.nextInt();

        System.out.println("Vnesite stevilo nadstropja: ");
        int floor = input.nextInt();

        System.out.println("Ali ima klet?: ");
        boolean basement = input.nextBoolean();

        System.out.println("Ali ima balkon?: ");
        boolean balcony = input.nextBoolean();

        Enosobno novaEnosobno = new Enosobno(lastnik, velikostNepremicnin, cena, prodajaORoddaja, bed, floor, basement, balcony);

        return novaEnosobno;
    }

    @Override
    public String toString() {
        String zapis = "Lastnik: " + this.getLastnik() + "\n" +
                "Velikost nepremicnine (cm2): " + this.getvelikostNepremicnin() + "\n" +
                "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\n" +
                "Cena(v €): " + this.getCena() + "\n" +
                "Stevilo spalnic: " + this.getBed() + "\n" +
                "Stevilo nadstropja: " + this.getFloor() + "\n" +
                "Klet: " + this.isBasement() + "\n" +
                "Balkon: " + this.isBalcony() + "\n";

        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n" +
                this.getLastnik() + "\r\n" +
                this.getvelikostNepremicnin() + "\r\n" +
                this.getprodajaORoddaja() + "\r\n" +
                this.getCena() + "\r\n" +
                this.getBed() + "\r\n" +
                this.getFloor() + "\r\n" +
                this.isBasement() + "\r\n" +
                this.isBalcony() + "\r\n" +
                "#\r\n";

        return zapis;

    }

    public static Enosobno preberiIzNiza(ArrayList<String> zapis) {
        Enosobno novaEnosobno = new Enosobno();

        novaEnosobno.setLastnik(zapis.get(0));
        novaEnosobno.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaEnosobno.setprodajaORoddaja(zapis.get(2));
        novaEnosobno.setCena(Integer.parseInt(zapis.get(3)));
        novaEnosobno.setBed(Integer.parseInt(zapis.get(4)));
        novaEnosobno.setFloor(Integer.parseInt(zapis.get(5)));
        novaEnosobno.setBasement(zapis.get(6).equals("true") ? true : false);
        novaEnosobno.setBalcony(zapis.get(7).equals("true") ? true : false);

        return novaEnosobno;
    }
}