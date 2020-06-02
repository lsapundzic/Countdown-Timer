import java.util.*;
import java.io.*;

public class bazaNepremicnina {
    private String name;
    private int letoGradnje;
    private static ArrayList<Nepremicnina> evidencaNepremicnine;

    public bazaNepremicnina() {
        evidencaNepremicnine = new ArrayList<>();
    }

    public bazaNepremicnina(String name, int letoGradnje) {
        this.name = name;
        this.letoGradnje = letoGradnje;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getletoGradnje() {
        return letoGradnje;
    }

    public void setletoGradnje(int letoGradnje) {
        this.letoGradnje = letoGradnje;
    }

    public static ArrayList<Nepremicnina> getevidencaNepremicnine() {
        return evidencaNepremicnine;
    }

    public void dodajNepremicnino(Nepremicnina nepremicnina) {
        evidencaNepremicnine.add(nepremicnina);
    }

    public boolean remove(String lastnik) {
        boolean odstranjen = false;
        for (int i = 0; i < evidencaNepremicnine.size(); i++) {
            if (this.evidencaNepremicnine.get(i).getLastnik().trim().equals(lastnik.trim())) {
                this.evidencaNepremicnine.remove(i);
                odstranjen = true;
            }

        }
        return odstranjen;
    }

    public String toString() {
        String opis = "";
        if (this.evidencaNepremicnine.size() > 0) {
            opis += "V evidencah nepremicnin: \r\n\r\n";
            for (int i = 0; i < this.evidencaNepremicnine.size(); i++) {
                opis += this.evidencaNepremicnine.get(i).toString() + "\n";
            }
        } else {
            opis += "V evidencah trenutno ni nepremicnin. \n";
        }
        return opis;
    }

    public void shranjevanje(String imeDatoteke) throws IOException {
        FileWriter fw = new FileWriter(imeDatoteke, true);
        PrintWriter dat = new PrintWriter(fw);
        for (Nepremicnina nepremicnina : this.evidencaNepremicnine) {
            dat.print(nepremicnina.shraniKotNiz());
        }
        dat.close();
    }

    public void reading(String imeDatoteke) throws Exception {
        FileReader fr = new FileReader(imeDatoteke);
        BufferedReader dat = new BufferedReader(fr);

        ArrayList<String> nepremicninaPodatki;
        while (dat.ready()) {
            String vrstica = dat.readLine().trim().toUpperCase();
            if (vrstica.equals("*N")) {
                nepremicninaPodatki = new ArrayList<String>();
                while (dat.ready() && !vrstica.equals("##")) {
                    vrstica = dat.readLine().trim();
                    nepremicninaPodatki.add(vrstica);
                }

                Nepremicnina novaNepremicnina = Nepremicnina.preberiIzNiza(nepremicninaPodatki);

                if (!existsNepremicninaZLastnikom(novaNepremicnina)) {
                    this.evidencaNepremicnine.add(novaNepremicnina);
                } else {
                    System.out.println("Nepremicnina pri tem lastniku " + novaNepremicnina.getLastnik() + " ze obstaja.");
                }
            }
        }
        dat.close();
    }

    public boolean existsNepremicninaZLastnikom(Nepremicnina nepremicnina) {
        boolean exists = false;
        for (Nepremicnina n : this.evidencaNepremicnine) {
            if (n.getLastnik().equals(nepremicnina.getLastnik())) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public String price(int cena) {
        String zapis = "";
        boolean exists = false;

        for (int i = 0; i < evidencaNepremicnine.size(); i++) {
            if (evidencaNepremicnine.get(i).getCena() == cena) {
                exists = true;
                zapis += this.evidencaNepremicnine.get(i).toString();
            }

        }
        if (exists == false) {
            return "Nobena nepremicnina nima cene " + cena + " evrov.";
        } else {
            return zapis;
        }
    }

    public String prodajaORoddaja(String prodajaORoddaja) {
        String zapis = "";
        boolean exists = false;

        for (int i = 0; i < this.evidencaNepremicnine.size(); i++) {
            if (this.evidencaNepremicnine.get(i).getprodajaORoddaja().equals(prodajaORoddaja)) {
                exists = true;
                zapis += this.evidencaNepremicnine.get(i).toString();
            }

        }
        if (exists == false) {
            return "Napaka! Vnesite eno od ponujenih možnosti(prodaja/najem/ni za prodajo).";
        } else {
            return zapis;
        }

    }
}