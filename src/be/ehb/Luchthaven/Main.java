package be.ehb.Luchthaven;
import be.ehb.Luchthaven.Personen;
import be.ehb.Luchthaven.Vliegtuig;
import be.ehb.Luchthaven.Luchthaven;


public class Main {
        public static void main(String[] args) {
            Luchthaven luchthaven = new Luchthaven();


            // Créer des objets Personen
            Personen.Personeel piloot = new Personen.Personeel("Jan", 45, "Bruxelles", "Piloot");
            Personen.Passagier passagier = new Personen.Passagier("Marie", 30, "Anvers", "Business");

            // Ajouter des personnes à la Luchthaven
            luchthaven.addPersonen(piloot);      // Ajouter un personnel
            luchthaven.addPersonen(passagier);  // Ajouter un passager

            // Lancer le menu principal
            luchthaven.start();
        }

}







































