import java.util.*;
import java.util.Scanner;

public class Zemljiscazagradnjo extends Zemljisca {

    private boolean dovoljenje;

    public Zemljiscazagradnjo() {
        this.dovoljenje = false;
    }

    public Zemljiscazagradnjo(boolean dovoljenje) {
        this.dovoljenje = dovoljenje;
    }

    public Zemljiscazagradnjo(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String tipZemljisca, boolean dovoljenje) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, tipZemljisca);
        this.dovoljenje = dovoljenje;
    }

    public boolean isDovoljenje() {
        return dovoljenje;
    }

    public void setDovoljenje(boolean dovoljenje) {
        this.dovoljenje = dovoljenje;
    }

    public static Zemljiscazagradnjo vnesiZemljiscazagradnjo() {
        Scanner vhod = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi zemljisci za gradnjo!");

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

        System.out.println("Ali ima dovoljenje za gradnjo?: ");
        boolean dovoljenje = vhod.nextBoolean();

        Zemljiscazagradnjo novaZemljiscazagradnjo = new Zemljiscazagradnjo(lastnik, velikostNepremicnin, cena, prodajaORoddaja, tipZemljisca, dovoljenje);

        return novaZemljiscazagradnjo;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\r\n";
        zapis += "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\r\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\r\n";
        zapis += "Cena(v €): " + this.getCena() + "\r\n";
        zapis += "Tip zemljisca: " + this.gettipZemljisca() + "\r\n";
        zapis += "Dovoljenje: " + this.isDovoljenje() + "\r\n";


        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "\r\n";
        zapis += this.getvelikostNepremicnin() + "\r\n";
        zapis += this.getprodajaORoddaja() + "\r\n";
        zapis += this.getCena() + "\r\n";
        zapis += this.gettipZemljisca() + "\r\n";
        zapis += this.isDovoljenje() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Zemljiscazagradnjo preberiIzNiza(ArrayList<String> zapis) {
        Zemljiscazagradnjo novaZemljiscazagradnjo = new Zemljiscazagradnjo();

        novaZemljiscazagradnjo.setLastnik(zapis.get(0));
        novaZemljiscazagradnjo.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaZemljiscazagradnjo.setprodajaORoddaja(zapis.get(2));
        novaZemljiscazagradnjo.setCena(Integer.parseInt(zapis.get(3)));
        novaZemljiscazagradnjo.settipZemljisca(zapis.get(4));
        novaZemljiscazagradnjo.setDovoljenje(zapis.get(5).equals("true") ? true : false);

        return novaZemljiscazagradnjo;
    }
}