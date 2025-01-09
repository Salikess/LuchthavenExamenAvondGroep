package be.ehb.Luchthaven;
import java.util.ArrayList;
import java.util.List;
import be.ehb.Luchthaven.Personen.Personeel;
import be.ehb.Luchthaven.Personen.Passagier;


public class Vliegtuig {
    private final String vluchtnummer;
    private final String bestemming;
    private int economyPlaatsen;
    private int businessPlaatsen;
    private final List<Passagier> passagiers;
    private final List<Personeel> personeel;

    public Vliegtuig(String vluchtnummer, String bestemming, int economyPlaatsen, int businessPlaatsen) {
        this.vluchtnummer = vluchtnummer;
        this.bestemming = bestemming;
        this.economyPlaatsen = economyPlaatsen;
        this.businessPlaatsen = businessPlaatsen;
        this.passagiers = new ArrayList<>();
        this.personeel = new ArrayList<>();
    }

    public void voegPassagierToe(Passagier Passagier, String klasse) {
        if (klasse.equalsIgnoreCase("Economy") && economyPlaatsen > 0) {
            passagiers.add(Passagier);

            economyPlaatsen--;
            System.out.println("Passagier toegevoegd in Economy.");
        } else if (klasse.equalsIgnoreCase("Business") && businessPlaatsen > 0) {
            passagiers.add(Passagier);
            businessPlaatsen--;
            System.out.println("Passagier toegevoegd in Business.");
        } else {
            System.out.println("Geen plaatsen beschikbaar in " + klasse + ".");
        }
    }

    public void voegPersoneelToe(Personeel p) {
        personeel.add(p);
        System.out.println("Personeel toegevoegd: " + p);
    }

    public boolean kanOpstijgen() {
        boolean pilootAanwezig = personeel.stream().anyMatch(Personeel::kanFlightCheckUitvoeren);
        return pilootAanwezig && !passagiers.isEmpty();
    }
    public void addPersonen(Personen persoon){
        System.out.println(persoon + " ajoute a la luchthaven.");


    }

    public void printVluchtInfo() {
        System.out.println("Vlucht " + vluchtnummer + " naar " + bestemming);
        System.out.println("Passagiers:");
        for (Passagier p : passagiers) {
            System.out.println("- " + p);
        }
        System.out.println("Personeel:");
        for (Personeel p : personeel) {
            System.out.println("- " + p);
        }
    }
}
