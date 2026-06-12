import entities.Collezione;
import entities.Genere;
import entities.Videogioco;

import java.sql.SQLOutput;

public class Main {
  public static void main(String[] args) {

    Collezione steam = new Collezione();

    Videogioco LeagueOfLegends = new Videogioco( "LeagueOfLegends", 2009, 0,"PC", 30, Genere.MOBA);

    try {
      System.out.println("Aggiungi un gioco: ");
      steam.aggGioco(LeagueOfLegends);
      

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
