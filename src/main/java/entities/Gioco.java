package entities;

import java.util.Random;

public abstract class Gioco {
    //Random static e final perchè viene usato per ogni generazione e non cambia
    private static final Random random = new Random();
    //Attributi del gioco generale
    private int id;
    private String titolo;
    private int anno;
    private int prezzo;

    //Costruttore
    public Gioco (String titolo, int anno, int prezzo) {
        this.id = random.nextInt(10000, 100000);
        this.titolo = titolo;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnno() {
        return anno;
    }

    public int getPrezzo() {
        return prezzo;
    }


  @Override
  public String toString() {

      String prezzo2 = (this.getPrezzo() == 0) ? "Free to Play" : this.getPrezzo() + "€";

    return "Id gioco: " + getId() +
        " gioco: " + getTitolo() +
        " anno uscita: " + getAnno() +
        " prezzo: " + prezzo2;
  }
}
