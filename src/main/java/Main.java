import entities.Collezione;
import entities.Genere;
import entities.Videogioco;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Collezione libreriaSteam = new Collezione();

    Videogioco LeagueOfLegends = new Videogioco( "LeagueOfLegends", 2009, 0,"PC", 30, Genere.MOBA);

    //Creo una lista contenete i giochi disponibili
    List<Videogioco> storeSteam = List.of(LeagueOfLegends);
    System.out.println("Giochi presenti nello store steam: " + storeSteam);

    //Stampo la mia collezione che al momento sarà vuota ma verrà popolata
    System.out.println("La tua libreria steam: ");
    libreriaSteam.stampaCollezione();



    try {
      System.out.println("Aggiungi un gioco: ");
      libreriaSteam.aggGioco(LeagueOfLegends);
      //Eseguo una seconda aggiunta per poter testare il messaggio di errore
      libreriaSteam.aggGioco(LeagueOfLegends);


    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    System.out.println("Libreria steam dopo gli aggiornamenti: ");
    libreriaSteam.stampaCollezione();








  }
}
