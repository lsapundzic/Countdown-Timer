import java.util.*;
import java.util.Scanner;

public class Industrijskestavbe extends Poslovniprostor {

    private boolean tovarna;
    private boolean stroj;

    public Industrijskestavbe() {

    }

    public Industrijskestavbe(boolean tovarna, boolean stroj) {
        this.tovarna = tovarna;
        this.stroj = stroj;
    }

    public Industrijskestavbe(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja, String storitve, boolean used, int prihodek, boolean tovarna, boolean stroj) {
        super(lastnik, velikostNepremicnin, cena, prodajaORoddaja, storitve, used, prihodek);
        this.tovarna = tovarna;
        this.stroj = stroj;
    }

    public boolean isTovarna() {
        return tovarna;
    }

    public void setTovarna(boolean tovarna) {
        this.tovarna = tovarna;
    }

    public boolean isStroj() {
        return stroj;
    }

    public void setStroj(boolean stroj) {
        this.stroj = stroj;
    }

    public static Industrijskestavbe vnesiIndustrijskestavbe() throws Exception {
        Scanner vhod = new Scanner(System.in);

        System.out.println("Vnos podatkov o novi industrijski stavbi!");

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

        System.out.println("Ali imajo tovarne?: ");
        boolean tovarna = vhod.nextBoolean();

        System.out.println("Ali imajo stroje?: ");
        boolean stroj = vhod.nextBoolean();

        Industrijskestavbe novaIndustrijskestavbe = new Industrijskestavbe(lastnik, velikostNepremicnin, cena, prodajaORoddaja, storitve, used, prihodek, tovarna, stroj);

        return novaIndustrijskestavbe;
    }

    @Override
    public String toString() {
        String zapis = "";
        zapis += "Lastnik: " + this.getLastnik() + "\n";
        zapis += "Velikost nepremicnine(meter na kvadrat): " + this.getvelikostNepremicnin() + "\n";
        zapis += "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\n";
        zapis += "Cena(v €): " + this.getCena() + "\n";
        zapis += "Storitve: " + this.getStoritve() + "\n";
        zapis += "Raba: " + this.isUsed() + "\n";
        zapis += "Prihodek: " + this.getPrihodek() + "\n";
        zapis += "Tovarna: " + this.isTovarna() + "\n";
        zapis += "Stroj: " + this.isStroj() + "\n";
        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*Sta\r\n";
        zapis += this.getLastnik() + "r\n";
        zapis += this.getvelikostNepremicnin() + "r\n";
        zapis += this.getprodajaORoddaja() + "r\n";
        zapis += this.getCena() + "r\n";
        zapis += this.getStoritve() + "\r\n";
        zapis += this.isUsed() + "\r\n";
        zapis += this.getPrihodek() + "\r\n";
        zapis += this.isTovarna() + "\r\n";
        zapis += this.isStroj() + "\r\n";
        zapis += "#\r\n";

        return zapis;

    }

    public static Industrijskestavbe preberiIzNiza(ArrayList<String> zapis) {
        Industrijskestavbe novoIndustrijskestavbe = new Industrijskestavbe();

        novoIndustrijskestavbe.setLastnik(zapis.get(0));
        novoIndustrijskestavbe.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novoIndustrijskestavbe.setprodajaORoddaja(zapis.get(2));
        novoIndustrijskestavbe.setCena(Integer.parseInt(zapis.get(3)));
        novoIndustrijskestavbe.setStoritve(zapis.get(4));
        novoIndustrijskestavbe.setUsed(zapis.get(5).equals("true") ? true : false);
        novoIndustrijskestavbe.setPrihodek(Integer.parseInt(zapis.get(6)));
        novoIndustrijskestavbe.setTovarna(zapis.get(7).equals("true") ? true : false);
        novoIndustrijskestavbe.setStroj(zapis.get(7).equals("true") ? true : false);
        return novoIndustrijskestavbe;
    }
}