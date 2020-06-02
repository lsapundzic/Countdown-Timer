import java.util.*;
import java.util.Scanner;

public class Nepremicnina {
    private String lastnik;
    private int velikostNepremicnin;
    private int cena;
    private String prodajaORoddaja;

    public Nepremicnina() {
        this.lastnik = "no name";
        this.velikostNepremicnin = 9999;
        this.cena = 9999;
        this.prodajaORoddaja = "unassigned";
    }

    public Nepremicnina(String lastnik, int velikostNepremicnin, int cena, String prodajaORoddaja) {
        this.lastnik = lastnik;
        this.velikostNepremicnin = velikostNepremicnin;
        this.prodajaORoddaja = prodajaORoddaja;
        this.cena = cena;
    }

    // Getters
    public String getprodajaORoddaja() {
        return prodajaORoddaja;
    }

    public int getvelikostNepremicnin() {
        return velikostNepremicnin;
    }

    public String getLastnik() {
        return lastnik;
    }

    public int getCena() {
        return cena;
    }

    //Setters
    public void setprodajaORoddaja(String prodajaORoddaja) {
        this.prodajaORoddaja = prodajaORoddaja;
    }

    public void setvelikostNepremicnin(int velikostNepremicnin) {
        this.velikostNepremicnin = velikostNepremicnin;
    }

    public void setLastnik(String lastnik) {
        this.lastnik = lastnik;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public static Nepremicnina vnesiNepremicnina() {
        Scanner vhod = new Scanner(System.in);

        System.out.println("***   Vnos novega nepremicnine:   ***\r\nVnesi ime lastnika: ");
        String lastnik = vhod.nextLine();

        System.out.println("Vnesi velikost nepremicnin: ");
        int velikostNepremicnin = vhod.nextInt();

        System.out.println("Ali gre za prodajo ali najem?: ");
        String prodajaORoddaja = vhod.next();

        System.out.println("Vnesite ceno nepremicnine (v €): ");
        int cena = vhod.nextInt();

        Nepremicnina novaNepremicnina = new Nepremicnina(lastnik, velikostNepremicnin, cena, prodajaORoddaja);
        return novaNepremicnina;
    }

    @Override
    public String toString() {
        String zapis = "Lastnik: " + this.getLastnik() + "\n" +
                "Velikost nepremicnine(meter na kvadrat): "
                + this.getvelikostNepremicnin() + "\n" +
                "Prodaja/oddaja: " + this.getprodajaORoddaja() + "\n" +
                "Cena(v eurih): " + this.getCena() + "\n";

        return zapis;
    }

    public String shraniKotNiz() {
        String zapis = "*N\r\n";
        zapis += this.lastnik + "r\n";
        zapis += this.velikostNepremicnin + "\r\n";
        zapis += this.prodajaORoddaja + "\r\n";
        zapis += this.cena + "\r\n";
        zapis += "##\r\n";

        return zapis;
    }

    public static Nepremicnina preberiIzNiza(ArrayList<String> zapis) {

        Nepremicnina novaNepremicnina = new Nepremicnina();

        novaNepremicnina.setLastnik(zapis.get(0));
        novaNepremicnina.setvelikostNepremicnin(Integer.parseInt(zapis.get(1)));
        novaNepremicnina.setprodajaORoddaja(zapis.get(2));
        novaNepremicnina.setCena(Integer.parseInt(zapis.get(3)));

        return novaNepremicnina;
    }
}