package entities;

import java.util.Random;

public abstract class Gioco {
    //Random static e final perchè viene usato per ogni generazione e non cambia
    private static final Random random = new Random();
    //Attributi del gioco generale
    private final int id;
    private final String titolo;
    private final int anno;
    private double prezzo;

    //Costruttore
    public Gioco (String titolo, int anno, double prezzo) {
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

    public void setPrezzo(double prezzo) {
      this.prezzo = prezzo;
    }

  public double getPrezzo() {
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
