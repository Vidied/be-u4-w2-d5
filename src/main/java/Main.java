import entities.Collezione;
import entities.Genere;
import entities.Gioco;
import entities.Videogioco;
import org.w3c.dom.ls.LSException;

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
      libreriaSteam.aggGioco(g2);
      libreriaSteam.aggGioco(g3);
      libreriaSteam.aggGioco(g4);

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
      String input = scanner.next();

      if(input.equals("esci")) {
        System.out.println("Uscita dalla ricerca id");
        break;
      }

      int ricercaGiocoId = Integer.parseInt(input);

      System.out.println("Ricerca del gioco con id: " + ricercaGiocoId);
      libreriaSteam.ricercaId(ricercaGiocoId);
    } catch (NumberFormatException e) {
      System.err.println("L'id è composto da soli numeri!");
    } catch (Exception e) {
      System.err.println("Errore: " + e.getMessage());
    }
  }


  while (true) {
    try {
      System.out.println("Filtra i giochi inserendo un soglia massima per il prezzo! Inserisci esci per uscire :)");
      String input = scanner.next();

      if(input.equals("esci")) {
        System.out.println("Uscita dalla ricerca filtro");
        break;
      }

      int maxSoldi = Integer.parseInt(input);


      List<Gioco> giochiFiltrati =  libreriaSteam.ricercaSoldiMax(maxSoldi);

      if (giochiFiltrati.isEmpty()) {
        System.out.println("Errore, purtroppo non possediamo giochi sotto questa soglia");
      } else {
        System.out.println("I risultati del tuo filtraggio sono: ");
        giochiFiltrati.forEach(System.out::println);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }








  }
}
