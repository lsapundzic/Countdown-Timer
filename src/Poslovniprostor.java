import java.util.*;
import java.util.Scanner;

public class Poslovniprostor extends Nepremicnina {

    private String storitve;
    private boolean used;
    private int prihodek;

    public Poslovniprostor() {
        this.storitve = "none";
        this.used = false;
        this.prihodek = 9999;
    }

    public Poslovniprostor(String storitve, boolean used, int prihodek) {
        this.storitve = storitve;
        this.used = used;
        this.prihodek = prihodek;
    }

    public Poslovniprostor(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String storitve, boolean used, int prihodek) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja);
        this.storitve = storitve;
        this.used = used;
        this.prihodek = prihodek;
    }

    public String getStoritve() {
        return storitve;
    }

    public void setStoritve(String storitve) {
        this.storitve = storitve;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getPrihodek() {
        return prihodek;
    }

    public void setPrihodek(int prihodek) {
        this.prihodek = prihodek;
    }

    public static Poslovniprostor vnesiPoslovniprostor() throws Exception {
        Scanner vhod = new Scanner(System.in);

        System.out.println("Vnos podatkov o novem zemljiscu!");

        System.out.println("Vnesite lastnika nepremicnine: ");
        String lastnik = vhod.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = vhod.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = vhod.nextLine();

        System.out.println("Vnesite ceno nepremicnine (v eurih): ");
        int cena = vhod.nextInt();

        System.out.println("Kakšne storitve se tam uporablja?: ");
        String storitve = vhod.nextLine();

        System.out.println("Ali je v rabi?: ");
        boolean used = vhod.nextBoolean();

        System.out.println("Kakšen je prihodek?: ");
        int prihodek = vhod.nextInt();

        Poslovniprostor novoPoslovniprostor = new Poslovniprostor(lastnik, velikostNepremicnin, cena, prodajaORoddaja, storitve, used, prihodek);

        return novoPoslovniprostor;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\r\n";
        zapis += "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\r\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\r\n";
        zapis += "Cena(v €): " + this.getCena() + "\r\n";
        zapis += "Storitve: " + this.getStoritve() + "\r\n";
        zapis += "V rabi: " + this.isUsed() + "\r\n";
        zapis += "Prihodek: " + this.getPrihodek() + "\r\n";

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
        zapis += "#\r\n";

        return zapis;
    }

    public static Poslovniprostor preberiIzNiza(ArrayList<String> zapis) {
        Poslovniprostor novoPoslovniprostor = new Poslovniprostor();

        novoPoslovniprostor.setLastnik(zapis.get(0));
        novoPoslovniprostor.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novoPoslovniprostor.setprodajaORoddaja(zapis.get(2));
        novoPoslovniprostor.setCena(Integer.parseInt(zapis.get(3)));
        novoPoslovniprostor.setStoritve(zapis.get(4));
        novoPoslovniprostor.setUsed(zapis.get(5).equals("true") ? true : false);
        novoPoslovniprostor.setPrihodek(Integer.parseInt(zapis.get(6)));

        return novoPoslovniprostor;
    }
}