package entities;

import java.util.Random;

public abstract class Gioco {
    //Random static e final perchè viene usato per ogni generazione e non cambia
    private static final Random random = new Random();
    //Attributi del gioco generale
    private int id;
    private String title;
    private int anno;
    private int prezzo;

    //Costruttore
    public Gioco (String title, int anno, int prezzo) {
        this.id = random.nextInt(10000, 100000);
        this.title = title;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAnno() {
        return anno;
    }

    public int getPrezzo() {
        return prezzo;
    }
}
