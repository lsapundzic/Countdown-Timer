import java.util.*;
import java.util.Scanner;

public class Kmetijskazemljisca extends Zemljisca {

    private boolean dovoljenjezaobdelavo;
    private boolean zarascenost;

    public Kmetijskazemljisca() {
        this.dovoljenjezaobdelavo = false;
        this.zarascenost = false;
    }

    public Kmetijskazemljisca(boolean dovoljenjezaobdelavo, boolean zarascenost) {
        this.dovoljenjezaobdelavo = dovoljenjezaobdelavo;
        this.zarascenost = zarascenost;
    }

    public Kmetijskazemljisca(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String tipZemljisca, boolean dovoljenjezaobdelavo, boolean zarascenost) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, tipZemljisca);
        this.dovoljenjezaobdelavo = dovoljenjezaobdelavo;
        this.zarascenost = zarascenost;
    }

    public boolean isDovoljenjezaobdelavo() {
        return dovoljenjezaobdelavo;
    }

    public void setDovoljenjezaobdelavo(boolean dovoljenjezaobdelavo) {
        this.dovoljenjezaobdelavo = dovoljenjezaobdelavo;
    }

    public boolean isZarascenost() {
        return zarascenost;
    }

    public void setZarascenost(boolean zarascenost) {
        this.zarascenost = zarascenost;
    }

    public static Kmetijskazemljisca vnesiKmetijskazemljisca() {
        Scanner input = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi gozdni zemljisci!");

        System.out.println("Vnesite lastnika nepremicnine: ");
        String lastnik = input.nextLine();

        System.out.println("Vnesite velikost nepremicnin (cm2): ");
        int velikostNepremicnin = input.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = input.next();

        System.out.println("Vnesite ceno nepremicnine (v €): ");
        int cena = input.nextInt();

        System.out.println("Tip zemljisca: ");
        String tipZemljisca = input.next();

        System.out.println("Ali ima dovoljenje za obdelavo?: ");
        boolean dovoljenjezaobdelavo = input.nextBoolean();

        System.out.println("Ali je kmetijska zemljisca zarascena?: ");
        boolean zarascenost = input.nextBoolean();

        Kmetijskazemljisca novaKmetijskazemljisca = new Kmetijskazemljisca(lastnik, velikostNepremicnin, cena, prodajaORoddaja, tipZemljisca, dovoljenjezaobdelavo, zarascenost);

        return novaKmetijskazemljisca;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\r\n";
        zapis += "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\r\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\r\n";
        zapis += "Cena(v €): " + this.getCena() + "\r\n";
        zapis += "Tip zemljisca: " + this.gettipZemljisca() + "\r\n";
        zapis += "Dovoljenje: " + this.isDovoljenjezaobdelavo() + "\r\n";
        zapis += "Dovoljenje: " + this.isZarascenost() + "\r\n";
        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "\r\n";
        zapis += this.getvelikostNepremicnin() + "\r\n";
        zapis += this.getprodajaORoddaja() + "\r\n";
        zapis += this.getCena() + "\r\n";
        zapis += this.gettipZemljisca() + "\r\n";
        zapis += this.isDovoljenjezaobdelavo() + "\r\n";
        zapis += this.isZarascenost() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Kmetijskazemljisca preberiIzNiza(ArrayList<String> zapis) {
        Kmetijskazemljisca novaKmetijskazemljisca = new Kmetijskazemljisca();

        novaKmetijskazemljisca.setLastnik(zapis.get(0));
        novaKmetijskazemljisca.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaKmetijskazemljisca.setprodajaORoddaja(zapis.get(2));
        novaKmetijskazemljisca.setCena(Integer.parseInt(zapis.get(3)));
        novaKmetijskazemljisca.settipZemljisca(zapis.get(4));
        novaKmetijskazemljisca.setDovoljenjezaobdelavo(zapis.get(5).equals("true") ? true : false);
        novaKmetijskazemljisca.setZarascenost(zapis.get(6).equals("true") ? true : false);
        return novaKmetijskazemljisca;
    }
}