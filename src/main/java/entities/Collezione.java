package entities;

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



}
