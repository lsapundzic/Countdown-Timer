import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Trgovinskastavba extends Poslovniprostor {

    private boolean stojnice;

    public Trgovinskastavba() {
        this.stojnice = false;
    }

    public Trgovinskastavba(boolean stojnice) {
        this.stojnice = stojnice;
    }

    public Trgovinskastavba(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String storitve, boolean used, int prihodek, boolean stojnice) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, storitve, used, prihodek);
        this.stojnice = stojnice;
    }

    public boolean isStojnice() {
        return stojnice;
    }

    public void setStojnice(boolean stojnice) {
        this.stojnice = stojnice;
    }

    public static Trgovinskastavba vnesiTrgovinskastavba() throws Exception {
        Scanner vhod = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi trgovinski stavbi!");

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

        System.out.println("Ali imajo stojnice?: ");
        boolean stojnice = vhod.nextBoolean();

        Trgovinskastavba novaTrgovinskastavba = new Trgovinskastavba(lastnik, velikostNepremicnin, cena, prodajaORoddaja, storitve, used, prihodek, stojnice);

        return novaTrgovinskastavba;
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
        zapis += "Stojnice: " + this.isStojnice() + "\r\n";
        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "r\n";
        zapis += this.getvelikostNepremicnin() + "\r\n";
        zapis += this.getprodajaORoddaja() + "\r\n";
        zapis += this.getCena() + "\r\n";
        zapis += this.getStoritve() + "\r\n";
        zapis += this.isUsed() + "\r\n";
        zapis += this.getPrihodek() + "\r\n";
        zapis += this.isStojnice() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Trgovinskastavba preberiIzNiza(ArrayList<String> zapis) {
        Trgovinskastavba novaTrgovinskastavba = new Trgovinskastavba();

        novaTrgovinskastavba.setLastnik(zapis.get(0));
        novaTrgovinskastavba.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaTrgovinskastavba.setprodajaORoddaja(zapis.get(2));
        novaTrgovinskastavba.setCena(Integer.parseInt(zapis.get(3)));
        novaTrgovinskastavba.setStoritve(zapis.get(4));
        novaTrgovinskastavba.setUsed(zapis.get(5).equals("true") ? true : false);
        novaTrgovinskastavba.setPrihodek(Integer.parseInt(zapis.get(6)));
        novaTrgovinskastavba.setStojnice(zapis.get(7).equals("true") ? true : false);
        return novaTrgovinskastavba;
    }
}