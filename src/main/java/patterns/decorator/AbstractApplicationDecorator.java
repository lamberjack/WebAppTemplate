package patterns.decorator;

/**
 * Classe decorator astratta che aggiunge le funzionalità comuni a tutti i
 * decorator (classi concrete). In questo caso si ha il riferimento al delegate
 * con il reltivo getter.
 *
 * @author lamberto.pauletti
 *
 */
public abstract class AbstractApplicationDecorator implements Application {

    Application delegate;

    public Application getDelegate() {
        return delegate;
    }

}
