import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Javnaustanova extends Poslovniprostor {

    private boolean pisarne;

    public Javnaustanova() {
        this.pisarne = false;
    }

    public Javnaustanova(boolean pisarne) {
        this.pisarne = pisarne;
    }

    public Javnaustanova(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String storitve, boolean used, int prihodek, boolean pisarne) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, storitve, used, prihodek);
        this.pisarne = pisarne;
    }

    public boolean isPisarne() {
        return pisarne;
    }

    public void setPisarne(boolean pisarne) {
        this.pisarne = pisarne;
    }

    public static Javnaustanova vnesiJavnaustanova() {
        Scanner vhod = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi javni ustanovi!");

        System.out.println("Vnesite lastnika nepremicnine: ");
        String lastnik = vhod.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = vhod.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = vhod.nextLine();

        System.out.println("Vnesite ceno nepremicnine (v €): ");
        int cena = vhod.nextInt();

        System.out.println("Kakšne storitve je v uporabi?: ");
        String storitve = vhod.nextLine();

        System.out.println("Ali je v rabi?: ");
        boolean used = vhod.nextBoolean();

        System.out.println("Kakšen je prihodek?: ");
        int prihodek = vhod.nextInt();

        System.out.println("Ali imajo pisarne?: ");
        boolean pisarne = vhod.nextBoolean();

        Javnaustanova novaJavnaustanova = new Javnaustanova(lastnik, velikostNepremicnin, cena, prodajaORoddaja, storitve, used, prihodek, pisarne);

        return novaJavnaustanova;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\r\n";
        zapis += "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\r\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\r\n";
        zapis += "Cena(v €): " + this.getCena() + "\r\n";
        zapis += "Storitve: " + this.getStoritve() + "\r\n";
        zapis += "Raba: " + this.isUsed() + "\r\n";
        zapis += "Prihodek: " + this.getPrihodek() + "\r\n";
        zapis += "Pisarne: " + this.isPisarne() + "\r\n";
        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "\r\n";
        zapis += this.getvelikostNepremicnin() + "\r\n";
        zapis += this.getprodajaORoddaja() + "\r\n";
        zapis += this.getCena() + "\r\n";
        zapis += this.getStoritve() + "\r\n";
        zapis += this.isUsed() + "\r\n";
        zapis += this.getPrihodek() + "\r\n";
        zapis += this.isPisarne() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Javnaustanova preberiIzNiza(ArrayList<String> zapis) {
        Javnaustanova novaJavnaustanova = new Javnaustanova();

        novaJavnaustanova.setLastnik(zapis.get(0));
        novaJavnaustanova.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaJavnaustanova.setprodajaORoddaja(zapis.get(2));
        novaJavnaustanova.setCena(Integer.parseInt(zapis.get(3)));
        novaJavnaustanova.setStoritve(zapis.get(4));
        novaJavnaustanova.setUsed(zapis.get(5).equals("true") ? true : false);
        novaJavnaustanova.setPrihodek(Integer.parseInt(zapis.get(6)));
        novaJavnaustanova.setPisarne(zapis.get(7).equals("true") ? true : false);
        return novaJavnaustanova;
    }
}