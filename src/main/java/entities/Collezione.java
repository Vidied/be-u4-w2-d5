package entities;

import java.security.spec.ECField;
import java.sql.SQLOutput;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collezione {

  Map<Integer, Gioco> collezione = new HashMap<>();

  //Metodo per aggiungere un gioco nella collezione
  public void aggGioco(Gioco gioco) throws Exception {
    if (collezione.containsKey(gioco.getId())) {
      throw new Exception("Errore id gioco già presente");
    }
    collezione.put(gioco.getId(), gioco);
    System.out.println(gioco.getTitolo() + " aggiunto!");
  }

  //Metodo per la rimozione di un gioco dalla collezione
  public void rimGioco(int rimuoviId) throws Exception {
    if (!collezione.containsKey(rimuoviId)) {
      throw new Exception("Errore id gioco non presente");
    }

    String giocoRimosso = collezione.get(rimuoviId).getTitolo();

    collezione.remove(rimuoviId);
    System.out.println(giocoRimosso + " è stato rimosso!");
  }

  //Metodo per modificare il prezzo di un elemento,
  //ho scelto di cambiare solo il prezzo in quanto realisticamente parlando
  //in uno store ogni categoria rimane fissa e l'unico dato che può cambiare nel tempo è solo il prezzo
  public void modificaGioco (int idGioco, double nuovoPrezzo) throws Exception {

    Gioco giocoDaAggiornare = collezione.get(idGioco);

    giocoDaAggiornare.setPrezzo(nuovoPrezzo);

    System.out.println("Prezzo del gioc con id: " + idGioco + " | " +
        giocoDaAggiornare.getTitolo() +
        " è stato aggiornato con il nuovo prezzo di: " + nuovoPrezzo);
  }

  //Metodo per stampare tutta la collezione
  public void stampaCollezione() {
    if (collezione.isEmpty()) {
      System.out.println("La tua libreria è vuota!");
    } else {
      collezione.values().forEach(System.out::println);
    }
  }

  //Metodo per la ricerca dell'id
  public void ricercaId (int cercaId) throws Exception {
    if (!collezione.containsKey(cercaId)) {
      throw new Exception("Attenzione id: " + cercaId + " inserito non presente!");
    }
    Gioco giocoTrovato = collezione.get(cercaId);
    System.out.println("Risultato della ricerca: " + giocoTrovato);
  }

  //Metodo per il filtraggio dei giochi indicando il prezzo massimo
  public List<Gioco> ricercaSoldiMax (double maxsoldi) {
    return collezione.values().stream()
        .filter(gioco -> gioco.getPrezzo() <= maxsoldi).toList();
  }

  //Metodo per vedere le statistiche
  public DoubleSummaryStatistics statisticheGenerali(){
    return collezione.values().stream().mapToDouble(Gioco::getPrezzo).summaryStatistics();
  }

  public Map<Integer, Gioco> getCollezione() {
    return collezione;
  }
}
