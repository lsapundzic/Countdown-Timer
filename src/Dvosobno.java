import java.util.*;
import java.util.Scanner;


public class Dvosobno extends Stanovanje {

    private boolean basement;
    private boolean balcony;

    public Dvosobno() {
        this.basement = false;
        this.balcony = false;
    }

    public Dvosobno(boolean basement, boolean balcony) {
        this.basement = basement;
        this.balcony = balcony;
    }

    public Dvosobno(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, int bed, int floor, boolean basement, boolean balcony) {
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

    public static Dvosobno vnesiDvosobno() {
        Scanner input = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi dvosobno!\r\n" +
                "Vnesite lastnika nepremicnine: ");

        String lastnik = input.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = input.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = input.nextLine();

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

        Dvosobno novaDvosobno = new Dvosobno(lastnik, velikostNepremicnin, cena, prodajaORoddaja, bed, floor, basement, balcony);

        return novaDvosobno;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\r\n";
        zapis += "Velikost nepremicnine (cm2): " + this.getvelikostNepremicnin() + "\r\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\r\n";
        zapis += "Cena(v €): " + this.getCena() + "\r\n";
        zapis += "Stevilo spalnic: " + this.getBed() + "\r\n";
        zapis += "Stevilo nadstropja: " + this.getFloor() + "\r\n";
        zapis += "Klet: " + this.isBasement() + "\r\n";
        zapis += "Balkon: " + this.isBalcony() + "\r\n";

        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "\r\n";
        zapis += this.getvelikostNepremicnin() + "\r\n";
        zapis += this.getprodajaORoddaja() + "\r\n";
        zapis += this.getCena() + "\r\n";
        zapis += this.getBed() + "\r\n";
        zapis += this.getFloor() + "\r\n";
        zapis += this.isBasement() + "\r\n";
        zapis += this.isBalcony() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Dvosobno preberiIzNiza(ArrayList<String> zapis) {
        Dvosobno novaDvosobno = new Dvosobno();

        novaDvosobno.setLastnik(zapis.get(0));
        novaDvosobno.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaDvosobno.setprodajaORoddaja(zapis.get(2));
        novaDvosobno.setCena(Integer.parseInt(zapis.get(3)));
        novaDvosobno.setBed(Integer.parseInt(zapis.get(4)));
        novaDvosobno.setFloor(Integer.parseInt(zapis.get(5)));
        novaDvosobno.setBasement(zapis.get(6).equals("true") ? true : false);
        novaDvosobno.setBalcony(zapis.get(7).equals("true") ? true : false);

        return novaDvosobno;
    }
}