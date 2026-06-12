package entities;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Collezione {

  Map<Integer, Gioco> collezione = new HashMap<>();

  public void aggGioco(Gioco gioco) throws Exception {
    if (collezione.containsKey(gioco.getId())) {
      throw new Exception("Errore id gioco già presente");
    }
    collezione.put(gioco.getId(), gioco);
    System.out.println(gioco.getTitolo() + " aggiunto!");
  }

  public void stampaCollezione() {
    if (collezione.isEmpty()) {
      System.out.println("La tua libreria è vuota!");
    } else {
      collezione.values().forEach(System.out::println);
    }
  }

  public void ricercaId (int cercaId) throws Exception {
    if (!collezione.containsKey(cercaId)) {
      throw new Exception("Attenzione id: " + cercaId + " inserito non presente!");
    }
    Gioco giocoTrovato = collezione.get(cercaId);
    System.out.println("Risultato della ricerca: " + giocoTrovato);
  }



}
