package entities;

public class Videogioco extends Gioco{

    //Attributi videogioco
    private String piattaforma;
    private int durataGioco;
    private Genere genere;

    public Videogioco (String titolo, int anno, int prezzo, String piattaforma, int durataGioco, Genere genere){
        super(titolo, anno, prezzo );
        this.piattaforma = piattaforma;
        this.durataGioco = durataGioco;
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

  @Override
  public String toString() {
    return super.toString() +
        " piattaforma: " + piattaforma +
        " durata media di una partita: " + durataGioco +
        " genere: " + genere;
  }
}
