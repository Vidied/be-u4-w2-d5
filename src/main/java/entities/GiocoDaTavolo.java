package entities;

public class GiocoDaTavolo extends Gioco{

    //Attributi gioco da tavolo
    private int numeroGiocatoriMinimo;
    private int numeroGiocatoriMassimo;
    private int durataMediaPartita;

    public GiocoDaTavolo (String titolo, int anno, int prezzo, int numeroGiocatoriMinimo, int numeroGiocatoriMassimo, int durataMediaPartita){
        super(titolo, anno, prezzo);
        this.numeroGiocatoriMinimo = numeroGiocatoriMinimo;
        this.numeroGiocatoriMassimo = numeroGiocatoriMassimo;
        this.durataMediaPartita = durataMediaPartita;
    }

  public int getNumeroGiocatoriMinimo() {
    return numeroGiocatoriMinimo;
  }

  public void setNumeroGiocatoriMinimo(int numeroGiocatoriMinimo) {
    this.numeroGiocatoriMinimo = numeroGiocatoriMinimo;
  }

  public int getNumeroGiocatoriMassimo() {
    return numeroGiocatoriMassimo;
  }

  public void setNumeroGiocatoriMassimo(int numeroGiocatoriMassimo) {
    this.numeroGiocatoriMassimo = numeroGiocatoriMassimo;
  }

  public int getDurataMediaPartita() {
        return durataMediaPartita;
    }

    public void setDurataMediaPartita(int durataMediaPartita) {
        this.durataMediaPartita = durataMediaPartita;
    }
}
