package entities;

public class Videogioco extends Gioco{

    //Attributi videogioco
    private String piattaforma;
    private int durataGioco;
    private final boolean ore;
    private Genere genere;

    public Videogioco (String titolo, int anno, int prezzo, String piattaforma, int durataGioco, boolean ore, Genere genere){
        super(titolo, anno, prezzo );
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
        this.ore = ore;
        this.genere = genere;

    }

    public int getDurataGioco() {
        return durataGioco;
    }

    public void setDurataGioco(int durataGioco) {
        this.durataGioco = durataGioco;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isOre() {
    return ore;
  }

  @Override
  public String toString() {
    String oreMinuti = this.ore ? " ore" : " minuti";
    return "Id del videogioco: " + getId() +
        " titolo del videogioco: " + getTitolo() +
        " anno di uscita del gioco" + getAnno() +
        " prezzo: " + getPrezzo() + "€" +
        " piattaforma: " + piattaforma +
        " durata media di una partita: " + durataGioco + oreMinuti +
        " genere: " + genere;
  }
}
