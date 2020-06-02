import java.util.*;
import java.util.Scanner;

public class Stanovanje extends Nepremicnina {
    private int bed;
    private int floor;

    public Stanovanje() {
        this.bed = 9999;
        this.floor = 9999;
    }

    public Stanovanje(int bed, int floor) {
        this.bed = bed;
        this.floor = floor;
    }

    public Stanovanje(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, int bed, int floor) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja);
        this.bed = bed;
        this.floor = floor;
    }

    public int getBed() {
        return bed;
    }

    public int getFloor() {
        return floor;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public static Stanovanje vnesiStanovanje() {
        Scanner input = new Scanner(System.in);

        System.out.println("Vnos podatkov o novem stanovanju!\r\n" +
                "Vnesite lastnika nepremicnine: ");

        String lastnik = input.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = input.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = input.nextLine();

        System.out.println("Vnesite ceno nepremicnine (v eurih): ");
        int cena = input.nextInt();

        System.out.println("Vnesite stevilo spalnic: ");
        int bed = input.nextInt();

        System.out.println("Vnesite stevilo nadstropja: ");
        int floor = input.nextInt();

        Stanovanje novoStanovanje = new Stanovanje(lastnik, velikostNepremicnin, cena, prodajaORoddaja, bed, floor);

        return novoStanovanje;
    }

    @Override
    public String toString() {
        String zapis = "Lastnik: " + this.getLastnik() + "\r\n" +
                "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\r\n" +
                "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\r\n" +
                "Cena(v €): " + this.getCena() + "\r\n" +
                "Stevilo spalnic: " + this.getBed() + "\r\n" +
                "Stevilo nadstropja: " + this.getFloor() + "\r\n";

        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n" +
                this.getLastnik() + "\r\n" +
                this.getvelikostNepremicnin() + "\r\n" +
                this.getprodajaORoddaja() + "\r\n" +
                this.getCena() + "\r\n" + this.getBed() + "\r\n" +
                this.getFloor() + "\r\n" + "#\r\n";

        return zapis;

    }

    public static Stanovanje preberiIzNiza(ArrayList<String> zapis) {
        Stanovanje novoStanovanje = new Stanovanje();

        novoStanovanje.setLastnik(zapis.get(0));
        novoStanovanje.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novoStanovanje.setprodajaORoddaja(zapis.get(2));
        novoStanovanje.setCena(Integer.parseInt(zapis.get(3)));
        novoStanovanje.setBed(Integer.parseInt(zapis.get(4)));
        novoStanovanje.setFloor(Integer.parseInt(zapis.get(5)));

        return novoStanovanje;

    }
}