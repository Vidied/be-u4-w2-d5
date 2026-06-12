package entities;

public class GiocoDaTavolo extends Gioco{

    //Attributi gioco da tavolo
    private int numeroGiocatori;
    private int durataMediaPartita;

    public GiocoDaTavolo (String titolo, int anno, int prezzo, int numeroGiocatori, int durataMediaPartita){
        super(titolo, anno, prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        this.durataMediaPartita = durataMediaPartita;
    }
}
