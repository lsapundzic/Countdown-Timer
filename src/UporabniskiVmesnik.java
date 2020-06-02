import java.util.InputMismatchException;
import java.util.Scanner;

public class UporabniskiVmesnik {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("*** Dobrodosli v nas program ***\n");

        bazaNepremicnina bazanepremicnina = new bazaNepremicnina();


        System.out.println("Pritisnite (q) za vnos nepremicnin.");
        System.out.println("Pritisnite (w) za odstranitev nepremicnin.");
        System.out.println("Pritisnite (e) za izpis nepremicnin.");
        System.out.println("Pritisnite (r) za shranjevanje nepremicnin v datoteko.");
        System.out.println("Pritisnite (t) za vpis nepremicnin iz datoteke.");
        System.out.println("Pritisnite (z) za iskanje po kriterijih.");
        System.out.println("Pritisnite (x) za izhod.");

        while (true) {

            try {
//                Scanner reader = new Scanner(System.in);
                char izbira = input.next().toLowerCase().charAt(0);

                switch (izbira) {
                    case 'q':

                        System.out.println("Vrste nepremicnin za vnos.");
                        System.out.println("Pritisnite (q) za vnos poslovnega prostora.");
                        System.out.println("Pritisnite (w) za vnos stanovanja.");
                        System.out.println("Pritisnite (e) za vnos zemljisca.");


                        Nepremicnina novaNepremicnina = null;
                        String obvestilo;

                        izbira = input.next().toLowerCase().charAt(0);
                        switch (izbira) {
                            case 'q':

                                System.out.println("Vrste poslovnega prostora za vnos.");
                                System.out.println("Pritisnite (q) za vnos javne ustanove.");
                                System.out.println("Pritisnite (w) za vnos trgovinske stavbe.");
                                System.out.println("Pritisnite (e) za vnos industrijske stavbe.");

                                Poslovniprostor novoPoslovniprostor = null;

                                izbira = input.next().toLowerCase().charAt(0);
                                switch (izbira) {

                                    case 'q':
                                        bazanepremicnina.dodajNepremicnino(Javnaustanova.vnesiJavnaustanova());

                                        break;
                                    case 'w':
                                        bazanepremicnina.dodajNepremicnino(Trgovinskastavba.vnesiTrgovinskastavba());

                                        break;
                                    case 'e':
                                        bazanepremicnina.dodajNepremicnino(Industrijskestavbe.vnesiIndustrijskestavbe());

                                        break;
                                    default:
                                        System.out.println("Prislo je do napake.");
                                        break;
                                }

                                break;

                            case 'w':
                                System.out.println("Izaberite vrsto stanovanja za vnos.");
                                System.out.println("Pritisnite (q) za vnos garsonjere.");
                                System.out.println("Pritisnite (w) za vnos enosobno.");
                                System.out.println("Pritisnite (e) za vnos dvosobno.");
                                Stanovanje novoStanovanje;
                                izbira = input.next().toLowerCase().charAt(0);

                                switch (izbira) {
                                    case 'q':
                                        bazanepremicnina.dodajNepremicnino(Garsonjera.vnesiGarsonjera());

                                        break;
                                    case 'w':
                                        bazanepremicnina.dodajNepremicnino(Enosobno.vnesiEnosobno());

                                        break;
                                    case 'e':
                                        bazanepremicnina.dodajNepremicnino(Dvosobno.vnesiDvosobno());

                                        break;
                                    default:
                                        System.out.println("Prislo je do napake.");

                                        break;
                                }

//                                break;

                            case 'e':

                                System.out.println("Vrste zemljisca za vnos.");
                                System.out.println("Pritisnite (q) za vnos zemljisca za gradnjo.");
                                System.out.println("Pritisnite (w) za vnos gozdna zemljisca.");
                                System.out.println("Pritisnite (e) za vnos kmetijska zemljisca.");

                                Zemljisca novoZemljisca = null;

                                izbira = input.next().toLowerCase().charAt(0);
                                switch (izbira) {

                                    case 'q':
                                        bazanepremicnina.dodajNepremicnino(Zemljiscazagradnjo.vnesiZemljiscazagradnjo());

                                        break;
                                    case 'w':
                                        bazanepremicnina.dodajNepremicnino(Gozdnazemljisca.vnesiGozdnazemljisca());

                                        break;
                                    case 'e':
                                        bazanepremicnina.dodajNepremicnino(Kmetijskazemljisca.vnesiKmetijskazemljisca());

                                        break;
                                    default:
                                        System.out.println("Prislo je do napake.");
                                        break;
                                }
                            default:
                                System.out.println("Prislo je do napake.");
                                break;
                        }


//                        obvestilo = bazanepremicnina.dodajNepremicnino(novaNepremicnina);
//                        if (obvestilo.length() > 0) {
//                            System.out.println(obvestilo);
//                        } else {
//                            System.out.println(novaNepremicnina.toString());
//                        }
                        break;

                    case 'd':
                        boolean odstranjen;
                        System.out.println("Odstranitev nepremicnin.");
                        System.out.println("Vnesite lastnika nepremicnin, ki je zelite odstraniti.");
                        String lastni = input.nextLine();
                        odstranjen = bazanepremicnina.remove(lastni);

                        if (odstranjen) {
                            System.out.println("Nepremicnina z lastnikom " + lastni.trim() + " uspesno je odstranjen.");
                        } else {
                            System.out.println("Nepremicnina z lastnikom  " + lastni.trim() + " ni na seznamu.");
                        }

                        break;

                    case 'n':
                        System.out.println("Izpis vseh nepremicnin v evidenci nepremicnin.");
                        System.out.println(bazanepremicnina.toString());
                        break;

                    case 's':

                        System.out.println("Shranjevanje nepremicnine v datoteko.");
                        System.out.println("Vnesi ime datoteke za shranjevanje nepremicnine.");
                        String save = input.nextLine();
                        bazanepremicnina.shranjevanje(save);
                        break;

                    case 'v':
                        System.out.println("Vpis nepremicnine iz datoteke.");
                        System.out.println("Vnesite ime datoteke za branje nepremicnine.");
                        String read = input.nextLine();
                        bazanepremicnina.reading(read);
                        break;

                    case 'i':
                        System.out.println("Iskanje po kriterijih.");
                        System.out.println("Vrsto iskanja.");
                        System.out.println("Pritisnite (f) za izpis clanov po primeku.");
                        System.out.println("Pritisnite (u) za izpis leta vclanitve clana.");
                        System.out.println("Pritisnite (o) za izpis clanov glede placila clanarine.");

                        izbira = input.next().toLowerCase().charAt(0);


                        switch (izbira) {
                            case 'f':
                                System.out.println("Iskanje nepremicnine po ceni.");
                                System.out.println("Vnesite ceno.");
                                int cenanep = input.nextInt();
                                System.out.println(bazanepremicnina.price(cenanep));
                                break;
                            case 'o':
                                System.out.println("Ce zelite nepremicnine za prodajo, vnesite: prodaja.");
                                System.out.println("Ce zelite nepremicnine za najem, vnesite: najem.");
                                System.out.println("Ce zelite nepremicnine ki ni na prodaj oz. ni za najem, vnesite: ni za prodajo.");
                                String prodajaOddaja = input.nextLine();
                                System.out.println(bazanepremicnina.prodajaORoddaja(prodajaOddaja));
                                break;
                            default:
                                System.out.println("Prislo je do napake.");
                        }

                        break;
                    case 'x':
                        System.out.println("Izhod iz programa.");
                        System.exit(0);

                    default:
                        System.out.println("Uncaught Error");
                        System.exit(0);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                System.exit(0);
            } catch (Exception e) {
                System.out.println("Napaka - poskusite znova!");
                System.exit(0);
            }

        }

    }

}