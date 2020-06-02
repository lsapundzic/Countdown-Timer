import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Zemljisca extends Nepremicnina {

    private String tipZemljisca;

    public Zemljisca() {

    }

    public Zemljisca(String tipZemljisca) {
        this.tipZemljisca = tipZemljisca;
    }

    public Zemljisca(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String tipZemljisca) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja);
        this.tipZemljisca = tipZemljisca;
    }

    public String gettipZemljisca() {
        return tipZemljisca;
    }

    public void settipZemljisca(String tipZemljisca) {
        this.tipZemljisca = tipZemljisca;
    }

    public static Zemljisca vnesiZemljisca() {
        Scanner vhod = new Scanner(System.in);

        System.out.println("Vnos podatkov o novem zemljiscu!");

        System.out.println("Vnesite lastnika nepremicnine: ");
        String lastnik = vhod.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = vhod.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = vhod.nextLine();

        System.out.println("Vnesite ceno nepremicnine (v €): ");
        int cena = vhod.nextInt();

        System.out.println("Tip zemljisca: ");
        String tipZemljisca = vhod.nextLine();

        Zemljisca novoZemljisca = new Zemljisca(lastnik, velikostNepremicnin, cena, prodajaORoddaja, tipZemljisca);

        return novoZemljisca;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\r\n" +
                "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\r\n" +
                "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\r\n" +
                "Cena(v eurih): " + this.getCena() + "\r\n" +
                "Tip zemljisca: " + this.gettipZemljisca() + "\r\n";

        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n" +
                this.getLastnik() + "\r\n" +
                this.getvelikostNepremicnin() + "\r\n" +
                this.getprodajaORoddaja() + "\r\n" +
                this.getCena() + "\r\n" +
                this.gettipZemljisca() + "\r\n" +
                "#\r\n";

        return zapis;
    }

    public static Zemljisca preberiIzNiza(ArrayList<String> zapis) {
        Zemljisca novoZemljisca = new Zemljisca();

        novoZemljisca.setLastnik(zapis.get(0));
        novoZemljisca.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novoZemljisca.setprodajaORoddaja(zapis.get(2));
        novoZemljisca.setCena(Integer.parseInt(zapis.get(3)));
        novoZemljisca.settipZemljisca(zapis.get(4));

        return novoZemljisca;
    }
}