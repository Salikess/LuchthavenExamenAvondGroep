package be.ehb.Luchthaven;
import be.ehb.Luchthaven.Vliegtuig;


public class Personen {

    private String naam;
    private int leeftijd;
    private String adres;

    // Constructeur
    public Personen(String naam, int leeftijd, String adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
    }

    // Méthode toString pour afficher les informations



    @Override
    public String toString() {
        return "Naam: " + naam + ", Leeftijd: " + leeftijd + ", Adres: " + adres;

    }


    // Sous-classe Personeel
    public static class Personeel extends Personen {
        private String functie;

        // Constructeur
        public Personeel(String naam, int leeftijd, String adres, String functie) {
            super(naam, leeftijd, adres);
            this.functie = functie;
        }


        public boolean kanFlightCheckUitvoeren() {
            return functie.equalsIgnoreCase("Piloot");
        }

        @Override
        public String toString() {
            return super.toString() + ", Functie: " + functie;
        }
    }

    // Sous-classe Passagier
    public static class Passagier extends Personen {
        private String klasse;

        // Constructeur
        public Passagier(String naam, int leeftijd, String adres, String klasse) {
            super(naam, leeftijd, adres);
            this.klasse = klasse;
        }

        @Override
        public String toString() {
            return super.toString() + ", Klasse: " + klasse;
        }
    }
}




