import entities.*;

import java.sql.SQLOutput;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    //Zona per i giochi da tavolo
    GiocoDaTavolo t1 = new GiocoDaTavolo("Monopoly", 1935, 25, 2, 6, 90);
    GiocoDaTavolo t2 = new GiocoDaTavolo("Scrabble", 1948, 19.50, 2, 4, 45);

    //Zona dedita per i videogiochi
    Collezione libreriaSteam = new Collezione();

    Videogioco g1 = new Videogioco( "League Of Legends", 2009, 0,"PC", 30, false,Genere.MOBA);
    Videogioco g2 = new Videogioco("Counter Strike", 2000, 0, "PC",20, false,Genere.SPARATUTTO);
    Videogioco g3 = new Videogioco("Monster Hunter", 2005, 60, "PC", 40, true, Genere.AVVENTURA);
    Videogioco g4 = new Videogioco("Hogwarts Legacy", 2023, 50,"PC-Play Station", 30, true,Genere.AVVENTURA );



    //Creo una lista contenete i giochi disponibili
    List<Gioco> storeSteam = List.of(g1, g2, g3, g4, t1 ,t2);
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
      libreriaSteam.aggGioco(t1);
      libreriaSteam.aggGioco(t2);

      //Eseguo una seconda aggiunta per poter testare il messaggio di errore
//      libreriaSteam.aggGioco(g1);


    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    System.out.println("Libreria steam dopo gli aggiornamenti: ");
    libreriaSteam.stampaCollezione();

  while (true) {
    try {
      System.out.println("Scrivi l'Id di uno dei giochi per cercarlo! Scrivi esci per uscire dalla ricerca :)");
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

      double maxSoldi = Double.parseDouble(input);


      List<Gioco> giochiFiltrati =  libreriaSteam.ricercaSoldiMax(maxSoldi);

      if (giochiFiltrati.isEmpty()) {
        System.out.println("Errore, purtroppo non possediamo giochi sotto questa soglia");
      } else {
        System.out.println("I risultati del tuo filtraggio sono: ");
        giochiFiltrati.forEach(System.out::println);
      }
    } catch (NumberFormatException e) {
      System.err.println("Errore: deve essere inserito un numero!");
    } catch (Exception e) {
      System.err.println("Errore: " + e.getMessage());
    }
  }

  while (true){
    try {
      System.out.println("Al momento la tua libreria steam contiene: ");
      libreriaSteam.stampaCollezione();
      System.out.println("Rimuovi i giochi inserendo il loro id! Inserisci esci per uscire :)");
      String input = scanner.next();

      if(input.equals("esci")) {
        System.out.println("Uscita dalla funzione di rimozione giochi");
        break;
      }

      int idRimosso = Integer.parseInt(input);


      libreriaSteam.rimGioco(idRimosso);

    } catch (NumberFormatException e) {
      System.err.println("Attenzione! Devi inserire un id composto da soli numeri");
    } catch (Exception e) {
      System.err.println("Errore: " + e.getMessage());
    }
  }

  while (true) {
    try {
      System.out.println("Cambia il prezzo a un gioco");
      System.out.println("Inserisci l'id in alternativa scrivi esci per uscire");
      String input = scanner.next();

      if(input.equals("esci")) {
        System.out.println("Uscita dalla funzione di modifica prezzi");
        break;
      }

      int giocoDaModificare = Integer.parseInt(input);

      if (!libreriaSteam.getCollezione().containsKey(giocoDaModificare))  {
        throw new Exception("Id: " + giocoDaModificare + " non presente");
      }

      System.out.println("Inserisci il nuovo prezzo per il gioco");
      String inputPrezzo = scanner.next();
      double nuovoPrezzo = Double.parseDouble(inputPrezzo);


      libreriaSteam.modificaGioco(giocoDaModificare, nuovoPrezzo);
    } catch (NumberFormatException e) {
      System.err.println("Attenzione! Inserisci solo numeri per la ricerca e scelta del nuovo prezzo");
    } catch (Exception e) {
      System.err.println("Errore: " + e.getMessage());
    }
  }

    System.out.println("Eccole le statistiche della tua libreria!");
    DoubleSummaryStatistics statistiche = libreriaSteam.statisticheGenerali();

    if (statistiche.getCount() > 0) {
      System.out.println("Il numero dei giochi presenti è di: " + statistiche.getCount());
      System.out.println("Il gioco più costoso è di: " + statistiche.getMax());
      System.out.println("La media dei prezzi dei giochi è di: " + statistiche.getAverage());
    } else {
      System.out.println("La libreria è vuota, nessuna statistica da dimostrare");
    }








  }
}
