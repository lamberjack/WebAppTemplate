package patterns.decorator;

/**
 *
 * Implementazione concreta Decorator per {@link ApplicationLegacy}. Nel
 * costruttore riceve la classe delegate.
 *
 * @author lamberto.pauletti
 *
 */
public class ApplicationLegacyDecorator extends AbstractApplicationDecorator {

    public ApplicationLegacyDecorator(Application delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doSomething() {
        this.delegate.doSomething();
        System.out.println("Aggiunta specilizzazione legacy!");

    }

}
