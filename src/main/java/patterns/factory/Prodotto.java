package patterns.factory;

/**
 * classe astratta racchiude le proprietà a comune tra tutti gli oggetti
 * prodotti.
 *
 * @author lamberto.pauletti
 *
 */
public abstract class Prodotto {

    private int prezzo;

    private String descrizione;

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

}
