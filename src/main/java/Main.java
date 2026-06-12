import entities.Collezione;
import entities.Genere;
import entities.Videogioco;

import java.security.CodeSigner;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Collezione libreriaSteam = new Collezione();

    Videogioco g1 = new Videogioco( "League Of Legends", 2009, 0,"PC", 30, false,Genere.MOBA);
    Videogioco g2 = new Videogioco("Counter Strike", 2000, 0, "PC",20, false,Genere.SPARATUTTO);
    Videogioco g3 = new Videogioco("Monster Hunter", 2005, 60, "PC", 40, true, Genere.AVVENTURA);
    Videogioco g4 = new Videogioco("Hogwarts Legacy", 2023, 50,"PC-Play Station", 30, true,Genere.AVVENTURA );



    //Creo una lista contenete i giochi disponibili
    List<Videogioco> storeSteam = List.of(g1, g2, g3, g4);
    System.out.println("Giochi presenti nello store steam: " + storeSteam);

    //Stampo la mia collezione che al momento sarà vuota ma verrà popolata
    System.out.println("La tua libreria steam: ");
    libreriaSteam.stampaCollezione();



    try {
      System.out.println("Aggiungi un gioco: ");
      libreriaSteam.aggGioco(g1);
      libreriaSteam.aggGioco(g3);
      //Eseguo una seconda aggiunta per poter testare il messaggio di errore
      libreriaSteam.aggGioco(g1);


    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    System.out.println("Libreria steam dopo gli aggiornamenti: ");
    libreriaSteam.stampaCollezione();

  while (true) {
    try {
      System.out.println("Scrivi l'Id di uno dei giochi per cercarlo! Scrivi 99 per uscire dalla ricerca :)");
      int ricercaGiocoId = scanner.nextInt();

      if(ricercaGiocoId == 99) {
        System.out.println("Uscita dalla ricerca id");
        break;
      }

      System.out.println("Ricerca del gioco con id: " + ricercaGiocoId);
      libreriaSteam.ricercaId(ricercaGiocoId);
    } catch (java.util.InputMismatchException e) {
      System.err.println("L'id è composto da soli numeri!");
      scanner.next();
    } catch (Exception e) {
      System.err.println("Errore: " + e.getMessage());
    }
  }





  }
}
