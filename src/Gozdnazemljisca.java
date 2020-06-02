import java.util.*;
import java.util.Scanner;

public class Gozdnazemljisca extends Zemljisca {

    private boolean dovoljenjezaposek;
    private boolean zarascenost;
    private String gozd;

    public Gozdnazemljisca() {

    }

    public Gozdnazemljisca(boolean dovoljenjezaposek, boolean zarascenost, String gozd) {
        this.dovoljenjezaposek = dovoljenjezaposek;
        this.zarascenost = zarascenost;
        this.gozd = gozd;
    }

    public Gozdnazemljisca(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String tipZemljisca, boolean dovoljenjezaposek, boolean zarascenost, String gozd) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, tipZemljisca);
        this.dovoljenjezaposek = dovoljenjezaposek;
        this.zarascenost = zarascenost;
        this.gozd = gozd;
    }

    public boolean isDovoljenjezaposek() {
        return dovoljenjezaposek;
    }

    public void setDovoljenjezaposek(boolean dovoljenjezaposek) {
        this.dovoljenjezaposek = dovoljenjezaposek;
    }

    public boolean isZarascenost() {
        return zarascenost;
    }

    public void setZarascenost(boolean zarascenost) {
        this.zarascenost = zarascenost;
    }

    public String getGozd() {
        return gozd;
    }

    public void setGozd(String gozd) {
        this.gozd = gozd;
    }

    public static Gozdnazemljisca vnesiGozdnazemljisca() throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi gozdni zemljisci!");

        System.out.println("Vnesite lastnika nepremicnine: ");
        String lastnik = input.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = input.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = input.nextLine();

        System.out.println("Vnesite ceno nepremicnine (v €): ");
        int cena = input.nextInt();

        System.out.println("Tip zemljisca: ");
        String tipZemljisca = input.nextLine();

        System.out.println("Ali ima dovoljenje za gradnjo?: ");
        boolean dovoljenjezaposek = input.nextBoolean();

        System.out.println("Ali je gozd zarascen?: ");
        boolean zarascenost = input.nextBoolean();

        System.out.println("Tipa gozda?: ");
        String gozd = input.nextLine();

        Gozdnazemljisca novaGozdnazemljisca = new Gozdnazemljisca(lastnik, velikostNepremicnin, cena, prodajaORoddaja, tipZemljisca, dovoljenjezaposek, zarascenost, gozd);

        return novaGozdnazemljisca;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\n";
        zapis += "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\n";
        zapis += "Cena(v €): " + this.getCena() + "\n";
        zapis += "Tip zemljisca: " + this.gettipZemljisca() + "\n";
        zapis += "Dovoljenje: " + this.isDovoljenjezaposek() + "\n";
        zapis += "Dovoljenje: " + this.isZarascenost() + "\n";
        zapis += "Dovoljenje: " + this.getGozd() + "\n";
        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "r\n";
        zapis += this.getvelikostNepremicnin() + "r\n";
        zapis += this.getprodajaORoddaja() + "r\n";
        zapis += this.getCena() + "r\n";
        zapis += this.gettipZemljisca() + "\r\n";
        zapis += this.isDovoljenjezaposek() + "\r\n";
        zapis += this.isZarascenost() + "\r\n";
        zapis += this.getGozd() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Gozdnazemljisca preberiIzNiza(ArrayList<String> zapis) {
        Gozdnazemljisca novaGozdnazemljisca = new Gozdnazemljisca();

        novaGozdnazemljisca.setLastnik(zapis.get(0));
        novaGozdnazemljisca.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaGozdnazemljisca.setprodajaORoddaja(zapis.get(2));
        novaGozdnazemljisca.setCena(Integer.parseInt(zapis.get(3)));
        novaGozdnazemljisca.settipZemljisca(zapis.get(4));
        novaGozdnazemljisca.setDovoljenjezaposek(zapis.get(5).equals("true") ? true : false);
        novaGozdnazemljisca.setZarascenost(zapis.get(6).equals("true") ? true : false);
        novaGozdnazemljisca.setGozd(zapis.get(7));
        return novaGozdnazemljisca;
    }
}