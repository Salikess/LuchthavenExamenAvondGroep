package be.ehb.Luchthaven;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import be.ehb.Luchthaven.Personen.Passagier;
import be.ehb.Luchthaven.Personen.Personeel;





public class Luchthaven {

        private Scanner scanner = new Scanner(System.in);
        private List<Personen> Passagier = new ArrayList<>();
        private List<Vliegtuig> vliegtuigen = new ArrayList<>();
        private List<Personen> Personeel = new ArrayList<>();


    public void addPersonen(Personen persoon) {
        if (persoon instanceof Passagier) {
            Passagier.add((Passagier) persoon);
            System.out.println("Passagier ajouté: " + persoon);
        } else if (persoon instanceof Personeel) {
            Personeel.add((Personeel) persoon);
            System.out.println("Personnel ajouté: " + persoon);
        } else {
            System.out.println("Type inconnu de personne.");
        }
    }


        public void start() {
            while (true) {
                System.out.println("\n=== Luchthaven Menu ===");
                System.out.println("1. Nieuwe passagier aanmaken");
                System.out.println("2. Nieuwe vlucht aanmaken");
                System.out.println("3. Passagier aan vlucht toevoegen");
                System.out.println("4. Personeel aan vlucht toevoegen");
                System.out.println("5. Vluchtinformatie bekijken");
                System.out.println("6. Afsluiten");
                System.out.print("Kies een optie: ");
                int keuze = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (keuze) {
                    case 1 -> voegPassagierToe();
                    case 2 -> voegVluchtToe();
                    case 3 -> voegPassagierAanVluchtToe();
                    case 4 -> voegPersoneelAanVluchtToe();
                    case 5 -> printVluchtInfo();
                    case 6 -> {
                        System.out.println("Programma afgesloten.");
                        return;

                    }



                    default -> System.out.println("Ongeldige keuze, probeer opnieuw.");
                }
            }
        }

        private void voegPassagierToe() {
            System.out.print("Naam: ");
            String naam = scanner.nextLine();
            System.out.print("Leeftijd: ");
            int leeftijd = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Adres: ");
            String adres = scanner.nextLine();
            Passagier nieuwePassagier = new Passagier(naam, leeftijd, adres, "");
            Passagier.add(nieuwePassagier);

            //confirmation des donnees
            System.out.println("Passagier toegevoegd: " + nieuwePassagier);


        }

        private void voegVluchtToe() {
            System.out.print("Vluchtnummer: ");
            String vluchtnummer = scanner.nextLine();
            System.out.print("Bestemming: ");
            String bestemming = scanner.nextLine();
            System.out.print("Economy plaatsen: ");
            int economyPlaatsen = scanner.nextInt();
            System.out.print("Business plaatsen: ");
            int businessPlaatsen = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            vliegtuigen.add(new Vliegtuig(vluchtnummer, bestemming, economyPlaatsen, businessPlaatsen));
            System.out.println("Vlucht aangemaakt!");
        }

        private void voegPassagierAanVluchtToe() {
            System.out.println("Passagier:");
            for (int i = 0; i < Passagier.size(); i++) {
                System.out.println(i + ". " + Passagier.get(i));
            }
            System.out.print("Kies passagier ID: ");
            int passagierId = scanner.nextInt();
            System.out.println("Vluchten:");
            for (int i = 0; i < vliegtuigen.size(); i++) {
                System.out.println(i + ". " + vliegtuigen.get(i));
            }
            System.out.print("Kies vlucht ID: ");
            int vluchtId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Klasse (Economy/Business): ");
            String klasse = scanner.nextLine();

        }

        private void voegPersoneelAanVluchtToe() {
            System.out.print("Naam: ");
            String naam = scanner.nextLine();
            System.out.print("Leeftijd: ");
            int leeftijd = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Adres: ");
            String adres = scanner.nextLine();
            System.out.print("Functie: ");
            String functie = scanner.nextLine();
            Personen.Personeel nieuwPersoneel = new Personeel(naam, leeftijd, adres, functie);
            Personeel.add(nieuwPersoneel);

            System.out.println("Vluchten:");
            for (int i = 0; i < vliegtuigen.size(); i++) {
                System.out.println(i + ". " + vliegtuigen.get(i));
            }
            System.out.print("Kies vlucht ID: ");
            int vluchtId = scanner.nextInt();
            vliegtuigen.get(vluchtId).voegPersoneelToe(nieuwPersoneel);
        }

        private void printVluchtInfo() {
            System.out.println("Vluchten:");
            for (int i = 0; i < vliegtuigen.size(); i++) {
                System.out.println(i + ". " + vliegtuigen.get(i));
            }
            System.out.print("Kies vlucht ID: ");
            int vluchtId = scanner.nextInt();
            vliegtuigen.get(vluchtId).printVluchtInfo();
        }
    }




