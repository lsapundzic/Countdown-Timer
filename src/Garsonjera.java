import java.util.*;
import java.util.Scanner;


public class Garsonjera extends Stanovanje {

    private boolean heating;
    private boolean balcony;

    public Garsonjera() {

    }

    public Garsonjera(boolean heating, boolean balcony) {
        this.heating = heating;
        this.balcony = balcony;
    }

    public Garsonjera(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, int bed, int floor, boolean heating, boolean balcony) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, bed, floor);
        this.heating = heating;
        this.balcony = balcony;
    }

    public boolean isHeating() {
        return heating;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public static Garsonjera vnesiGarsonjera() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi garsonjeri!");

        System.out.println("Vnesite lastnika nepremicnine: ");
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

        System.out.println("Ali ima ogrevanje?: ");
        boolean heating = input.nextBoolean();

        System.out.println("Ali ima balkon?: ");
        boolean balcony = input.nextBoolean();

        Garsonjera novaGarsonjera = new Garsonjera(lastnik, velikostNepremicnin, cena, prodajaORoddaja, bed, floor, heating, balcony);

        return novaGarsonjera;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\n";
        zapis += "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\n";
        zapis += "Cena(v €): " + this.getCena() + "\n";
        zapis += "Stevilo spalnic: " + this.getBed() + "\n";
        zapis += "Stevilo nadstropja: " + this.getFloor() + "\n";
        zapis += "Ogrevanje: " + this.isHeating() + "\n";
        zapis += "Balkon: " + this.isBalcony() + "\n";

        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "r\n";
        zapis += this.getvelikostNepremicnin() + "r\n";
        zapis += this.getprodajaORoddaja() + "r\n";
        zapis += this.getCena() + "r\n";
        zapis += this.getBed() + "\r\n";
        zapis += this.getFloor() + "\r\n";
        zapis += this.isHeating() + "\r\n";
        zapis += this.isBalcony() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Garsonjera preberiIzNiza(ArrayList<String> zapis) {
        Garsonjera novaGarsonjera = new Garsonjera();

        novaGarsonjera.setLastnik(zapis.get(0));
        novaGarsonjera.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaGarsonjera.setprodajaORoddaja(zapis.get(2));
        novaGarsonjera.setCena(Integer.parseInt(zapis.get(3)));
        novaGarsonjera.setBed(Integer.parseInt(zapis.get(4)));
        novaGarsonjera.setFloor(Integer.parseInt(zapis.get(5)));
        novaGarsonjera.setHeating(zapis.get(6).equals("true") ? true : false);
        novaGarsonjera.setBalcony(zapis.get(7).equals("true") ? true : false);

        return novaGarsonjera;
    }
}