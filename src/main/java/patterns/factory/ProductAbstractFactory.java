package patterns.factory;

/**
 * Factory class astratta, potrà essere estesa tutte le volte che si aggiunge un
 * nuovo 'Prodotto', creando l'adeguato factory concreto
 *
 */
public abstract class ProductAbstractFactory {

    abstract public Prodotto createProduct(String descrizione, int prezzo);

}
